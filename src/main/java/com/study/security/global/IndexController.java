package com.study.security.global;

import com.study.security.domain.member.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    //private final HttpSession httpSession;

    @GetMapping({"/", "/index"})
    public String index(HttpServletRequest request){
        //String str = (String)httpSession.getAttribute("user");
        System.out.println("dmdkdkdk?? ");
        return "index.html";
    }
}
