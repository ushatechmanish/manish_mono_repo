package in.ushatech.spring_security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController
{
    @RequestMapping(method = RequestMethod.GET,value = "/myBalance")
    public String getBalanceDetails()
    {
        return "Balance Details from the DB";
    }
}
