
import com.biocare.authority.bean.Role;
import com.biocare.authority.bean.RoleRight;
import com.biocare.authority.service.RoleRightService;
import com.biocare.authority.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;

/**
 * 角色接口测试用例
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/11/23 17:23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-global.xml")
public class TestRoleService {

    /**
     * 角色业务接口
     */
    @Resource
    private RoleService roleService;

    /**
     * 角色权限业务接口
     */
    @Resource
    private RoleRightService roleRightService;


    /**
     * 插入角色
     */
    @Test
    public void testInsert(){
        Role role = new Role();
        role.setName("管理员");
        role.setStatus(1);
        role.setRemark("管理员");
        roleService.save(role);
        System.out.println("添加成功！");
    }

    /**
     * 插入角色权限
     */
    @Test
    public void testInsertRoleRight(){
        RoleRight roleRight=new RoleRight();
        roleRight.setRoleId("TROI2017112811104544811503166456");
        roleRight.setRightId("TRII2017112811102796669145314424");
        roleRightService.save(roleRight);
        System.out.println("添加成功！");
    }

}
