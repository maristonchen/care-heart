
import com.biocare.authority.bean.System;
import com.biocare.authority.service.SystemService;
import com.biocare.common.utils.UniqueNoUtil;
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
public class TestSystemService {

    /**
     * 权限业务接口
     */
    @Resource
    private SystemService systemService;

    /**
     * 插入权限
     */
    @Test
    public void testInsert(){
        System system = new System();
        system.setName("商城");
        system.setUrl("www.shopping.com");
        system.setStatus(1);
        systemService.save(system);

        System system1 = new System();
        system1.setName("社区");
        system1.setUrl("www.shequ.com");
        system1.setStatus(1);
        systemService.save(system1);

        java.lang.System.out.println("添加成功！");
    }




}
