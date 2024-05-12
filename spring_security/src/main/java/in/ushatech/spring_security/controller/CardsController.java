package in.ushatech.spring_security.controller;

import in.ushatech.spring_security.entity.Card;
import in.ushatech.spring_security.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CardsController
{

    @Autowired
    private CardRepository cardsRepository;

    @GetMapping("/myCards")
    public List<Card> getCardDetails(@RequestParam int id)
    {
        return cardsRepository.findByCustomerId(id);
    }

}
