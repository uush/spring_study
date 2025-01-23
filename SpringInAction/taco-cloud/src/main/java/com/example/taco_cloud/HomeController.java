package com.example.taco_cloud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 컴포넌트 검색 시에 HomeController 클래스가 컴포넌트로 식별되게 하는 것이 주 목적이다.
public class HomeController {

    @GetMapping("/") // 루트 경로인 /의 웹 요청 처리
    public String home() {
        return "home"; // 뷰 이름 반환
    }
    
}