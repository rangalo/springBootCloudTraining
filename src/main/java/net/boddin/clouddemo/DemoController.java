package net.boddin.clouddemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("demo")
public class DemoController {

    @RequestMapping("one")
    public Object getDemoObject(){
        String foo = "hello";
        return foo;
    }
}
