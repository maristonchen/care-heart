
import com.biocare.authority.bean.Group;
import com.biocare.authority.bean.GroupRight;
import com.biocare.authority.service.GroupRightService;
import com.biocare.authority.service.GroupService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * 权限接口测试用例
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/11/23 17:23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-global.xml")
public class TestGroupService {

    /**
     * 权限业务接口
     */
    @Resource
    private GroupService groupService;

    /**
     * 用户组角色业务接口
     */
    @Resource
    private GroupRightService groupRightService;

    /**
     * 插入用户组
     */
    @Test
    public void testInsert(){
        Group group= new Group();
        group.setName("财务部");
        group.setStatus(1);
        group.setRemark("财务");
        groupService.save(group);
        System.out.println("添加成功！");
    }

    /**
     * 插入用户组权限
     */
    @Test
    public void testInsertGroupRight(){
        GroupRight groupRight = new GroupRight();
        groupRight.setGroupId("TGRI2017120114243869436495982094");
        groupRight.setRightId("TRII2017120113382165287303422924");
        groupRight.setSysId("TSYI2017120112500248941448935955");
        groupRightService.save(groupRight);
        System.out.println("添加成功！");
    }

}
