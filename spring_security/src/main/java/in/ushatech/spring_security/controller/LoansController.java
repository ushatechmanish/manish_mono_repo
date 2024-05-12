package in.ushatech.spring_security.controller;


import in.ushatech.spring_security.entity.Loan;
import in.ushatech.spring_security.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController
{

    @Autowired
    private LoanRepository loanRepository;

    @GetMapping("/myLoans")
    public List<Loan> getLoanDetails(@RequestParam int id)
    {
        return loanRepository.findByCustomerIdOrderByStartDtDesc(id);
    }

}
