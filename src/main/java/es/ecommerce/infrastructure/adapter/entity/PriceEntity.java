package es.ecommerce.infrastructure.adapter.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "PRICE")
public class PriceEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "BRAND_ID", nullable = false)
	private Integer brandId;

	@Column(name = "START_DATE", nullable = false)
	private LocalDateTime startDate;

	@Column(name = "END_DATE", nullable = false)
	private LocalDateTime endDate;

	@Column(name = "PRICE_LIST", nullable = false)
	private Integer priceList;

	@Column(name = "PRODUCT_ID", nullable = false)
	private Long productId;

	@Column(nullable = false)
	private Integer priority;

	@Column(nullable = false)
	private Double price;

	@Column(name = "CURR", nullable = false)
	private String currency;

	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public Integer getBrandId() { return brandId; }
	public void setBrandId(Integer brandId) { this.brandId = brandId;}

	public LocalDateTime getStartDate() { return startDate; }
	public void setStartDate(LocalDateTime startDate) { this.startDate = startDate;}

	public LocalDateTime getEndDate() { return endDate; }
	public void setEndDate(LocalDateTime endDate) { this.endDate = endDate; }

	public Integer getPriceList() { return priceList; }
	public void setPriceList(Integer priceList) { this.priceList = priceList; }

	public Long getProductId() { return productId; }
	public void setProductId(Long productId) { this.productId = productId; }

	public Integer getPriority() { return priority; }
	public void setPriority(Integer priority) { this.priority = priority; }

	public Double getPrice() { return price; }
	public void setPrice(Double price) { this.price = price; }

	public String getCurrency() { return currency; }
	public void setCurrency(String currency) { this.currency = currency; }
}