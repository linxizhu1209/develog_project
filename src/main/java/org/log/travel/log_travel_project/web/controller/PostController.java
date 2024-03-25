package org.log.travel.log_travel_project.web.controller;

import lombok.RequiredArgsConstructor;
import org.log.travel.log_travel_project.repository.entity.Enum.Category;
import org.log.travel.log_travel_project.repository.entity.PostService;
import org.log.travel.log_travel_project.web.dto.RequestPosting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/v1/develog")
public class PostController {

    private final PostService postService;
    @PostMapping("/save")
    public String savePost(@ModelAttribute("post") RequestPosting requestPosting){
        postService.savePost(requestPosting);
        return "redirect:/v1/develog";
    }



    @PostMapping("read")
    public String readLog(){
        return "spring"; // 글 다 쓰면 해당 카테고리 페이지로 이동
    }



}
