
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
        roleRight.setRoleId("TROI2017120112345919938099717614");
        roleRight.setRightId("TRII2017120113435502403972293652");
        roleRight.setSysId("TSYI2017120112500261164339974467");
        roleRightService.save(roleRight);
        RoleRight roleRight2=new RoleRight();
        roleRight2.setRoleId("TROI2017120112345919938099717614");
        roleRight2.setRightId("TRII2017120113435519735819607584");
        roleRight2.setSysId("TSYI2017120112500261164339974467");
        roleRightService.save(roleRight2);
        System.out.println("添加成功！");
    }

}
