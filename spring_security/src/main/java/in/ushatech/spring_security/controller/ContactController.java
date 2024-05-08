package in.ushatech.spring_security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController
{
    @RequestMapping(method = RequestMethod.GET,value = "/contact")
    public String saveContactDetails()
    {
        return "contact Details saved to the DB";
    }
}
