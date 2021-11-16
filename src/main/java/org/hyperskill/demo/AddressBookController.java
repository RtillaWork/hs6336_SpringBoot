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
        public void postAddressBook(@RequestParam String name, @RequestParam String address) {
            addressBook.put(name, address);
        }

        @GetMapping("/addressbook")
        public ResponseEntity<ConcurrentHashMap<String, String>> getAddressBook() {
            // TODO learn and fix optional parameters
            final ConcurrentHashMap<String, String> errorEmptyAddressBookMessage =
                    new ConcurrentHashMap<>(Map.of("Error","The address book is empty"));

            if (addressBook.isEmpty()) {
                return new ResponseEntity<>(errorEmptyAddressBookMessage, HttpStatus.I_AM_A_TEAPOT);
            } else {
                return new ResponseEntity<>(addressBook, HttpStatus.OK);
            }
        }

        @GetMapping("/addressbook/{name}")
        public ResponseEntity<String> getAddressBookByName(@PathVariable String name) {
            final String errorMissingNameFromAddressBookMessage = "No such name";
                return
                        new ResponseEntity<>(addressBook.getOrDefault(name,
                                errorMissingNameFromAddressBookMessage), HttpStatus.OK);
                // TODO in case of missing name, should not return 200 OK
        }

} // End AddressBookController
