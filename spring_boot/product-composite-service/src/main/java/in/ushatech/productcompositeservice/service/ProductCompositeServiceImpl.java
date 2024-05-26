package in.ushatech.productcompositeservice.service;

import in.ushatech.api.core.composite.*;
import in.ushatech.api.core.model.Product;
import in.ushatech.api.core.model.Recommendation;
import in.ushatech.api.core.model.Review;
import in.ushatech.util.ServiceUtil;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
@RestController
public class ProductCompositeServiceImpl implements ProductCompositeService
{

    private final ProductCompositeIntegration productCompositeIntegration;
    private final ServiceUtil serviceUtil;
    public ProductCompositeServiceImpl(ProductCompositeIntegration productCompositeIntegration, ServiceUtil serviceUtil)
    {
        this.productCompositeIntegration = productCompositeIntegration;
        this.serviceUtil = serviceUtil;
    }

    @Override
    public ProductAggregate getProductComposite(int productId)
    {
        Product product = productCompositeIntegration.getProduct(productId);
        List<Review> reviews = productCompositeIntegration.getReviews(productId);
        List<Recommendation> recommendations = productCompositeIntegration.getRecommendation(productId);

        return createProductAggregate(product,reviews,recommendations);

    }

    private ProductAggregate createProductAggregate(Product product, List<Review> reviews, List<Recommendation> recommendations)
    {
        List<RecommendationSummary> recommendationsSummary = recommendations.stream().map(
                entry -> new RecommendationSummary(entry.recommendationId(), entry.author(), entry.rate())
        ).collect(Collectors.toList());
        List<ReviewSummary> reviewSummaries = reviews.stream().map( e1 -> new ReviewSummary(e1.reviewId(),e1.author(),e1.subject()))
                .collect(Collectors.toList());
        return new ProductAggregate(
                product.productId(),
                product.name(),
                product.weight(),
                recommendationsSummary,
                reviewSummaries,
                serviceUtil.getServiceAddress());
    }
}
