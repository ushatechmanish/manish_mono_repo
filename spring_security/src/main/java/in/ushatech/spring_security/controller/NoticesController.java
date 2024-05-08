package in.ushatech.spring_security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController
{
    @RequestMapping(method = RequestMethod.GET,value = "/notices")
    public String getNotices()
    {
        return "notices from the DB ";
    }
}
