package in.ushatech.recommendationservice.service;

import in.ushatech.api.core.model.Recommendation;
import in.ushatech.api.core.service.RecommendationService;
import in.ushatech.util.ServiceUtil;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecommendationServiceImpl implements RecommendationService
{
    private final ServiceUtil serviceUtil;

    public RecommendationServiceImpl(ServiceUtil serviceUtil)
    {
        this.serviceUtil = serviceUtil;
    }

    @Override
    public List<Recommendation> getRecommendation(int productId)
    {
        return List.of(new Recommendation(productId,productId,"author"+productId,1,"content"+productId,
                serviceUtil.getServiceAddress()));
    }
}

