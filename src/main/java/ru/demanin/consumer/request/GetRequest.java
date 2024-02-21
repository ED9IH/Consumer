package ru.demanin.consumer.request;

import org.springframework.web.client.RestTemplate;

public class GetRequest {

    public static void get() {

        RestTemplate restTemplate = new RestTemplate();
        for (int i = 0; i < 1000; i++) {
            String url = "http://localhost:8080/measurements";
            String response = restTemplate.getForObject(url, String.class);
            System.out.println(response);

        }

    }

}
