package com.example.bcmanagementapi.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseStatus(value = HttpStatus.ACCEPTED)
public class HealthController {

    @GetMapping("/ping")
    public String ping(){
        return "Pong";
    }

}
