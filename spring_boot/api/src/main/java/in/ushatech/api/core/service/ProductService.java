package in.ushatech.api.core.service;

import in.ushatech.api.core.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface ProductService
{
    @GetMapping(value = "/product/{productId}", produces = "application/json")
    Product getProduct(@PathVariable int productId);
}
