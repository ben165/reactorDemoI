package ben.demo.dao;

import ben.demo.dto.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDao {

    private int amount = 20;

    private static void sleep1(int j) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Customer> getCustomers() {
        return IntStream
                .rangeClosed(1, amount)
                .peek(CustomerDao::sleep1)
                .peek(System.out::println)
                .mapToObj(i -> new Customer(i, "Customer" + i))
                .collect(Collectors.toList());
    }


    public Flux<Customer> getCustomersStreams() {
        return Flux
                .range(1,amount)
                .delayElements(Duration.ofMillis(500))
                .doOnNext(System.out::println)
                .flatMap(i -> Mono.just(new Customer(i, "customer" + i)));
    }


}
