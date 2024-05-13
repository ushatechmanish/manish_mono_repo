package in.ushatech.api.model;

public record Recommendation(int productId, int recommendationId, String author, int rate, String content,
                             String serviceAddress)
{
}
