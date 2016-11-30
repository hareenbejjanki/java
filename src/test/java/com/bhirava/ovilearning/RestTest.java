package com.bhirava.ovilearning;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestTest {

    public static void main(String[] args) throws Exception {
//        RestClient restClient = new RestClient();
//        ResponseEntity<Object> responseEntity = restClient.sendRestCall(null, "http://www.ovilearning.com/api/user/login?email={email}&password={password}&device_id={device_id}", HttpMethod.POST, new String[] {"abhii4you@gmail.com", "12345678", "test_device"});
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://www.ovilearning.com/api/user/login?email={email}&password={password}&device_id={device_id}", null, String.class, new String[] {"abhii4you@gmail.com", "12345678", "test_device"});
        System.out.println(responseEntity.getStatusCode().ordinal());
        System.out.println(responseEntity.getBody());
        System.out.println(responseEntity.getHeaders());
        System.out.println(responseEntity);
    }
    
}
