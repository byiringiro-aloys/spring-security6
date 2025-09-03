package com.spring_sec.SpringSec1.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

    @Value("${spring.application.name}")
    public String appName;
}
