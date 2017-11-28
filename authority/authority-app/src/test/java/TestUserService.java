
import com.biocare.authority.bean.User;
import com.biocare.authority.bean.UserRole;
import com.biocare.authority.service.UserRoleService;
import com.biocare.authority.service.UserService;
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
    private UserService userService;

    /**
     * 用户角色业务接口
     */
    @Resource
    private UserRoleService userRoleService;

    /**
     * 插入用户
     */
    @Test
    public void testInsert(){
        User user =new User();
        user.setUsername("root");
        user.setPassword("123456");
        user.setRealName("张三");
        user.setStatus(1);
        userService.save(user);
        System.out.println("添加成功！");
    }

    /**
     * 插入用户角色
     */
    @Test
    public void testInsertUserRole(){
        UserRole userRole =new UserRole();
        userRole.setUserId("TUSI2017112811112113685995171436");
        userRole.setRoleId("TROI2017112811104544811503166456");
        userRoleService.save(userRole);
        System.out.println("添加成功！");
    }

}
