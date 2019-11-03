package com.atividade.retailer.service;

import com.atividade.retailer.domain.Budget;
import com.atividade.retailer.domain.Order;
import com.atividade.retailer.domain.OrderItem;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public interface BudgetService {

    public List<Budget> getList();

    public Budget getById(String id);

    public Budget create(String idOnWholesalerApi, Double value);

    public String putAcceptance(String id, String acceptance) throws IOException, URISyntaxException;
}
