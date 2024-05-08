package in.ushatech.spring_security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController
{
    @RequestMapping(method = RequestMethod.GET,value = "/myCards")
    public String getCardsDetails()
    {
        return "Cards Details from the DB";
    }
}
