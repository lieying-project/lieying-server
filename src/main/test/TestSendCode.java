import com.sun.deploy.net.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestSendCode {
//
//    //������֤�������·��URL
//    private static final String
//            SERVER_URL="https://api.netease.im/sms/sendtemplate.action";
//    //�������ŷ�����˺ţ����滻���ڹ����̨Ӧ���������Appkey
//    private static final String
//            APP_KEY="fd460d34e786e7754e505bc4fab0f027";
//    //�������ŷ������Կ�����滻���ڹ����̨Ӧ���������appSecret
//    private static final String APP_SECRET="xxxxxxxx";
//    //�����
//    private static final String NONCE="123456";
//    //����ģ��ID
//    private static final String TEMPLATEID="3057527";
//    //�ֻ��ţ������ߺ����б�JSONArray��ʽ�����ƽ����ߺ���������Ϊ100��
//    private static final String MOBILES="['13888888888','13666666666']";
//    //���Ų����б������������ģ�壬JSONArray��ʽ��ÿ���������Ȳ��ܳ���30��,���ڲ�����������ģ�壬����˲�����ʾģ�弴����ȫ������
//    private static final String PARAMS="['xxxx','xxxx']";
//
//    @Test
//    public void test1(){
//        DefaultHttpClient httpClient = new DefaultHttpClient();
//        HttpPost httpPost = new HttpPost(SERVER_URL);
//        String curTime = String.valueOf((new Date()).getTime() / 1000L);
//        /*
//         * �ο�����CheckSum��java���룬�������ĵ��Ĳ����б��У���CheckSum�ļ����ĵ�ʾ��
//         */
//        String checkSum = CheckSumBuilder.getCheckSum(APP_SECRET, NONCE, curTime);
//
//        // ���������header
//        httpPost.addHeader("AppKey", APP_KEY);
//        httpPost.addHeader("Nonce", NONCE);
//        httpPost.addHeader("CurTime", curTime);
//        httpPost.addHeader("CheckSum", checkSum);
//        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
//
//        // ��������ĵĲ�����requestBody����
//        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
//        /*
//         * 1.�����ģ����ţ���ע�����mobile����s�ģ���ϸ����������ο�������ģ������ĵ���
//         * 2.������ʽ��jsonArray�ĸ�ʽ������ "['13888888888','13666666666']"
//         * 3.params�Ǹ�����ģ�������м���������������Ĳ���Ҳ��jsonArray��ʽ
//         */
//        nvps.add(new BasicNameValuePair("templateid", TEMPLATEID));
//        nvps.add(new BasicNameValuePair("mobiles", MOBILES));
//        nvps.add(new BasicNameValuePair("params", PARAMS));
//
//        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
//
//
//        // ִ������
//        HttpResponse response = (HttpResponse) httpClient.execute(httpPost);
//        /*
//         * 1.��ӡִ�н������ӡ���һ���200��315��403��404��413��414��500
//         * 2.�����code������Ŀ��Բο�������Code״̬��
//         */
//        System.out.println(response.getStatusCode());
//    }
}
