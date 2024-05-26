package in.ushatech.reviewservice.service;

import in.ushatech.api.core.model.Review;
import in.ushatech.api.core.service.ReviewService;

import in.ushatech.util.ServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewServiceImpl implements ReviewService
{
    private final Logger log = LoggerFactory.getLogger(ReviewServiceImpl.class);
    private final ServiceUtil serviceUtil;

    @Autowired
    public ReviewServiceImpl(ServiceUtil serviceUtil)
    {
        this.serviceUtil = serviceUtil;
    }

    @Override
    public List<Review> getReviews(int productId)
    {
        log.info("productId:"+productId);
        return List.of(new Review(productId,productId,"author-"+productId,"subject-"+productId,
                "content-"+productId,serviceUtil.getServiceAddress()));
    }
}
