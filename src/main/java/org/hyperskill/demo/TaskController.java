package org.hyperskill.demo;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {

    @GetMapping("/hellogetmappingdemo")
    public String helloGetMappingWorld() {
        var s = "Hello @GetMapping World!";
        return s;
    }
}
