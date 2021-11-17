package com.myblog.util;

import io.jsonwebtoken.*;

import java.util.*;

/**
 * <p>描述: [JWT工具包] </p>
 * <p>创建时间: 2021/11/16 下午 08:17 </p>
 *
 * @author 李二帅
 * @version v1.0
 */
public class JwtUtil {
    /**过期时间---24 hour 60*60*24 */
    private static final int EXPIRATION_TIME = 60*60*24;
    /**自己设定的秘钥*/
    private static final String SECRET = "023bdc63c3c5a4587*9ee6581508b9d03ad39a74fc0c9a9cce604743367c9646b";
    /**前缀*/
    public static final String TOKEN_PREFIX = "Bearer ";
    /**表头授权*/
    public static final String AUTHORIZATION = "Authorization";

    /**
     * 签发token
      * @param userName 用户名
     * @return token
     */
    public static String generateToken(String userName,String userRights) {
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        // 设置签发时间
        calendar.setTime(new Date());
        // 设置过期时间
        // 添加秒钟
        calendar.add(Calendar.SECOND, EXPIRATION_TIME);
        Date time = calendar.getTime();
        // 用户自定义属性
        HashMap<String, Object> map = new LinkedHashMap<>();
        map.put("userName", userName);
        map.put("userRights",userRights);
        String jwt = Jwts.builder()
                // 自定义属性 放入用户名和拥有的权限
                .setClaims(map)
                //签发时间
                .setIssuedAt(now)
                //过期时间
                .setExpiration(time)
                // 签名算法和密钥
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
        //jwt前面一般都会加Bearer
        return TOKEN_PREFIX + jwt;
    }

    /**
     * 验证token
     * @param token token
     * @return 用户名
     */
    public static Map<String, Object> validateToken(String token) {
        try {
            Map<String, Object> body = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();
            LinkedHashMap<String, Object> map = new LinkedHashMap<>();
            map.put("userName",body.get("userName").toString());
            map.put("userRights",body.get("userRights").toString());
            return map;
        }catch (ExpiredJwtException e) {
            throw e;
        } catch (UnsupportedJwtException e) {
            throw e;
        } catch (MalformedJwtException e) {
            throw e;
        } catch (SignatureException e) {
            throw e;
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e){
            throw e;
        }
    }
}