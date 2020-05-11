package leib.shiro.config;

import com.sun.xml.internal.ws.resources.UtilMessages;
import leib.shiro.entity.User;
import leib.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author:Leib
 * @Date 2020/5/7 13:40
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //info.addStringPermission("level1");

        Subject subject = SecurityUtils.getSubject();
        User currUser = (User) subject.getPrincipal();

        info.addStringPermission(currUser.getPerms());

        return info;
    }
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行认证");

/*        String name = "root";
        String password = "0000" ;*/

        UsernamePasswordToken userToken = (UsernamePasswordToken) token;

        User user = userService.queryByName(userToken.getUsername());

        if(user==null){
            return null;
        }


        /*        if(!userToken.getUsername().equals(name)){
            return null;
        }*/

        return new SimpleAuthenticationInfo(user,user.getPwd(),"");
    }
}
