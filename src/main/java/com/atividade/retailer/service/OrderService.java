package com.atividade.retailer.service;

import com.atividade.retailer.domain.Budget;
import com.atividade.retailer.domain.Order;
import com.atividade.retailer.domain.OrderItem;

import java.util.ArrayList;
import java.util.List;

public interface OrderService {
    public Budget create(ArrayList<OrderItem> orderItemList);

    public List<Order> getList();

    public Order getById(String id);

    public Order updateStatus(String idOnWholesalerApi, String status);
}
