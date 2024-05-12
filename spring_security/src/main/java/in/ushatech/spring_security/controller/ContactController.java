package in.ushatech.spring_security.controller;

import in.ushatech.spring_security.entity.ContactMessage;
import in.ushatech.spring_security.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.Random;


@RestController
public class ContactController
{

    @Autowired
    private ContactMessageRepository contactRepository;

    @PostMapping("/contact")
    public ContactMessage saveContactInquiryDetails(@RequestBody ContactMessage contact)
    {
        contact.setContactId(getServiceReqNumber());
        contact.setCreateDt(new Date(System.currentTimeMillis()).toLocalDate());
        return contactRepository.save(contact);
    }

    public String getServiceReqNumber()
    {
        Random random = new Random();
        int ranNum = random.nextInt(999999999 - 9999) + 9999;
        return "SR" + ranNum;
    }
}
