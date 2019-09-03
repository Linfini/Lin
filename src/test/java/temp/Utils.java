package temp;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Utils {

    public static String encrypt(String source, String originKey, String iv) throws Exception {
        String key = originKey;
        if (originKey == null) {
            throw new Exception("Key为空null");
        }
        // 判断Key是否为16位
        if (key.length() > 16) {
            key = key.substring(0, 16);
        } else if (key.length() < 16) {
            key = Hex.encodeHexString(DigestUtils.md5(key)).substring(0, 16);
        }

        // Cipher cipher =
        // Cipher.getInstance("AES/CBC/PKCS5Padding");//"算法/模式/补码方式"
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");// "算法/模式/不自动补齐"
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
        // 使用CBC模式，需要一个向量iv，可增加加密算法的强度
        IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);

        // 因为采用NoPadding方式，需要手动补齐源数据byte数为16的整数倍，为和PHP默认补齐方式保持一致，采用\0补齐
        byte[] srcByteArray = source.getBytes("utf-8");

        // 计算需要补\0的位数
        int n = 16 - (source.getBytes("utf-8").length % 16);

        // 如果原始数据就是对齐的，则不再补齐
        if (n == 16) {
            n = 0;
        }

        byte[] byteFillZero = new byte[srcByteArray.length + n];

        System.arraycopy(srcByteArray, 0, byteFillZero, 0, srcByteArray.length);

        for (int i = srcByteArray.length; i < byteFillZero.length; i++) {
            byteFillZero[i] = (byte) '\0';
        }

        byte[] outText = cipher.doFinal(byteFillZero);

        // 此处使用BASE64做转码功能，同时能起到二次加密的作用。
        return Base64.getEncoder().encodeToString(outText);
    }

    public static String decrypt(String source, String originKey, String iv) throws Exception {
        String key = originKey;
        if (originKey == null) {
            throw new Exception("Key为空null");
        }
        // 判断Key是否为16位
        if (key.length() > 16) {
            key = key.substring(0, 16);
        } else if (key.length() < 16) {
            key = Hex.encodeHexString(DigestUtils.md5(key)).substring(0, 16);
        }

        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");// "算法/模式/补码方式"
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");

        // 使用CBC模式，需要一个向量iv，可增加加密算法的强度
        IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

        // 先用base64解密
        byte[] base64DecryptStr = Base64.getDecoder().decode(source);

        byte[] outText = cipher.doFinal(base64DecryptStr);

        // trim去掉最后补齐的\0
        return new String(outText, "utf-8").trim();
    }
}
