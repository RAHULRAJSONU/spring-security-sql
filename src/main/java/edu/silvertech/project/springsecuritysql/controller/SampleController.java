package edu.silvertech.project.springsecuritysql.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SampleController {

    @RequestMapping(value = "open/{name}", method = RequestMethod.GET, produces = "Application/json")
    public String greet(@PathVariable("name") String name){
        return "Welcome "+name;
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = "secured/{name}", method = RequestMethod.GET, produces = "Application/json")
    public String greetSecurely(@PathVariable("name") String name) {
        return "Welcome boss::"+name;
    }
}
