package com.company.Practice23_24;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class httpServer {
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final Gson gson = new Gson();
    private final String URL = "http://gitlessons2020.rtuitlab.ru:3000/tasks";//любой http сервер Json
    private final String REPORT = "http://gitlessons2020.rtuitlab.ru:3000/reports";
    private final String path = "src\\com\\company\\Practice23_24\\db.json";
    private final File file = new File(path);




    public void getAll() throws IOException, InterruptedException {
        while (true) {
            float random_number = 1 + (float) (Math.random());
            TimeUnit.SECONDS.sleep((long) random_number);
            System.out.println("Вызов");
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(URL))
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            List<Work> itemList = gson.fromJson(response.body(), List.class);
            Type type = new TypeToken<List<Work>>() {
            }.getType();
            List<Work> cars = null;
            FileReader fileReader = new FileReader(file);
            cars = gson.fromJson(fileReader, type);
            if (itemList.size() != cars.size()) {
                FileWriter fileWriter = new FileWriter(path, true);
                FileWriter fileWriter1 = new FileWriter(path);
                fileWriter.write("[\n");
                for (int i = 1; i <= itemList.size(); i++) {
                    fileWriter.write(get(i).toString2());
                    if (i != itemList.size()) fileWriter.write(",");
                    fileWriter.write("\n");
                }
                fileWriter.write("]");
                fileWriter.close();
                int q = 1;
                if (cars.size() != 0) {
                    q = cars.size() + 1;
                }
                for (; q <= itemList.size(); q++) {
                    char s = 0;
                    float f = 0;
                    float g = 0;
                    char[] str = get(q).getExpression().toCharArray();
                    for (int i = 1; i < str.length; i++) {
                        if (str[i] == '+' || str[i] == '-' || str[i] == '*' || str[i] == '/') {
                            f = Float.parseFloat(get(q).getExpression().substring(0, i).replaceAll("\\s+", ""));
                            s = str[i];
                            g = Float.parseFloat(get(q).getExpression().substring(i + 1).replaceAll("\\s+", ""));
                            break;
                        }
                    }
                    double r = 0;
                    switch (s) {
                        case '+': {
                            r = f + g;
                            break;
                        }
                        case '-': {
                            r = f - g;
                            break;
                        }
                        case '*': {
                            r = f * g;
                            break;
                        }
                        case '/': {
                            r = f / g;
                            break;
                        }
                    }
                    double scale = Math.pow(10, 2);
                    r = (Math.round((r) * scale)) / scale;
                    WorkDone done = new WorkDone(q, "Shikalov", r);
                    String body = gson.toJson(done);
                    HttpRequest request1 = HttpRequest.newBuilder()
                            .POST(HttpRequest.BodyPublishers.ofString(body))
                            .uri(URI.create(REPORT))
                            .setHeader("Content-Type", "application/json")
                            .build();
                    HttpResponse<String> response1 = httpClient.send(request1, HttpResponse.BodyHandlers.ofString());
                }
            }
        }
    }

    public Work get(int id) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(URL+"/"+id))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(response.body(),Work.class);
    }

}
