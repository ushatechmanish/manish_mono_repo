package in.ushatech.spring_security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController
{
    @RequestMapping(method = RequestMethod.GET,value = "/myAccount")
    public String getAccountDetails()
    {
        return "Account Details from the DB";
    }
}
