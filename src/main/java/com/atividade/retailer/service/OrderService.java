package com.atividade.retailer.service;

import com.atividade.retailer.domain.Order;

import java.util.List;

public interface OrderService {
    public Order create();

    public List<Order> getList();

    public Order getById(String id);

    public Order updateStatus(String idOnWholesalerApi, String status);
}
