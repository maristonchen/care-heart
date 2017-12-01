import com.alibaba.fastjson.JSON;
import com.biocare.authority.dto.TreeMenuDTO;
import com.biocare.authority.handler.MenuHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/12/1 11:56
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-global.xml")
public class TestMenuHandle {

    /**
     * 菜单业务接口
     */
    @Resource
    private MenuHandler menuHandler;

    /**
     * 菜单测试
     */
    @Test
    public void testMenu(){
        List<TreeMenuDTO> list=menuHandler.listRight("admin");
        System.out.println(JSON.toJSON(list));
    }
}
