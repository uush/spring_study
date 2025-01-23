package com.example.taco_cloud.web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import com.example.taco_cloud.Taco;
import com.example.taco_cloud.Ingredient;
import com.example.taco_cloud.Ingredient.Type;



@Slf4j
@Controller
@RequestMapping("/design") // 해당 컨트롤러가 처리하는 요청의 종류를 나타낸다. /design으로 시작한느 경로의 요청 처리 
public class DesignTacoController {

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
            new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
            new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
            new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
            new Ingredient("CARN", "Carnitas", Type.PROTEIN),
            new Ingredient("TMTO", "Dices Tomatoes", Type.VEGGIES),
            new Ingredient("LETC", "Lettuce", Type.VEGGIES),
            new Ingredient("CHED", "Cheddar", Type.CHEESE),
            new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
            new Ingredient("SLSA", "Salsa", Type.SAUCE),
            new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
        );

        Type[] types = Ingredient.Type.values(); // WRAP | PROTEIN | CHEESE | VEGGIES | SAUCE

        for(Type type : types){
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type)); // 필터링된 재료 리스트를 모델에 추가
        }

        model.addAttribute("taco",new Taco());

        return "design"; // 모델 데이터를 브라우저에 나타내는 데 사용될 뷰의 논리적인 이름
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type){
        return ingredients.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
    }

    @PostMapping
    public String processDesign(Taco design){ 
        log.info("Processing design: " + design);

        return "redirect:/orders/current";
    }

}