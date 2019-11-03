package com.atividade.retailer.domain;

public class OrderItem {
    private Long productCode;

    private Long productQuantity;

    private String notes;

    public OrderItem(Long productCode, Long productQuantity, String notes) {
        this.productCode = productCode;
        this.productQuantity = productQuantity;
        this.notes = notes;
    }

    public Long getProductCode() {
        return productCode;
    }

    public void setProductCode(Long productCode) {
        this.productCode = productCode;
    }

    public Long getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Long productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
