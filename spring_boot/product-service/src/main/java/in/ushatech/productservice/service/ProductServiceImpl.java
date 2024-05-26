package in.ushatech.productservice.service;

import in.ushatech.api.core.exception.InvalidInputException;
import in.ushatech.api.core.exception.NotFoundException;
import in.ushatech.api.core.model.Product;
import in.ushatech.api.core.service.ProductService;
import in.ushatech.util.ServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductServiceImpl implements ProductService
{
    private final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final ServiceUtil serviceUtil;

    public ProductServiceImpl(ServiceUtil serviceUtil)
    {
        this.serviceUtil = serviceUtil;
    }

    @Override
    public Product getProduct(int productId)
    {
        if (productId < 1)
        {
            LOG.debug("Invalid product id recd in ProductServiceImpl: {}",productId);
            throw new InvalidInputException("Invalid ProductId"+ productId);
        }
        if (productId == 13)
        {
            LOG.debug("Invalid product id recd in ProductServiceImpl: {}",productId);
            throw new  NotFoundException("Not found product with ProductId" + productId);
        }

        return new Product(productId, "name-" + productId, 123, serviceUtil.getServiceAddress());
    }
}
