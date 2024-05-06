package com.example;

import io.micronaut.http.annotation.*;

@Controller("/demo")
public class DemoController {

    private final HelloWorldService helloWorldService;


    public DemoController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @Get(uri="/", produces="text/plain")
    public String index() {
        return "Example Response";
    }
}