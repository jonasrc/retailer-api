package com.atividade.retailer.rest;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface RetailerController {
    @ApiOperation(value = "Health check")
    public ResponseEntity<String> isAlive();

    @ApiOperation(value = "Postback de status do pedido de compra de produtos")
    public void orderStatusUpdate(
            @ApiParam(value = "Dados do POSTBACK", required = true)
            @RequestBody String data);
}
