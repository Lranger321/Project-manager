package com.simbirsoft.projectManager.feign;

import com.simbirsoft.projectManager.rest.dto.WikipediaPage;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@FeignClient(name = "wikipedia-feign-client",
        url = "${wikipedia.api-base-url}")
public interface WikipediaFeignClient {

    @GetMapping("/w/api.php?action=query&continue=&generator=search&prop=info&format=json&gsrsearch={search}")
    ArrayList<WikipediaPage> doSearch(@Param("search") String search);

    @PostMapping("/ww")
    void doPost();
}
