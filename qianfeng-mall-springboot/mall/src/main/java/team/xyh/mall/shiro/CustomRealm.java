package team.xyh.mall.shiro;

import com.mysql.cj.util.TestUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import team.xyh.mall.controller.LoginController;
import team.xyh.mall.pojo.Permission;
import team.xyh.mall.pojo.Role;
import team.xyh.mall.pojo.User;
import team.xyh.mall.service.UserService;
import team.xyh.mall.utils.SpringContextUtil;

import javax.annotation.PostConstruct;
import java.util.List;

public class CustomRealm extends AuthorizingRealm {

    @Override
    /**
     * 认证
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //1.获取用户输入的账号
        String username = (String)token.getPrincipal();
        //2.通过username从数据库中查找到user实体
        SpringContextUtil springContextUtil = new SpringContextUtil();
        User user = springContextUtil.getUserByUsername(username);
        if(user == null){
            return null;
        }
        //3.通过SimpleAuthenticationInfo做身份处理
        SimpleAuthenticationInfo simpleAuthenticationInfo =
                new SimpleAuthenticationInfo(user,user.getPassword(),getName());
        //4.用户账号状态验证等其他业务操作
        if(!user.getStatus()){
            throw new AuthenticationException("该账号已经被禁用");
        }
        //5.返回身份处理对象
        return simpleAuthenticationInfo;
    }

    @Override
    /**
     * 授权
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        SpringContextUtil springContextUtil = new SpringContextUtil();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user = (User)principal.getPrimaryPrincipal();
        List<Role> roles = springContextUtil.getRoleById(user.getId());
        for (Role role : roles) {
            System.out.println(role);
            authorizationInfo.addRole(role.getName());
        }
        List<Permission> permissions = springContextUtil.getPermissionById(user.getId());
        for (Permission permission : permissions) {
            System.out.println(permission);
            authorizationInfo.addStringPermission(permission.getUrl());
        }
        return authorizationInfo;
    }
}