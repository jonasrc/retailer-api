package com.atividade.retailer.rest.implementation;

import com.atividade.retailer.domain.Order;
import com.atividade.retailer.domain.OrderItem;
import com.atividade.retailer.rest.OrderController;
import com.atividade.retailer.service.OrderService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/")
public class OrderControllerImpl implements OrderController {

    @Autowired
    private OrderService orderService;

    @Override
    @GetMapping("/health-check")
    public ResponseEntity<String> isAlive() {
        return ResponseEntity.ok().body("It's alive!");
    }

    @Override
    @GetMapping("/order")
    public ResponseEntity<List<Order>> getList() {
        return ResponseEntity.ok().body(orderService.getList());
    }

    @Override
    @PostMapping("/order")
    public ResponseEntity<Order> create(ArrayList<OrderItem> orderItemList){
        Order order = orderService.create();
        return ResponseEntity.created(URI.create(order.getId())).body(order);
    }

    @Override
    @PutMapping("/order")
    public void updateStatus(String data) {
        JSONObject jsonObject = new JSONObject(data);
    }
}
