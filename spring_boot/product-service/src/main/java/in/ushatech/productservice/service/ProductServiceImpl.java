package in.ushatech.productservice.service;

import in.ushatech.api.core.model.Product;
import in.ushatech.api.core.service.ProductService;
import in.ushatech.util.ServiceUtil;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductServiceImpl implements ProductService
{
    private final ServiceUtil serviceUtil;

    public ProductServiceImpl(ServiceUtil serviceUtil)
    {
        this.serviceUtil = serviceUtil;
    }

    @Override
    public Product getProduct(int productId)
    {
        return new Product(productId,"name-"+productId,123, serviceUtil.getServiceAddress());
    }
}
