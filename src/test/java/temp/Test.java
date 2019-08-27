package temp;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import static temp.Utils.decrypt;
import static temp.Utils.encrypt;

public class Test {

    @org.junit.Test
    public void testGr() {
        try {
            //String id = EncryptionXsjUtil.encrypt("10678,11411,11412,11416,11614,11709,11711,11733,11744,11755,11776,11909,11913,12026,12027,12063,12065,12069,12082,12083,12096,12099,12123,12307,12311,12775,12777,12780,12929,12930,12931,12932,12933,12934,13257,13261,13427,13428,13561,13562,13563,13569,13573,13739,13740,13741,13742,13743,13744,13746,13747,13748,13835,13913,13914,13933,13934,13935,13936,13937,13938,13939,13942,13943,13944,13945,13946,13947,13948,13949,13950,13951,13952,13953,13954,13955,13956,13957,13958,13959,13960,13961,13962,13963,13964,13965,13966,13967,13968,13969,13970,13971,13972,13973,13974,13975,13976,13977,13978,13979,13980,13981,13982,13983,13990,13991,13992,13999,14604,14844,14845,14847,15080,15533,15534,15535,15536,15537,15538,15539,15540,15541,15542,15543,15908,15912,15913,16117,16326,16327,16328,16329,16330,16331,16332,16333,16336,16418,16828,16829,16830,16832,16935,17237,17238,17239,17240,17241,17372,17417,17418,17419,17420,17421,17422,17423,17424,17941,17942,17943,17944,17945,18159,18237,18375,18563,18622,18744,18745,18791,1879", "5xUy29dHeKOPWJ32","5xUy29dHeKOPWJ32");
//		String dy=EncryptionXsjUtil.encrypt("北京", "5xUy29dHeKOPWJ32","5xUy29dHeKOPWJ32");
//		String sblx=EncryptionXsjUtil.encrypt("台式机", "5xUy29dHeKOPWJ32","5xUy29dHeKOPWJ32");
//		String sblxej=EncryptionXsjUtil.encrypt("台式机", "5xUy29dHeKOPWJ32","5xUy29dHeKOPWJ32");
//		String sbzt=EncryptionXsjUtil.encrypt("使用中", "5xUy29dHeKOPWJ32","5xUy29dHeKOPWJ32");
//		String syrbm=EncryptionXsjUtil.encrypt("西山居", "5xUy29dHeKOPWJ32","5xUy29dHeKOPWJ32");
            //入参 条件为空请设置""或者null
            JSONObject param= new JSONObject();
            param.put("dy", null);
            param.put("sblx", "台式机");
            param.put("sblxej", "台式机");
            param.put("sbzt", "使用中");
            param.put("syrbm", "西山居");
            param.put("pagenow", 1);

            //String param1="dy="+dy+"&sblx="+sblx+"&sblxej="+sblxej+"&sbzt="+sbzt+"&syrbm="+syrbm+"";
            HttpClient client = new DefaultHttpClient();
            String path = "http://192.168.141.48:8080/remoteapi/xsj/getGrdzsbTycx?token=2f354b4e08194a3ab3b5d08b514152f9";
            HttpPost post = new HttpPost(path);

            StringEntity entity = new StringEntity(encrypt(param.toString(), "5xUy29dHeKOPWJ32","5xUy29dHeKOPWJ32"), "UTF-8");
            post.setEntity(entity);
            HttpResponse response = client.execute(post);
            System.out.println("响应状态码：" + response.getStatusLine().getStatusCode());
            InputStream is = response.getEntity().getContent();

            String result = "";
            BufferedReader reader = null;
            reader = new BufferedReader(new InputStreamReader(is));
            result = reader.readLine();
            System.out.println("服务器端响应的数据：" + decrypt(result, "5xUy29dHeKOPWJ32","5xUy29dHeKOPWJ32"));



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public  void testIdc() {
        try {
            //String id = EncryptionXsjUtil.encrypt("10678,11411,11412,11416,11614,11709,11711,11733,11744,11755,11776,11909,11913,12026,12027,12063,12065,12069,12082,12083,12096,12099,12123,12307,12311,12775,12777,12780,12929,12930,12931,12932,12933,12934,13257,13261,13427,13428,13561,13562,13563,13569,13573,13739,13740,13741,13742,13743,13744,13746,13747,13748,13835,13913,13914,13933,13934,13935,13936,13937,13938,13939,13942,13943,13944,13945,13946,13947,13948,13949,13950,13951,13952,13953,13954,13955,13956,13957,13958,13959,13960,13961,13962,13963,13964,13965,13966,13967,13968,13969,13970,13971,13972,13973,13974,13975,13976,13977,13978,13979,13980,13981,13982,13983,13990,13991,13992,13999,14604,14844,14845,14847,15080,15533,15534,15535,15536,15537,15538,15539,15540,15541,15542,15543,15908,15912,15913,16117,16326,16327,16328,16329,16330,16331,16332,16333,16336,16418,16828,16829,16830,16832,16935,17237,17238,17239,17240,17241,17372,17417,17418,17419,17420,17421,17422,17423,17424,17941,17942,17943,17944,17945,18159,18237,18375,18563,18622,18744,18745,18791,1879", "5xUy29dHeKOPWJ32","5xUy29dHeKOPWJ32");
//		String dy=EncryptionXsjUtil.encrypt("北京", "5xUy29dHeKOPWJ32","5xUy29dHeKOPWJ32");
//		String sblx=EncryptionXsjUtil.encrypt("台式机", "5xUy29dHeKOPWJ32","5xUy29dHeKOPWJ32");
//		String sblxej=EncryptionXsjUtil.encrypt("台式机", "5xUy29dHeKOPWJ32","5xUy29dHeKOPWJ32");
//		String sbzt=EncryptionXsjUtil.encrypt("使用中", "5xUy29dHeKOPWJ32","5xUy29dHeKOPWJ32");
//		String syrbm=EncryptionXsjUtil.encrypt("西山居", "5xUy29dHeKOPWJ32","5xUy29dHeKOPWJ32");
            //入参 条件为空请设置""或者null
            JSONObject param= new JSONObject();
            param.put("pagenow", 1);

            //String param1="dy="+dy+"&sblx="+sblx+"&sblxej="+sblxej+"&sbzt="+sbzt+"&syrbm="+syrbm+"";
            HttpClient client = new DefaultHttpClient();
            //String path = "http://koq.kingsoft.cn/remoteapi/xsj/getIdcGlycx?token=feb59dc2ebbf4ba798284efd1435956e";
            String path = "http://192.168.141.48:8088/remoteapi/xsj/getIdcGlycx?token=9aac06df03c342c9a5def5a919f4e9b5";
            HttpPost post = new HttpPost(path);

            StringEntity entity = new StringEntity(encrypt(param.toString(), "5xUy29dHeKOPWJ32","5xUy29dHeKOPWJ32"), "UTF-8");
            post.setEntity(entity);
            HttpResponse response = client.execute(post);
            System.out.println("响应状态码：" + response.getStatusLine().getStatusCode());
            InputStream is = response.getEntity().getContent();

            String result = "";
            BufferedReader reader = null;
            reader = new BufferedReader(new InputStreamReader(is));
            result = reader.readLine();
            System.out.println("服务器端响应的数据：" + decrypt(result, "5xUy29dHeKOPWJ32","5xUy29dHeKOPWJ32"));



        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public  void testZclb() {
        try {
            //String id = EncryptionXsjUtil.encrypt("10678,11411,11412,11416,11614,11709,11711,11733,11744,11755,11776,11909,11913,12026,12027,12063,12065,12069,12082,12083,12096,12099,12123,12307,12311,12775,12777,12780,12929,12930,12931,12932,12933,12934,13257,13261,13427,13428,13561,13562,13563,13569,13573,13739,13740,13741,13742,13743,13744,13746,13747,13748,13835,13913,13914,13933,13934,13935,13936,13937,13938,13939,13942,13943,13944,13945,13946,13947,13948,13949,13950,13951,13952,13953,13954,13955,13956,13957,13958,13959,13960,13961,13962,13963,13964,13965,13966,13967,13968,13969,13970,13971,13972,13973,13974,13975,13976,13977,13978,13979,13980,13981,13982,13983,13990,13991,13992,13999,14604,14844,14845,14847,15080,15533,15534,15535,15536,15537,15538,15539,15540,15541,15542,15543,15908,15912,15913,16117,16326,16327,16328,16329,16330,16331,16332,16333,16336,16418,16828,16829,16830,16832,16935,17237,17238,17239,17240,17241,17372,17417,17418,17419,17420,17421,17422,17423,17424,17941,17942,17943,17944,17945,18159,18237,18375,18563,18622,18744,18745,18791,1879", "5xUy29dHeKOPWJ32","5xUy29dHeKOPWJ32");
//		String dy=EncryptionXsjUtil.encrypt("北京", "5xUy29dHeKOPWJ32","5xUy29dHeKOPWJ32");
//		String sblx=EncryptionXsjUtil.encrypt("台式机", "5xUy29dHeKOPWJ32","5xUy29dHeKOPWJ32");
//		String sblxej=EncryptionXsjUtil.encrypt("台式机", "5xUy29dHeKOPWJ32","5xUy29dHeKOPWJ32");
//		String sbzt=EncryptionXsjUtil.encrypt("使用中", "5xUy29dHeKOPWJ32","5xUy29dHeKOPWJ32");
//		String syrbm=EncryptionXsjUtil.encrypt("西山居", "5xUy29dHeKOPWJ32","5xUy29dHeKOPWJ32");
            //入参 条件为空请设置""或者null
//		JSONObject param= new JSONObject();
//		param.put("pagenow", 1);

            //String param1="dy="+dy+"&sblx="+sblx+"&sblxej="+sblxej+"&sbzt="+sbzt+"&syrbm="+syrbm+"";
            HttpClient client = new DefaultHttpClient();
            //String path = "http://koq.kingsoft.cn/remoteapi/xsj/getIdcGlycx?token=feb59dc2ebbf4ba798284efd1435956e";
            String path = "http://192.168.141.48:8088/remoteapi/xsj/getZclb?token=450a099e519b4b93bbf00ba902b3254b";
            HttpPost post = new HttpPost(path);

//		StringEntity entity = new StringEntity(EncryptionXsjUtil.encrypt(param.toString(), "5xUy29dHeKOPWJ32","5xUy29dHeKOPWJ32"), "UTF-8");
//		post.setEntity(entity);
            HttpResponse response = client.execute(post);
            System.out.println("响应状态码：" + response.getStatusLine().getStatusCode());
            InputStream is = response.getEntity().getContent();

            String result = "";
            BufferedReader reader = null;
            reader = new BufferedReader(new InputStreamReader(is));
            result = reader.readLine();
            System.out.println("服务器端响应的数据：" + decrypt(result, "5xUy29dHeKOPWJ32","5xUy29dHeKOPWJ32"));



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void testZczt() {
        try {
            HttpClient client = new DefaultHttpClient();
            String path = "http://192.168.141.48:8088/remoteapi/xsj/getZczt?token=22626e9e58cf478b8a546388bd4aacd0";
            HttpPost post = new HttpPost(path);

            HttpResponse response = client.execute(post);
            System.out.println("响应状态码：" + response.getStatusLine().getStatusCode());
            InputStream is = response.getEntity().getContent();

            String result = "";
            BufferedReader reader = null;
            reader = new BufferedReader(new InputStreamReader(is));
            result = reader.readLine();
            System.out.println("服务器端响应的数据：" + decrypt(result, "5xUy29dHeKOPWJ32","5xUy29dHeKOPWJ32"));



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  void testIdcadd() {
        try {
            HttpClient client = new DefaultHttpClient();
            String path = "http://192.168.141.48:8088/remoteapi/xsj/getAddIdcGlycx?token=9aac06df03c342c9a5def5a919f4e9b5";
            HttpPost post = new HttpPost(path);

            HttpResponse response = client.execute(post);
            System.out.println("响应状态码：" + response.getStatusLine().getStatusCode());
            InputStream is = response.getEntity().getContent();

            String result = "";
            BufferedReader reader = null;
            reader = new BufferedReader(new InputStreamReader(is));
            result = reader.readLine();
            System.out.println("服务器端响应的数据：" + decrypt(result, "5xUy29dHeKOPWJ32","5xUy29dHeKOPWJ32"));



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  void testGradd() {
        try {
            HttpClient client = new DefaultHttpClient();
            String path = "http://192.168.141.48:8088/remoteapi/xsj/getAddGrdzsbTycx?token=9aac06df03c342c9a5def5a919f4e9b5";
            HttpPost post = new HttpPost(path);

            HttpResponse response = client.execute(post);
            System.out.println("响应状态码：" + response.getStatusLine().getStatusCode());
            InputStream is = response.getEntity().getContent();

            String result = "";
            BufferedReader reader = null;
            reader = new BufferedReader(new InputStreamReader(is));
            result = reader.readLine();
            System.out.println("服务器端响应的数据：" + decrypt(result, "5xUy29dHeKOPWJ32","5xUy29dHeKOPWJ32"));



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
