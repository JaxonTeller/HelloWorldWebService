package com.restful.webservice.Controller;

import com.restful.webservice.Resource.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class HelloWorldController {

    private static final String template="Hello %s";
    private static final AtomicInteger incrementalValue=new AtomicInteger();

    /*http://localhost:8080/greeting?name--here name parameter is optional*/
    @GetMapping(value = "/greeting")
    public Greeting greeting(@RequestParam(value = "name",defaultValue = "World") String name)
    {
        return new Greeting(incrementalValue.incrementAndGet(),String.format(template,name));
    }
}
