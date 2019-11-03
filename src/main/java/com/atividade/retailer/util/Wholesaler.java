package com.atividade.retailer.util;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class Wholesaler {
	
	private static Map<String, String> wholesalerApi = new HashMap<String, String>() {{
		put("scheme", "http");
		put("host", "localhost:8090/api/v1");
		put("postOrder", "/order");
		put("putBudget", "/budget");
	}};

	public static String postOrder(String requestBody) throws IOException, URISyntaxException {
		String response = Curl.makeRequest(
				wholesalerApi.get("scheme"),
				wholesalerApi.get("host"),
				wholesalerApi.get("postOrder"),
				"POST",
				requestBody);

		return response;
	}

	public static String postBudgetAcceptance(String requestBody) throws IOException, URISyntaxException {
		String response = Curl.makeRequest(
				wholesalerApi.get("scheme"),
				wholesalerApi.get("host"),
				wholesalerApi.get("putBudget"),
				"PUT",
				requestBody);

		return response;
	}
}
