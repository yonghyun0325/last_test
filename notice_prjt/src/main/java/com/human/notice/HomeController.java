package com.human.notice;

import java.text.DateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
    public String home() {
        return "notice_list"; // 시작 페이지를 notice_list.jsp로 설정
    }
}
