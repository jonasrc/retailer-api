package com.atividade.retailer.rest;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URISyntaxException;

public interface BudgetController {
    @ApiOperation(value = "Health check")
    public ResponseEntity<String> isAlive();

    @ApiOperation(value = "Aceitar ou rejeitar proposta de orçamento")
    public ResponseEntity<String> answerBudgetProposal(
            @ApiParam(value = "ID do orçamento (budget) na API do atacadista (wholesaler)", required = true)
            @PathVariable String budgetId,
            @ApiParam(value = "Aceitação ou recusa do orçamento (usar 'accepted' para aceitar e 'rejected' para rejeitar)", required = true)
            @RequestBody String acceptance) throws IOException, URISyntaxException;
}
