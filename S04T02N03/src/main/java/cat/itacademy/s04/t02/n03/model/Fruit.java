package cat.itacademy.s04.t02.n03.model;

import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fruits")
@Data
public class Fruit {
    @Id
    private String id;
    private String name;
    private double quantityKg;
}
