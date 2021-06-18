package com.profi.jjd.http;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class HttpClientExample {
    public static final String URL = "https://jsonplaceholder.typicode.com/posts";
    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();

        // GET запрос
        HttpRequest getRequest = HttpRequest.newBuilder(URI.create(URL))
                .GET()
                .header("accept", "application/json")
                .build();

        HttpResponse<String> response = null;
        try {
//            CompletableFuture<HttpResponse<String>> future = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
//            String result = future.thenApply(HttpResponse::body).get(5, TimeUnit.SECONDS);
//            System.out.println(result);

            response = client.send(getRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // POST запрос
        String jsonData = "{\"title\": \"Название\",\"text\": \"Текст\"}";

        Map<String, String> parameters = new HashMap<>();
        parameters.put("a", "get_account");
        parameters.put("title", "Название");
        parameters.put("text", "Текст");

        String paramsData = parameters.keySet().stream()
                .map(key -> key + "=" + URLEncoder.encode(parameters.get(key), StandardCharsets.UTF_8))
                .collect(Collectors.joining("&"));

        HttpRequest postRequest = HttpRequest.newBuilder(URI.create(URL))
                .POST(HttpRequest.BodyPublishers.ofString(jsonData)) // paramsData
                .header("accept", "application/json")
                .build();

        HttpResponse<String> postResponse = null;
        try {
            postResponse = client.send(postRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println(postResponse.body());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
