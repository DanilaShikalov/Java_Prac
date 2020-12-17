package com.company.Practice27_28;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static final HttpClient httpClient = HttpClient.newHttpClient();
    private static String URL = "http://gitlessons2020.rtuitlab.ru:3000/reflectionTasks";
    public static void main(String[] args) throws IOException, InterruptedException, InvocationTargetException, IllegalAccessException {
        Gson gson = new Gson();
        Type type = new TypeToken<List <TypeOfWork>>(){}.getType();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(URL))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        List<TypeOfWork> itemList = gson.fromJson(response.body(), type);
//        for (int i = 0; i < itemList.size(); i++)
//            System.out.println(itemList.get(i));
        Performance performance = new Performance();
        Class<? extends Performance> aClass = performance.getClass();
        List<Method> methods = Arrays.stream(aClass.getDeclaredMethods())
                .filter(a -> Arrays.stream(a.getAnnotations())
                        .anyMatch(v -> v instanceof AnnotationForPerformance))
                .collect(Collectors.toList());
//        for (int i = 0; i < methods.size(); i++)
//        {
//            System.out.println(methods.get(i));
//        }
//        System.out.println("-------------------------------------");
        for (int i = 0; i < itemList.size(); i++)
        {
            for (int j = 0; j < methods.size(); j++)
            {
                if (itemList.get(i).getType().equals(methods.get(j).getAnnotation(AnnotationForPerformance.class).s()))
                {
//                    System.out.println(methods.get(j).getAnnotation(AnnotationForPerformance.class).s());
//                    System.out.println("YES");
                    methods.get(j).invoke(new Performance(), itemList.get(i).getData());
                }
            }
        }
    }
}
