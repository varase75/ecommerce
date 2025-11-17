package es.ecommerce.domain.model;

import java.time.LocalDateTime;

public class Price {
    private Integer brandId;
    private Long productId;
    private Integer priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double price;
    private String currency;

    public Price(Integer brandId, Long productId, Integer priceList,
                 LocalDateTime startDate, LocalDateTime endDate,
                 Double price, String currency) {
        this.brandId = brandId;
        this.productId = productId;
        this.priceList = priceList;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.currency = currency;
    }

    // Getters
    public Integer getBrandId() { return brandId; }
    public Long getProductId() { return productId; }
    public Integer getPriceList() { return priceList; }
    public LocalDateTime getStartDate() { return startDate; }
    public LocalDateTime getEndDate() { return endDate; }
    public Double getPrice() { return price; }
    public String getCurrency() { return currency; }
}
