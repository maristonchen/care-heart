
import com.biocare.authority.bean.Right;
import com.biocare.authority.service.RightServcie;
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
    private RightServcie rightServcie;

    /**
     * 插入权限
     */
    @Test
    public void testInsert(){
        Right right =new Right();
        right.setName("菜单1");
        right.setUrl("www.baidu.com");
        right.setStatus(1);
        right.setType(1);
        right.setTag("标签");
        rightServcie.save(right);
        System.out.println("添加成功！");
    }




}
