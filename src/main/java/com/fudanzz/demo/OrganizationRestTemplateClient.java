package com.fudanzz.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OrganizationRestTemplateClient {


    @LoadBalanced
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    public String getOrganization(String organizationId){
        ResponseEntity<String> restExchange =
                restTemplate.exchange(
                        "http://organizationservice/v1/organizations/{organizationId}",
                        HttpMethod.GET,
                        null, String.class, organizationId);

        return restExchange.getBody();
    }
}
