package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi") // hi라는 url을 입력받았을 때 greetings를 찾아서 반환해준다. 즉, 이 메서드는 hi라는 url의 요청으로 실행이 되는 것
    public String niceToMeetYou(Model model){
        model.addAttribute("username", "kimjungwoo");
        return "greetings"; // templates/greetings.mustache -> 브라우저로 전송!
    }

    @GetMapping("/bye")
    public String seeYouNext(Model model){
        model.addAttribute("nickname", "홍길동");
        return "goodbye";
    }

}
