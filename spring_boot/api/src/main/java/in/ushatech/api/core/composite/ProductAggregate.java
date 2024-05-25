package in.ushatech.api.core.composite;

import in.ushatech.api.core.model.Product;

import java.util.List;

public record ProductAggregate(Product product, List<ReviewSummary> reviews, List<RecommendationSummary> recommendations,
                               String serviceAddress)
{
}
