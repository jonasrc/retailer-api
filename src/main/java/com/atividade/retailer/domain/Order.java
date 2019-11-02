package com.atividade.retailer.domain;

import java.util.UUID;

public class Order {
    private String id;

    private String status;

    private String idOnWholesalerApi;

    public Order(String status, String idOnWholesalerApi) {
        this.id = UUID.randomUUID().toString();
        this.status = status;
        this.idOnWholesalerApi = idOnWholesalerApi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdOnWholesalerApi() {
        return idOnWholesalerApi;
    }

    public void setIdOnWholesalerApi(String idOnWholesalerApi) {
        this.idOnWholesalerApi = idOnWholesalerApi;
    }
}
