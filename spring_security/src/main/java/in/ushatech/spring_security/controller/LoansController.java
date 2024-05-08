package in.ushatech.spring_security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController
{
    @RequestMapping(method = RequestMethod.GET,value = "/myLoans")
    public String getLoansDetails()
    {
        return "Loans Details from the DB";
    }
}
