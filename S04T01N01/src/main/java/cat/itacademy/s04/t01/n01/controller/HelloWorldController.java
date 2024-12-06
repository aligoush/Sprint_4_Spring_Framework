package cat.itacademy.s04.t01.n01.controller;

import ch.qos.logback.core.util.StringUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/HelloWorld")
    public String hello(@RequestParam(value = "name", defaultValue = "UNKNOWN")String name){
        return "Hello, " + name + ". You are running a Maven project.";
    }

    @GetMapping(value = {"/HelloWorld2","/HelloWorld2/{name}"})
    private String hello2(@PathVariable(required = false) String name){

        if(!StringUtil.isNullOrEmpty(name)){
            return "Hello, " + name + ". You are running a Maven project.";
        } else {
            return "Hello, UNKNOWN! You are running a Maven project.";
        }
    }
}
