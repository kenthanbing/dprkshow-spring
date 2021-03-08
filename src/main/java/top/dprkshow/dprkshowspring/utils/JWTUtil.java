package top.dprkshow.dprkshowspring.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import top.dprkshow.dprkshowspring.entity.LoginInfo;

import java.io.UnsupportedEncodingException;
import java.util.Date;

public class JWTUtil {

    // 过期时间5分钟
    private static final long EXPIRE_TIME = 5*60*1000;

    /**
     * 生成token,5min后过期
     * @param loginInfo 携带用户名和密码的对象
     * @return 加密的token
     */
    public static String genToken(LoginInfo loginInfo) {
        try {
            Date date = new Date(System.currentTimeMillis()+EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(loginInfo.getPassword());
            // 生成token，附带username信息
            return JWT.create()
                    .withClaim("username", loginInfo.getUsername())
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

}
