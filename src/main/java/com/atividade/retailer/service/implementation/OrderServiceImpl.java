package com.atividade.retailer.service.implementation;

import com.atividade.retailer.domain.Order;
import com.atividade.retailer.service.OrderService;
import com.atividade.retailer.util.Wholesaler;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class OrderServiceImpl implements OrderService {
    private List<Order> orderList;

    @Override
    public Order create() {
        try {
            String wholesalerApiResponse = Wholesaler.postOrder("test");
        }
        catch(Exception exception) {

        }

        Order order = new Order("teste", "teste");

        if(orderList == null){
            orderList = new ArrayList<>();
        }

        orderList.add(order);

        return order;
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
