package com.atividade.retailer.rest;

import com.atividade.retailer.domain.Budget;
import com.atividade.retailer.domain.Order;
import com.atividade.retailer.domain.OrderItem;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public interface OrderController {
    @ApiOperation(value = "Health check")
    public ResponseEntity<String> isAlive();

    @ApiOperation(value = "Listar pedidos rastreados na API do lojista")
    public ResponseEntity<List<Order>> getList();

    @ApiOperation(value = "Criar novo pedido de produtos")
    public ResponseEntity<Budget> create(
            @ApiParam(value = "Lista de itens do pedido, cada qual contando com código e número de determinado produto a ser requisitado", required = true)
            @RequestBody ArrayList<OrderItem> orderItemList);

    @ApiOperation(value = "Postback de status do pedido de compra de produtos")
    public void updateStatus(
            @ApiParam(value = "Dados do POSTBACK", required = true)
            @RequestBody String data);
}
