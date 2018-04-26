package net.boddin.clouddemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
// @PreAuthorize("hasRole('ROLE_ADMINISTRATOR')")
public class DemoController {

    @Value("${my.property}")
    private String prop;

    @Autowired
    private MyConfig myConfig;

    @Secured({"ROLE_USER", "ROLE_ADMINISTRATOR"})
    @RequestMapping("/one")
    public Object getDemoObject(){
        String foo = "hello " + prop + myConfig.getString1();
        return foo;
    }

    @RequestMapping("/admin")
    @Secured("ROLE_ADMINISTRATOR")
    public Object helloAdmin(){
        String foo = "hello admin";
        return foo;
    }
}
