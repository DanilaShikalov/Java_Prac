package com.company.Practice21_22;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class httpJson implements ItemStore {
    private HttpClient httpClient = HttpClient.newHttpClient();
    private Gson gson = new Gson();
    private String URL = "http://localhost:3000/posts";//любой http сервер Json


    @Override
    public List<Item> getAll() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(URL))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        List<Item> itemList = gson.fromJson(response.body(), List.class);
        for (int i = 0; i < itemList.size(); i++)
        {
            Item item = (gson.fromJson(String.valueOf(itemList.get(i)),Item.class));
            System.out.println(item.toString1());
        }
        return itemList;
    }

    @Override
    public Item get(int id) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(URL+"/"+id))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(response.body(),Item.class);
    }

    @Override
    public Item addItem(Item item) throws IOException, InterruptedException {
        String body = gson.toJson(item);
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .uri(URI.create(URL))
                .setHeader("Content-Type", "application/json")
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(response.body(),Item.class);
    }

    @Override
    public Item editItem(Item item) throws IOException, InterruptedException {
        int id = item.getId();
        System.out.println(gson.toJson(item));
        HttpRequest request = HttpRequest.newBuilder()
                .PUT(HttpRequest.BodyPublishers.ofString(gson.toJson(item)))
                .uri(URI.create(URL+"/" + id))
                .setHeader("Content-Type", "application/json")
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return item;
    }

    @Override
    public void deleteItem(Item item) throws IOException, InterruptedException {
        int id = item.getId();
        HttpRequest request = HttpRequest.newBuilder()
                .DELETE()
                .uri(URI.create(URL+"/"+id))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

}

