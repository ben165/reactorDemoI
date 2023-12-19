package ben.demo.controller;

import ben.demo.dto.Customer;
import ben.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;

    // http://127.0.0.1:8080/customers/sync
    @GetMapping("/sync")
    public List<Customer> getAllCustomers() {
        return service.loadAllCustomers();
    }

    // http://127.0.0.1:8080/customers/stream
    @GetMapping(value = "/stream") //, produces = MediaType.TEXT_EVENT_STREAM_VALUE
    public Flux<Customer> getAllCustomersStream() {
        return service.loadAllCustomersStream();
    }

    // http://127.0.0.1:8080/customers/index
    @GetMapping("/index")
    public String getIndex() {
        return "test";
    }
}
