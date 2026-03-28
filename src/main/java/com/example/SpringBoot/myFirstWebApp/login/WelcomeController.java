package com.example.SpringBoot.myFirstWebApp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class WelcomeController {


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String goToWelcomePage(ModelMap map){
        map.put("name",getAuthUserName());
        return "welcome";
    }

    private String getAuthUserName(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        assert authentication != null;
        return authentication.getName();
    }


}
