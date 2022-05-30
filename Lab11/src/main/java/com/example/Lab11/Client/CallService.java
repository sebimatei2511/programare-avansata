package com.example.Lab11.Client;

import com.example.Lab11.Entities.PersonEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class CallService {

    final Logger logger = LoggerFactory.getLogger(CallService.class);
    private final String uri = "http://localhost:8081/lab11";

    public List<PersonEntity> getPersons() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<PersonEntity>> response = restTemplate.exchange(
                uri, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<PersonEntity>>() {} );

        List<PersonEntity> result = response.getBody();
        assert result != null;
        result.forEach(p -> logger.info(p.toString()));
        logger.info("Success!");
        return result;
    }

    public void addPerson(String name) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
                uri, HttpMethod.POST, null,
                new ParameterizedTypeReference<String>() {} );
        String result = response.getBody();
        logger.info(result);
    }



}
