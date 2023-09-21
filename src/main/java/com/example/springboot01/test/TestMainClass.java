/*************************************************************************
 *
 * Copyright (c) 2016, DATAVISOR, INC.
 * All rights reserved.
 * __________________
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of DataVisor, Inc.
 * The intellectual and technical concepts contained
 * herein are proprietary to DataVisor, Inc. and
 * may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from DataVisor, Inc.
 */

package com.example.springboot01.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

public class TestMainClass {
    private static final Logger logger = LoggerFactory.getLogger(TestMainClass.class);

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String path = "http://localhost:8080/hello/hhh02";
        //        String requestBody = "bodyha";
        String requestBody = "上海市哈哈bodyha，アメリカ合衆国。";
        HttpHeaders headers = new HttpHeaders();
        MediaType mediaType = new MediaType(MediaType.TEXT_PLAIN, StandardCharsets.UTF_8);
        headers.setContentType(mediaType);
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                path,
                HttpMethod.POST,
                new HttpEntity<>(requestBody, headers),
                new ParameterizedTypeReference<String>() {
                }
        );

        logger.info("ha is {}. ", responseEntity.getBody());

    }
}
