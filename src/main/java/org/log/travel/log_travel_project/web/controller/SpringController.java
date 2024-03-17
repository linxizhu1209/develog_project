package org.log.travel.log_travel_project.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SpringController {

    @GetMapping("/write")
    public String writeLog(){
        return "writeLog";  // 스프링 글쓰기 페이지
    }

    @PostMapping("read")
    public String readLog(){
        return "spring"; // 글 다 쓰면 해당 카테고리 페이지로 이동
    }

}
