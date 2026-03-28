package com.example.SpringBoot.myFirstWebApp.hello;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class sayHelloController {

    @RequestMapping("/hello")
    public String sayHello(){
        return "sayHello";
    }
}
