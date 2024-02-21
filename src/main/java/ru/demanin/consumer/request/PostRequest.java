package ru.demanin.consumer.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PostRequest {

    public static void postRequest() throws JsonProcessingException {

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/measurements/add";
        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            Map<String, Object> jsonToSend = new HashMap<>();
            jsonToSend.put("value", random.nextDouble() * 100);
            jsonToSend.put("raining", random.nextBoolean());

            Map<String, Object> sensor = new HashMap<>();
            sensor.put("id", "12");
            jsonToSend.put("sensor", sensor);

// Преобразуем объект в JSON-строку
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(jsonToSend);

// Создаем HttpHeaders и устанавливаем заголовок Content-Type на application/json
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

// Создаем HttpEntity с заголовками и телом запроса
            HttpEntity<String> request = new HttpEntity<>(json, headers);

            restTemplate.postForObject(url, request, String.class);
            System.out.println(request);
        }

    }
}



