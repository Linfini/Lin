package thinkinjava.nettest;

import org.junit.Test;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Enumeration;

public class NetTest {
    public static String getIpAddress() {
        try {
            Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = allNetInterfaces.nextElement();
                Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress ip = addresses.nextElement();
                    if (ip instanceof Inet4Address && ip.isSiteLocalAddress() && !ip.isLoopbackAddress()) {

                    }
                }

            }
        } catch (Exception e) {
            // _logger.error("IP地址获取失败", e);
            e.printStackTrace();
        }
        return "";
    }

    @Test
    public void test1() throws UnknownHostException {
        InetAddress host = InetAddress.getLocalHost();
        System.out.println(Arrays.toString(host.getAddress()));
        System.out.println(host.getHostAddress());
        System.out.println(host.getHostName());
    }

    //不知道和上面有啥区别
    @Test
    public void test2() {
        String ipAddress = getIpAddress();
        System.out.println(ipAddress);
    }
}
