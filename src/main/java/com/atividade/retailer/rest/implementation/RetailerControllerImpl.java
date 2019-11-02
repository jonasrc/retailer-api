package com.atividade.retailer.rest.implementation;

import com.atividade.retailer.rest.RetailerController;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v1/retailer")
public class RetailerControllerImpl implements RetailerController {

    @Override
    @GetMapping("/health-check")
    public ResponseEntity<String> isAlive() {
        return ResponseEntity.ok().body("It's alive!");
    }

    @Override
    @PostMapping("/order-status")
    public void orderStatusUpdate(String data) {
        JSONObject jsonObject = new JSONObject(data);
    }
}
