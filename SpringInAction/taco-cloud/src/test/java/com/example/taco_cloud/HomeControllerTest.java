package com.example.taco_cloud;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(HomeController.class)

public class HomeControllerTest {
    @Autowired   
    private MockMvc mockMvc;

    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/"))
        .andExpect(status().isOk()) //응답 상태 코드가 200인지 확인합니다.
        .andExpect(view().name("home")) // 응답에 대한 뷰의 이름이 "home"인지 확인합니다.
        .andExpect(content().string(containsString("Welcome to..."))); //응답 본문의 내용이 "Welcome to..."인지 확인합니다.
    }
}
