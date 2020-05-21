package com.itmck.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Create by it_mck 2020/5/18 23:06
 *
 * @Description:
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private  TestController estController;

    @Test
    public void bookinfo() throws Exception {


        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/thy/pojo"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println("content" + content);
    }

    @Test
    public void indexPage() {
    }

    @Test
    public void indexPojo() {
    }

    @Test
    public void index() {
    }
}