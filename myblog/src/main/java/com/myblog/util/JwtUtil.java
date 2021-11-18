package com.myblog.util;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * <p>描述: [JWT工具包] </p>
 * <p>创建时间: 2021/11/16 下午 08:17 </p>
 *
 * @author 李二帅
 * @version v1.0
 */
@Slf4j
@Component
public class JwtUtil {
    /**
     * 过期时间---24 hour 60*60*24
     */
    private static final int EXPIRATION_TIME = 60 * 60 * 24;
    /**
     * 自己设定的秘钥
     */
    private static final String SECRET = "qwertyuiopasdfghjklzxcvbnm124343565767890`-=[];',./";
    /**前缀*/
    public static final String TOKEN_PREFIX = "Bearer ";
    /**表头授权*/
    public static final String AUTHORIZATION = "Authorization";


    /**
     * 签发token
     *
     * @param userName 用户名
     * @return token
     */
    public static String generateToken(String userName,String userRights) {
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        // 设置签发时间
        calendar.setTime(new Date());
        // 设置过期时间   添加秒钟
        calendar.add(Calendar.SECOND, EXPIRATION_TIME);
        Date time = calendar.getTime();
        HashMap<String, Object> map = new LinkedHashMap<>();

        //you can put any data in the map
        map.put("userName", userName);
        map.put("userRights", userRights);
        //jwt前面一般都会加Bearer
        String jwt = Jwts.builder()
                .setClaims(map)
                //签发时间
                .setIssuedAt(now)
                //过期时间
                .setExpiration(time)
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
        return TOKEN_PREFIX + jwt;
    }

    /**
     * 校验Token
     */
    public static Map<String, Object> validateToken(String token) {
        log.info(token);
        try {
            // parse the token.
            Map<String, Object> body = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();
            LinkedHashMap<String, Object> map = new LinkedHashMap<>();
            map.put("nickname",body.get("userName").toString());
            map.put("userRights",body.get("userRights").toString());
            return map;
        }catch (ExpiredJwtException e) {
            throw e;
        } catch (UnsupportedJwtException e) {
            log.info("UnsupportedJwtException");
            throw e;
        } catch (MalformedJwtException e) {
            log.info("MalformedJwtException");
            throw e;
        } catch (SignatureException e) {
            log.info("SignatureException");
            throw e;
        } catch (IllegalArgumentException e) {
            log.info("IllegalArgumentException");
            throw e;
        } catch (Exception e){
            log.info("Exception");
            throw e;
        }
    }
}