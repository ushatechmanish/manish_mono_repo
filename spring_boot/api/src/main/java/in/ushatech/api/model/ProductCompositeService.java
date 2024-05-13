package in.ushatech.api.model;

import java.util.List;

public record ProductCompositeService(Product product, List<Review> reviews, List<Recommendation> recommendations,
                                      String serviceAddress)
{
}
