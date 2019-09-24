import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
@WebAppConfiguration
public class ControllerTest {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void getHostelCanLivingTest() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        Map<String, String> param = new HashMap<>();
        param.put("hostelId", "1");
        param.put("checkInDate", "2019-08-20");
        param.put("checkOutDate", "2019-08-31");
        mockMvc.perform(get("/getHostelCanLiving.html").accept(MediaType.APPLICATION_FORM_URLENCODED).param("hostelId", "1").param("checkInDate", "2019-08-20").param("checkOutDate", "2019-08-31")).andExpect(status().isOk()).andDo(print());
    }
}
