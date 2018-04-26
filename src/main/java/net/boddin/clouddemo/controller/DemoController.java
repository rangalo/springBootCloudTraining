package net.boddin.clouddemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class DemoController {

    @RequestMapping("/one")
    public Object getDemoObject(){
        String foo = "hello";
        return foo;
    }
}
