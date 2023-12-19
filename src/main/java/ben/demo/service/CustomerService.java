package ben.demo.service;

import ben.demo.dao.CustomerDao;
import ben.demo.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerDao dao;


    public List<Customer> loadAllCustomers() {
        return dao.getCustomers();
    }


    public Flux<Customer> loadAllCustomersStream() {
        return dao.getCustomersStreams();
    }




}
