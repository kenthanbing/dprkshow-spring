package top.dprkshow.dprkshowspring.shiro;


import top.dprkshow.dprkshowspring.entity.ExProfile;
import top.dprkshow.dprkshowspring.service.ExhibitorService;
import top.dprkshow.dprkshowspring.utils.JwtUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountRealm extends AuthorizingRealm {

    @Autowired
    ExhibitorService exhibitorService;

    // 让realm支持自定义的JwtToken
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken jwtToken) throws AuthenticationException {

        // 提取auth中的token字符串
        String token = (String) jwtToken.getCredentials();

        // 从token中提取username
        String username = JwtUtils.getUsername(token);

        // 根据username获取展商profile
        ExProfile exProfile = exhibitorService.getByUsername(username);
        if (exProfile == null) {
            throw new UnknownAccountException("账户不存在");
        }

        // 校验token
        if(!JwtUtils.verify(token, username, exProfile.getPassword())) {
            throw new AuthenticationException("用户名或密码错误");
        }

//        if (user.getStatus() == -1) {
//            throw new LockedAccountException("账户已被锁定");
//        }

        return new SimpleAuthenticationInfo(exProfile, token, getName());
    }
}
