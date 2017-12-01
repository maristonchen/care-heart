
import com.biocare.authority.bean.Right;
import com.biocare.authority.service.RightService;
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
public class TestRightService {

    /**
     * 权限业务接口
     */
    @Resource
    private RightService rightService;

    /**
     * 插入权限
     */
    @Test
    public void testInsert(){
        Right right =new Right();
        right.setName("社区子菜单1");
        right.setUrl("www.sqbaidu.com");
        right.setStatus(1);
        right.setType(1);
        right.setTag("标签");
        right.setParentId("TSYI2017120112500261164339974467");
        right.setSysId("TSYI2017120112500261164339974467");
        rightService.save(right);

        Right right1 =new Right();
        right1.setName("社区子菜单2");
        right1.setUrl("www.sqsougou.com");
        right1.setStatus(1);
        right1.setType(1);
        right1.setTag("标签");
        right1.setParentId("TSYI2017120112500261164339974467");
        right1.setSysId("TSYI2017120112500261164339974467");
        rightService.save(right1);
        System.out.println("添加成功！");
    }




}
