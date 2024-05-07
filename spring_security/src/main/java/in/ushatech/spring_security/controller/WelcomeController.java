package in.ushatech.spring_security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController
{
    @RequestMapping(method = RequestMethod.GET,value = "/hello")
    public String getWelocomeMessage()
    {
        return "Welcome to secured spring boot application with static credentials";
    }
}
