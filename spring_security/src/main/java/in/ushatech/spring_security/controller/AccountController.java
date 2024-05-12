package in.ushatech.spring_security.controller;


import in.ushatech.spring_security.entity.Accounts;
import in.ushatech.spring_security.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AccountController
{

    @Autowired
    private AccountsRepository accountsRepository;

    @GetMapping("/myAccount")
    public Accounts getAccountDetails(@RequestParam int id)
    {
        Accounts var = accountsRepository.findByCustomerId(id);
        return var;
    }

}
