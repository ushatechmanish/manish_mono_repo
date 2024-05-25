package in.ushatech.api.core.composite;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface ProductCompositeService
{
    @GetMapping(value = "/product-composite/{productId}", produces = "application/json")
    ProductAggregate getProductC(@PathVariable("productId") String productId);
}
