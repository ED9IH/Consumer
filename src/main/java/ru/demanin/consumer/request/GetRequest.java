package ru.demanin.consumer.request;

import org.springframework.web.client.RestTemplate;

import java.util.Random;

public class GetRequest {

public static void get() {

    RestTemplate restTemplate = new RestTemplate();
    for (int i = 0;i<1000;i++) {
        String url = "http://localhost:8080/measurements";
        String response = restTemplate.getForObject(url, String.class);
        System.out.println(response);

    }

}









//    public static double value;
//
//    public static boolean rains;
//
//    public static void generatedRandom(){
//        Random random = new Random();
//        for(int i = 0; i<1000;i++){
//            value= random.nextDouble()*100;
//            rains=random.nextBoolean();
//            System.out.println(value);
//            System.out.println(rains);
//
//        }
//
//    }


}
