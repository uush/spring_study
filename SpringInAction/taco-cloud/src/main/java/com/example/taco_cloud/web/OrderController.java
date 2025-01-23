package com.example.taco_cloud.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.taco_cloud.Order;

import org.springframework.ui.Model;
import lombok.extern.slf4j.Slf4j;


@Slf4j // SLF4J Logger 객체 생성, 주문 상세 내역을 log로 기록
@Controller
@RequestMapping("./orders") // ./orders로 시작하는 경로의 요청을 해당 컨트롤러의 요청 처리 메서드가 처리한다.
public class OrderController {

    @GetMapping("/current")
    public String orderForm(Model model){
        model.addAttribute("order",  new Order());
        return "orderForm";
    }

    @PostMapping
    // 제출된 폼 필드와 바인딩된 속성을 갖는 Order 객체가 인자로 전달
    public String processOrder(Order order){
        log.info("Order submitted: " + order);
        return "redirect:/";
    }

}
