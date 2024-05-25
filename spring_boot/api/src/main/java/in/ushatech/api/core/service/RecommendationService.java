package in.ushatech.api.core.service;

import in.ushatech.api.core.model.Recommendation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface RecommendationService
{
    @GetMapping(value = "/recommendation", produces = "application/json")
    List<Recommendation> getProduct(@RequestParam(name = "productId", required = true) int productId);
}
