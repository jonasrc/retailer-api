package com.atividade.retailer.rest;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface BudgetController {
    @ApiOperation(value = "Aceitar ou rejeitar proposta de orçamento")
    public ResponseEntity<String> answerBudgetProposal(
            @ApiParam(value = "Flag que indica se proposta será aceita ou recusada (preencher 'accepted' para proposta aceita e 'refused' para proposta recusada)", required = true)
            @RequestBody String status);
}
