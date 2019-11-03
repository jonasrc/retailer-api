package com.atividade.retailer.service.implementation;

import com.atividade.retailer.domain.Budget;
import com.atividade.retailer.service.BudgetService;
import com.atividade.retailer.util.Wholesaler;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BudgetServiceImpl implements BudgetService {

    private List<Budget> budgetList;

    public BudgetServiceImpl() {
        this.budgetList = new ArrayList<>();
    }

    @Override
    public List<Budget> getList() {
        return budgetList;
    }

    @Override
    public Budget getById(String id) {
        Budget budget = budgetList.stream().filter(element -> element.getId().equals(id)).findAny().orElse(null);

        if(budget == null){
            throw new NoSuchElementException("Budget not found.");
        }

        return budget;
    }

    @Override
    public Budget create(String idOnWholesalerApi, Double value) {
        // Criação do pedido na API do lojista a partir da resposta da API do atacadista
        Budget budget = new Budget(idOnWholesalerApi, value);

        // Adição do pedido à lista de pedidos da API do lojista
        this.budgetList.add(budget);

        return budget;
    }

    @Override
    public String putAcceptance(String id, String acceptance) throws IOException, URISyntaxException {
        JSONObject data = new JSONObject();
        data.put("budgetId", id);
        data.put("acceptance", acceptance);
        return Wholesaler.putBudgetAcceptance(data.toString());
    }
}
