package com.atividade.retailer.rest;

import com.atividade.retailer.domain.Order;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface OrderController {
    @ApiOperation(value = "Health check")
    public ResponseEntity<String> isAlive();

    @ApiOperation(value = "Criar novo pedido de produtos")
    public ResponseEntity<Order> create();

    @ApiOperation(value = "Listar pedidos rastreados na API do lojista")
    public ResponseEntity<List<Order>> getList();

    @ApiOperation(value = "Postback de status do pedido de compra de produtos")
    public void updateStatus(
            @ApiParam(value = "Dados do POSTBACK", required = true)
            @RequestBody String data);
}
