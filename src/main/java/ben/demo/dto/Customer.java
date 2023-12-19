package ben.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Customer {
    private int id;
    private String name;

    public Customer() {
        log.info("Constructed.");
    }

    public Customer(int id, String name) {
        this();
        this.name = name;
        this.id = id;
    }
}
