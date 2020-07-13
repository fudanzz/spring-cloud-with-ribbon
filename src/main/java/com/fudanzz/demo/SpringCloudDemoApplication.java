package com.fudanzz.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableFeignClients
public class SpringCloudDemoApplication {

    @Autowired
    private OrganizationDiscoveryClient discoveryClient;

    @Autowired
    private OrganizationRestTemplateClient organizationRestTemplateClient;

    @Autowired
    private OrganizationFeignClient organizationFeignClient;

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDemoApplication.class, args);
    }

    @RequestMapping(value="/greeting1",method = RequestMethod.GET)
    public String demo() {
        return discoveryClient.getOrganization("oid-123");
    }

    @RequestMapping(value="/greeting2",method = RequestMethod.GET)
    public String demo2() {
        return organizationRestTemplateClient.getOrganization("oid-456");
    }

    @RequestMapping(value="/greeting3",method = RequestMethod.GET)
    public String demo3() {
        return organizationFeignClient.getOrganization("oid-789");
    }
}
