package org.hyperskill.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExercicesController {

    class ExerciceTask {
        private final int id;
        private final String name;
        private final String description;

        ExerciceTask(int id, String name, String description) {
            this.id = id;
            this.name = name;
            this.description = description;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }
    }

    @RestController
    public class Controller {
        List<ExerciceTask> tasks = List.of(
                new ExerciceTask(405, "Improve UI", "implement ..."),
                new ExerciceTask(406, "Color bug", "fix ...")
        );

        ExerciceTask defaultTask = new ExerciceTask(0, null, null);

        // Add your code below this line and do not change the code above the line.
        @GetMapping("/exercicetask/{id}")
        public ResponseEntity<ExerciceTask> getExerciceTask(@PathVariable int id) {

            try {
                ExerciceTask taskById = tasks.stream().filter(t -> t.getId() == id)
                        .findFirst()
                        .orElseThrow();
                return new ResponseEntity<>(this.tasks.get(id - 405), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(this.defaultTask, HttpStatus.OK);
            }
        }

    }

}
