
import com.biocare.authority.bean.Login;
import com.biocare.authority.bean.LoginRole;
import com.biocare.authority.service.LoginRoleService;
import com.biocare.authority.service.LoginService;
import com.biocare.common.utils.CustomDateUtil;
import com.biocare.common.utils.UniqueNoUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;

/**
 * 用户接口测试用例
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/11/23 17:23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-global.xml")
public class TestUserService {

    /**
     * 用户业务接口
     */
    @Resource
    private LoginService loginService;

    /**
     * 用户角色业务接口
     */
    @Resource
    private LoginRoleService loginRoleService;

    /**
     * 插入登录用户
     */
    @Test
    public void testInsert(){
        Login login =new Login();
        login.setUserId(UniqueNoUtil.genNumber(UniqueNoUtil.T_USER_INFO));
        login.setUsername("root");
        login.setPassword("123456");
        login.setSalt("yhxd");
        login.setStatus(1);
        login.setCreateTime(CustomDateUtil.currentDateTime());
        login.setCreateBy("张三");
        loginService.save(login);
        System.out.println("添加成功！");
    }

    /**
     * 插入用户角色
     */
    @Test
    public void testInsertUserRole(){
        LoginRole loginRole =new LoginRole();
        loginRole.setUserId("TUSI2017112811112113685995171436");
        loginRole.setRoleId("TROI2017112811104544811503166456");
        loginRoleService.save(loginRole);
        System.out.println("添加成功！");
    }

}
