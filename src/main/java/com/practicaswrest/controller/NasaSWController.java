/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practicaswrest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/nasa")
public class NasaSWController {

    @GetMapping
    public void consumir() {
        String url = "https://api.nasa.gov/neo/rest/v1/feed?start_date=2022-11-12&end_date=2022-11-13&api_key=ux5WE3oQxCdD5ndNpx5FsUQbDGVaeyP6oSrRcT8W";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        System.out.println("Resultado:" + result.toString());
    }

}
