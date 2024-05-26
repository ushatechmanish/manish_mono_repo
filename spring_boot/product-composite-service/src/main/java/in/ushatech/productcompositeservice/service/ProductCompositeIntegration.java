package in.ushatech.productcompositeservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import in.ushatech.api.core.exception.InvalidInputException;
import in.ushatech.api.core.exception.NotFoundException;
import in.ushatech.api.core.model.Product;
import in.ushatech.api.core.model.Recommendation;
import in.ushatech.api.core.model.Review;
import in.ushatech.api.core.service.ProductService;
import in.ushatech.api.core.service.RecommendationService;
import in.ushatech.api.core.service.ReviewService;
import in.ushatech.util.HttpErrorInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class ProductCompositeIntegration implements ProductService, ReviewService, RecommendationService
{
    private final Logger LOG = LoggerFactory.getLogger(ProductCompositeIntegration.class);
    RestTemplate restTemplate;
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
            String reviewServicePort,
            @Value("${app.recommendation-service.port}")
            String recommendationServicePort
    )
    {
        this.restTemplate = restTemplate;
        this.mapper = mapper;
        this.productServiceUrl = String.format("http://%s:%s/product/", productServiceHost, productServicePort);
        this.reviewServiceUrl = String.format("http://%s:%s/review?productId=", reviewServiceHost, reviewServicePort);
        this.recommendationServiceUrl = String.format("http://%s:%s/recommendation?productId=",
                recommendationServiceHost, recommendationServicePort);
    }

    @Override
    public Product getProduct(int productId)
    {
        String url = productServiceUrl + productId;
        Product product;
        try
        {
            product = restTemplate.getForObject(url, Product.class);
            return product;
        } catch (HttpClientErrorException e)
        {
            switch (Objects.requireNonNull(HttpStatus.resolve(e.getStatusCode().value())))
            {
                case NOT_FOUND -> throw new NotFoundException(getErrorMessage(e));
                case UNPROCESSABLE_ENTITY -> throw new InvalidInputException(getErrorMessage(e));
                default ->
                {
                    LOG.warn("Not an expected Http Error : {}, will throw it ", e.getStatusCode());
                    LOG.warn("Error Body is {} ", e.getResponseBodyAsString());
                    throw e;
                }
            }

        }

    }

    private String getErrorMessage(HttpClientErrorException ex)
    {
        try
        {
            return mapper.readValue(ex.getResponseBodyAsString(), HttpErrorInfo.class).message();
        } catch (IOException ioex)
        {
            return ex.getMessage();
        }
    }

    @Override
    public List<Recommendation> getRecommendation(int productId)
    {
        String url = recommendationServiceUrl + productId;
        try
        {
            return restTemplate.exchange(url, HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<Recommendation>>()
                    {
                    }).getBody();

        } catch (Exception ex)
        {
            LOG.warn("Got an exception while requesting recommendations, return zero recommendations: {}", ex.getMessage());
            return new ArrayList<>();
        }

    }

    @Override
    public List<Review> getReviews(int productId)
    {
        String reviewUrl = reviewServiceUrl + productId;
        try
        {
            return restTemplate.exchange(reviewUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Review>>()
                    {
                    }
            ).getBody();
        } catch (Exception ex)
        {
            LOG.warn("Got an exception while requesting reviews, return zero reviews: {}", ex.getMessage());
            return new ArrayList<>();
        }
    }
}

