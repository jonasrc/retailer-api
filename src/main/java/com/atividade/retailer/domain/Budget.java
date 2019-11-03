package com.atividade.retailer.domain;

import java.util.UUID;

public class Budget {
    private String id;

    private String idOnWholesalerApi;

    private Double value;

    public Budget(String idOnWholesalerApi, Double value) {
        this.id = UUID.randomUUID().toString();
        this.idOnWholesalerApi = idOnWholesalerApi;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdOnWholesalerApi() {
        return idOnWholesalerApi;
    }

    public void setIdOnWholesalerApi(String idOnWholesalerApi) {
        this.idOnWholesalerApi = idOnWholesalerApi;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
