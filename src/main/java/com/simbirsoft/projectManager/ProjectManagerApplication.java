package com.simbirsoft.projectManager;

import com.simbirsoft.projectManager.feign.WikipediaFeignClient;
import com.simbirsoft.projectManager.rest.dto.WikipediaPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@SpringBootApplication
@EnableFeignClients
public class ProjectManagerApplication extends SpringBootServletInitializer {

    @Autowired
    private WikipediaFeignClient wikipediaFeignClient;

    public static void main(String[] args) {
        SpringApplication.run(ProjectManagerApplication.class, args);
    }

    @GetMapping("/foundInWikipedia/{search}")
    public ArrayList<WikipediaPage> doSearch(@PathVariable("search") String search) {
        return wikipediaFeignClient.doSearch(search);
    }

}
