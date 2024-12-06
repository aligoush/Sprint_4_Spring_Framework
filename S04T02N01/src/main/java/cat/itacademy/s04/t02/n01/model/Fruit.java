package cat.itacademy.s04.t02.n01.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "fruits")
@Data
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "fruit_name", nullable = false, unique = true)
    private String name;
    @Column(name = "quantity_kg", nullable = false)
    private double quantityKg;
}
