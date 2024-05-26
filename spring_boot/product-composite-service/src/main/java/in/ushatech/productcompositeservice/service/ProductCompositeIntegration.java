package in.ushatech.productcompositeservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import in.ushatech.api.core.model.Product;
import in.ushatech.api.core.model.Recommendation;
import in.ushatech.api.core.model.Review;
import in.ushatech.api.core.service.ProductService;
import in.ushatech.api.core.service.RecommendationService;
import in.ushatech.api.core.service.ReviewService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Component
public class ProductCompositeIntegration implements ProductService, ReviewService, RecommendationService
{
    RestTemplate restTemplate ;
    ObjectMapper mapper;

    String productServiceUrl;
    String recommendationServiceUrl;
    String reviewServiceUrl;
    public ProductCompositeIntegration(
            RestTemplate restTemplate,
            ObjectMapper mapper,
            @Value("${app.product-service.host}")
            String productServiceHost,
            @Value("${app.review-service.host}")
            String reviewServiceHost,
            @Value("${app.recommendation-service.host}")
            String recommendationServiceHost,
            @Value("${app.product-service.port}")
            String productServicePort,
            @Value("${app.review-service.port}")
            String reviewSevicePort,
            @Value("${app.recommendation-service.port}")
            String recommendationSevicePort
            )
    {
        this.restTemplate = restTemplate;
        this.mapper = mapper;
        this.productServiceUrl = String.format("http://%s:%s/product/",productServiceHost,productServicePort);
        this.reviewServiceUrl = String.format("http://%s:%s/review?productId=",reviewServiceHost,reviewSevicePort);
        this.recommendationServiceUrl = String.format("http://%s:%s/recommendation?productId=",
                recommendationServiceHost,recommendationSevicePort);
    }

    @Override
    public Product getProduct(int productId)
    {
        String url = productServiceUrl+productId;
        return restTemplate.getForObject(url,Product.class);
    }

    @Override
    public List<Recommendation> getRecommendation(int productId)
    {
        String url= recommendationServiceUrl+productId;
        return restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Recommendation>>()
        {
        }).getBody();
    }

    @Override
    public List<Review> getReviews(int productId)
    {
        String reviewUrl = reviewServiceUrl+productId;
        return restTemplate.exchange(reviewUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Review>>(){}
        ).getBody();
    }
}

