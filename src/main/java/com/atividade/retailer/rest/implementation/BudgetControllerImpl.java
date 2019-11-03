package com.atividade.retailer.rest.implementation;

import com.atividade.retailer.rest.BudgetController;
import com.atividade.retailer.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping(value = "/api/v1/")
public class BudgetControllerImpl implements BudgetController {

    @Autowired
    private BudgetService budgetService;

    @Override
    @GetMapping("/budget/health-check")
    public ResponseEntity<String> isAlive() {
        return ResponseEntity.ok().body("It's alive!");
    }

    @Override
    @PutMapping("/budget/{budgetId}")
    public ResponseEntity<String> answerBudgetProposal(String budgetId, String acceptance) throws IOException, URISyntaxException {
        String response = budgetService.putAcceptance(budgetId, acceptance);
        return ResponseEntity.ok().body("Teste OK!");

    }
}
