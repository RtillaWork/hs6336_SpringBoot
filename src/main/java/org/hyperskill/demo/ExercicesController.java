package org.hyperskill.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

@RestController
public class ExercicesController {

//    class ExerciceTask {
//        private final int id;
//        private final String name;
//        private final String description;
//
//        ExerciceTask(int id, String name, String description) {
//            this.id = id;
//            this.name = name;
//            this.description = description;
//        }
//
//        public int getId() {
//            return id;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public String getDescription() {
//            return description;
//        }
//    }
//
//    @RestController
//    public class Controller {
//        List<ExerciceTask> tasks = List.of(
//                new ExerciceTask(405, "Improve UI", "implement ..."),
//                new ExerciceTask(406, "Color bug", "fix ...")
//        );
//
//        ExerciceTask defaultTask = new ExerciceTask(0, null, null);
//
//        // Add your code below this line and do not change the code above the line.
//        @GetMapping("/exercicetask/{id}")
//        public ResponseEntity<ExerciceTask> getExerciceTask(@PathVariable int id) {
//
//            try {
//                ExerciceTask taskById = tasks.stream().filter(t -> t.getId() == id)
//                        .findFirst()
//                        .orElseThrow();
//                return new ResponseEntity<>(this.tasks.get(id - 405), HttpStatus.OK);
//            } catch (Exception e) {
//                return new ResponseEntity<>(this.defaultTask, HttpStatus.OK);
//            }
//        }
//
//    }









    ///////////////////////////////////////////




//@RestController
//public class Controller2 {
//        ConcurrentLinkedDeque<String> orderedUsers = new ConcurrentLinkedDeque<>();
//        // NOTE ALSO could use CopyOnWriteArrayList
//          // OR    private List<String> names = Collections.synchronizedList(new ArrayList<>());

//        @PostMapping("/users")
//        public void addOrderedUsers(@RequestParam String name) {
//            this.orderedUsers.add(name);
//                    //.add(name);
//        }
//
//        @GetMapping("/users")
//        public ConcurrentLinkedDeque<String> getOrderedUsers() {
//            return this.orderedUsers;
//        }
//
//
//}

    //////////////////////////////



//@RestController
//public class Controller {
//    final ConcurrentHashMap<Long, String> items = new ConcurrentHashMap<>(Map.of(
//            55L, "Chair",
//            99L, "Table",
//            345L, "Vase"
//    ));
//
//    final String ERROR = "Item wasn't found";
//
//    @GetMapping("/items/{id}")
//    String getItem(@PathVariable long id) {
//        String item = items.get(id);
//
//        return item != null ? item : ERROR;
//    }
//
//    // Add your code below this line and do not change the code above the line.
//
//    @DeleteMapping("/items/{id}")
//    public ResponseEntity<String> removeItem(@PathVariable long id) {
////        String item = items.get(id);
//////        items.getOrDefault()
////
////        if (item != null) {
////            items.remove(id);
////
////            return new ResponseEntity<>(item, HttpStatus.OK);
////        } else {
////            return new ResponseEntity<>(ERROR, HttpStatus.OK);
////        }
//
//
////        return new ResponseEntity<>(items.getOrDefault(id, ERROR), HttpStatus.OK);
//
//        String result = items.remove(id);
//        return new ResponseEntity<>((result != null ? result : ERROR), HttpStatus.OK);
//
//    }
//
//}



    /////////////////////////////////





























///////// END ExercicesController
} // END ExercicesController



//import org.springframework.web.bind.annotation.*;
//
//@RestController
//class ArithmeticRestController {
//    @GetMapping("/{operation}")
//    public String calculate(@PathVariable String operation, @RequestParam int a, @RequestParam int b) {
//        final String OP_ADD = "add";
//        final String OP_SUB = "substract";
//        final String OP_MUL = "mult";
//
//        if (OP_ADD.equals(operation)) {
//            return String.valueOf(a + b);
//        } else if (OP_SUB.equals(operation)) {
//                return String.valueOf(a - b)
//        } else if (OP_MUL.equals(operation)) {
//            return String.valueOf(a * b);
//        } else {
//            return "Unknown operation";
//        }
//    }
//}
