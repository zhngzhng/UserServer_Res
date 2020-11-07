package njgis.opengms.resserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class Rest {
    @GetMapping("/admin/hello")
    private String adim(){
        return "admin";
    }
    @GetMapping("/hello")
    private Object a(Principal principal){
        System.out.println(principal);
        return principal;
    }
}
