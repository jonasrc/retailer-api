package com.atividade.retailer.service.implementation;

import com.atividade.retailer.domain.Budget;
import com.atividade.retailer.domain.Order;
import com.atividade.retailer.domain.OrderItem;
import com.atividade.retailer.service.BudgetService;
import com.atividade.retailer.service.OrderService;
import com.atividade.retailer.util.Wholesaler;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrderServiceImpl implements OrderService {

    private List<Order> orderList;

    @Autowired
    private BudgetService budgetService;

    public OrderServiceImpl() {
        this.orderList = new ArrayList<>();
    }

    @Override
    public Budget create(ArrayList<OrderItem> orderItemList) {
        String orderItemListString = new JSONArray(orderItemList).toString();
        String wholesalerApiResponse = "";

        try {
            wholesalerApiResponse = Wholesaler.postOrder(orderItemListString);
            int a = 1;
        }
        catch(Exception exception) {
            int a = 1;
        }

        // Transformação do retorno da API do atacadista em JSON
        JSONObject jsonResponse = new JSONObject(wholesalerApiResponse);

        // Criação do pedido na API do lojista a partir da resposta da API do atacadista
        Order order = new Order(jsonResponse.getString("orderStatus"), jsonResponse.getString("orderId"));

        // Adição do pedido à lista de pedidos da API do lojista
        this.orderList.add(order);

        // Criando orçamento no ambiente da API do lojista
        Budget budget = budgetService.create(
                jsonResponse.getString("budgetId"),
                jsonResponse.getDouble("budgetValue"));

        return budget;
    }

    @Override
    public List<Order> getList() {
        return orderList;
    }

    @Override
    public Order getById(String id) {
        Order order = orderList.stream().filter(element -> element.getId().equals(id)).findAny().orElse(null);

        if(order == null){
            throw new NoSuchElementException("Order not found.");
        }

        return order;
    }

    @Override
    public Order updateStatus(String id, String status) {
        Order order = getById(id);
        order.setStatus(status);
        return order;
    }
}
