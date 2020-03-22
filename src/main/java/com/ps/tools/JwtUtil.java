package com.ps.tools;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {
	
	/**
          * 签名秘钥
     */
    private static final String SECRET = "bi-myblog-token";
    
   /**
    * 签发者
    */
    private static final String ISSUER = "BIXIANSHENG";
    
    /**
          * 生成token
     * @param id 一般传入userName
     * @param claims 信息体
     * @return
     */
    public static String createJwtToken(String id,Map<String,Object> claims){
        //主题
        String subject = "b-token";
        //有效时长
        long ttlMillis = 1000*60*30; 
        return createJwtToken(id, subject, ttlMillis,claims);
    }
    
    /**
     * 生成Token
     * 
     * @param id
          *            编号
     * @param issuer
          *            该JWT的签发者，是否使用是可选的
     * @param subject
          *            该JWT所面向的用户，是否使用是可选的；
     * @param ttlMillis
          *            签发时间
     * @return token String
     */
    public static String createJwtToken(String id, String subject, long ttlMillis,Map<String,Object> claims) {

        // 签名算法 ，将对token进行签名
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        //生成签发时间
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        // 通过秘钥签名JWT
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        // Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder()
        		//如果有私有声明，一定要先设置这个自己创建的私有的声明，这个是给builder的claim赋值，一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明的
            .setClaims(claims)
        	.setId(id)//token id
            .setIssuedAt(now)//签发时间
            .setSubject(subject)//主题
            .setIssuer(ISSUER)//签发者
            .signWith(signatureAlgorithm, signingKey);//签名算法以及密匙
        	//如果有私有声明，一定要先设置这个自己创建的私有的声明，这个是给builder的claim赋值，一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明的
        	//.setClaims(claims)
        // if it has been specified, let's add the expiration
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            //设置过期时间
            builder.setExpiration(exp);
        }

        // Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();

    }
    
    private static Claims parseJWT(String jwt) {
        // This line will throw an exception if it is not a signed JWS (as expected)
        Claims claims = Jwts.parser()
            .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET))
            .parseClaimsJws(jwt).getBody();
        return claims;
    }
    
    /**
          * 获取token验证信息
     * @param token
     */
    public static Map<String, Object> validateToken(String token) {
    	Map<String, Object> resultMap = new HashMap<>();
    	try {
    		Claims claims = parseJWT(token);
    		//获取过期时间
    		Date exp = claims.getExpiration();
    		
    		//获取当前时间
    		long now = System.currentTimeMillis();
    		//过去时间
    		long expTime = exp.getTime();
    		
    		if (now > expTime) {//过期
    			resultMap.put("result", 0);
    		} else {
    			resultMap.put("result", 1);
    		}    		
    		resultMap.put("body", claims);
		} catch (Exception e) {
			//token解析异常
			resultMap.put("result", -1);
		}
    	return resultMap;
    }
    
    /**
	 * 判断token是否有效
	 * @param token
	 * @return
	 */
	public static boolean isValid (String token) {
		Map<String,Object> ts = validateToken(token);
		Integer result = (Integer) ts.get("result");
		return result == 1 ? true : false;
	}
	
	/*public static void main(String[] args) {
		Map<String,Object> claims = new HashMap<>();
		claims.put("username", "唐伯虎");
		claims.put("nikeName", "xxxxxxxxxxxxx");
		String token = JwtUtil.createJwtToken("123", claims);
		System.out.println(token);
		//System.out.println(JwtUtil.parseJWT("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJiLXRva2VuIiwiaXNzIjoiQklYSUFOU0hFTkciLCJuaWtlTmFtZSI6Inh4eHh4eHh4eHh4eHgiLCJleHAiOjE1NjQxMjI4NTYsImlhdCI6MTU2NDEyMTY1NiwianRpIjoiMTIzIiwidXNlcm5hbWUiOiLllJDkvK_omY4ifQ.ZGZzLM1TYZfqtbU9LBJAL9g-ULJ62-71r3CT_VgiQp4"));
	}*/
	
}
