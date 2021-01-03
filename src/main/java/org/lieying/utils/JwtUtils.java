package org.lieying.utils;



import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.JwtSigner;
import org.bouncycastle.util.encoders.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


public class JwtUtils {
    public static  ConcurrentHashMap<Integer,String> onlineJobHunters=new ConcurrentHashMap<>();
   static class Constant{


        public static final String JWT_ID = UUID.randomUUID().toString(); //生成的token
        public static final String JWT_SECRET = "fssFSS";//加密密文
        public static final int JWT_TTL = 2000/*60*60*1000*/;  //过期时间 3600000
    }
    /**
     * 创建jwt
     * @param id        自定义的密文
     * @param issuer    发布者的url地址   （jwt签发人）
     * @param subject   代表这个JWT的主体，即它的所有人，这个是一个json格式的字符串，可以存放什么userid，roldid之类的，作为什么用户的唯一标志
     * @param ttlMillis 有效时间（多长时间有效）
     * @return
     * @throws Exception
     */
    public static String createJWT(String id, String issuer, String subject, long ttlMillis) {
         //指定签名算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //生成JWT的时间
        long nowMillis = System.currentTimeMillis();

        Date now = new Date(nowMillis);

        //生成签名的时候使用的秘钥secret,这个方法本地封装了的，一般可以从本地配置文件中读取，切记这个秘钥不能外露哦。
        // 它就是你服务端的私钥，在任何场景都不应该流露出去。一旦客户端得知这个secret, 那就意味着客户端是可以自我签发jwt了。
        SecretKey key = generalKey();
        // 下面就是在为payload添加各种标准声明和私有声明了
        JwtBuilder jwtBuilder= Jwts.builder() // 这里其实就是new一个JwtBuilder，设置jwt的body
                .setId(id)// 设置jti(JWT ID)：是JWT的唯一标识，根据业务需要，这个可以设置为一个不重复的值，主要用来作为一次性token,从而回避重放攻击。
                .setIssuedAt(now)// iat: jwt的签发时间
                .setIssuer(issuer) // issuer：jwt签发人
                .setSubject(subject) // sub(Subject)：代表这个JWT的主体，即它的所有人，这个是一个json格式的字符串，可以存放什么userid，roldid之类的，作为什么用户的唯一标志。
                .signWith(signatureAlgorithm,key);// 设置签名使用的签名算法和签名使用的秘钥
        if (ttlMillis>=0){
            long expMillis=nowMillis+ttlMillis;
            Date expDate=new Date(expMillis);
            jwtBuilder.setExpiration(expDate);//设置过期时间
        }
        return jwtBuilder.compact();

    }

    /**
     * 解密jwt
     *
     * @param jwt
     * @return
     * @throws Exception
     */
    public static Claims parseJWT(String jwt){
        SecretKey key=generalKey(); //签名秘钥，和生成的签名的秘钥一模一样
        Claims claims = Jwts.parser()               //得到DefaultJwtParser
                .setSigningKey(key)                 //设置签名的秘钥
                .parseClaimsJws(jwt).getBody();     //设置需要解析的jwt

        return claims;
    }
    /**
     * 由字符串生成加密key
     * @return
     */
    public static SecretKey generalKey(){
        String stringKey = Constant.JWT_SECRET;//本地配置文件中加密的密文7786df7fc3a34e26a61c034d5ec8245d
        byte[] encodedKey = Base64.decode(stringKey);//本地的密码解码[B@152f6e2
       // System.out.println(encodedKey);
        //System.out.println(Base64.encode(encodedKey));
        //根据给定的字节数组使用AES加密算法构造一个密钥，使用 encodedKey中的始于且包含 0 到前 leng 个字节这是当然是所有。
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    public static void main(String[] args) {
        JwtUtils jwtUtils = new JwtUtils();
        String ab = jwtUtils.createJWT("jwt", "1ddddd","{id:100,name:xiaohong}", 60000);
        System.out.println(ab);
        Claims claims=jwtUtils.parseJWT(ab);
        System.out.println(claims.getId());
        System.out.println(claims.getSubject());
        System.out.println(claims.getIssuer());
        System.out.println(claims.getIssuedAt());
        String cd="eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1OTkwMDg4MTYsImlzcyI6IjFkZGRkZCIsInN1YiI6IntpZDoxMDAsbmFtZTp4aWFvaG9uZ30iLCJleHAiOjE1OTkwMDg4NzZ9.j1T_mv_jboE_55ifsTH5Nw3qVbqzlr6xQmahZ6PrJts";
        System.out.println(cd.equals(ab));
    }

}