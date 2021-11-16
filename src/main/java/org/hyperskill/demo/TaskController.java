package org.hyperskill.demo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    List<Task> taskList = List.of(
      new Task(0, "Eat", "Healthy stuff!", false),
      new Task(1, "Code", "Having fun ^_^", true),
      new Task(2, "Sleep", "Boring :/", false),
      new Task(3, "Play", "Agh no time", false)
    );

    @GetMapping("/hellogetmappingdemo")
    public String helloGetMappingWorld() {
        var s = "Hello @GetMapping World!";
        return s;
    }

    @GetMapping("/tasks")
    public List<Task> getTaskList() {
        var taskList = this.taskList;
        return taskList;
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable int id) {
        return this.taskList.get(id);
    }

}
