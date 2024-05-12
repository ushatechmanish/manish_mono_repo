package in.ushatech.spring_security.controller;


import in.ushatech.spring_security.entity.AccountTransaction;
import in.ushatech.spring_security.repository.AccountTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class BalanceController
{

    @Autowired
    private AccountTransactionRepository accountTransactionsRepository;

    @GetMapping("/myBalance")
    public List<AccountTransaction> getBalanceDetails(@RequestParam int id)
    {
        return accountTransactionsRepository.
                findByCustomerIdOrderByTransactionDtDesc(id);
    }
}
