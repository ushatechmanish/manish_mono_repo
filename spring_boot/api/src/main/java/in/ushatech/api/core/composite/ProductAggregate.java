package in.ushatech.api.core.composite;


import java.util.List;

public record ProductAggregate(
        int productId,
        String name,
        int weight,
        List<RecommendationSummary> recommendations,
        List<ReviewSummary> reviews,
        String serviceAddresses)
{
}
