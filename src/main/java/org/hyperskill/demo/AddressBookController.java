package org.hyperskill.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class AddressBookController {
        //    private Map<String, String> <-- TODO how about multithreading? addressBook = new ConcurrentHashMap<>();
        private ConcurrentHashMap<String, String> addressBook = new ConcurrentHashMap<>();

        @PostMapping("/addressbook")
        public String postAddressBook(@RequestParam String name, @RequestParam String address) {
            final String successMessage = "Success: %s added to address book";
            addressBook.put(name, address);
            return String.format(successMessage, name);
        }

        @GetMapping("/addressbook")
        public ResponseEntity<ConcurrentHashMap<String, String>> getAddressBook() {
            // TODO learn and fix optional parameters
            final String errorMessage = "The address book is empty";
            final ConcurrentHashMap<String, String> errorHashMap =
                    new ConcurrentHashMap<>(Map.of("Error",errorMessage));

            if (addressBook.isEmpty()) {
                return new ResponseEntity<>(errorHashMap, HttpStatus.I_AM_A_TEAPOT);
            } else {
                return new ResponseEntity<>(addressBook, HttpStatus.OK);
            }
        }

        @GetMapping("/addressbook/{name}")
        public ResponseEntity<String> getAddressByName(@PathVariable String name) {
            final String errorMessage = "Error: %s No such name";
                return
                        new ResponseEntity<>(addressBook.getOrDefault(name,
                                String.format(errorMessage, name)), HttpStatus.OK);
                // TODO in case of missing name, should not return 200 OK
        }

        @DeleteMapping("/addressbook")
        public String removeByName(@RequestParam String name) {
            final String successMessage = "Success: Address book entry for name %s has been deleted";
            addressBook.remove(name);
            return String.format(successMessage, name);
        }

} // End AddressBookController
