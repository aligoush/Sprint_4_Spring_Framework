package cat.itacademy.s04.t02.n03.controllers;

import cat.itacademy.s04.t02.n03.model.Fruit;
import cat.itacademy.s04.t02.n03.services.FruitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/fruits")
public class FruitController {
    @Autowired
    private FruitServiceImpl fruitService;

    @PostMapping("/add")
    public ResponseEntity<Fruit> addFruit(@RequestBody Fruit fruit) {
        Fruit newFruit = fruitService.addFruit(fruit);
        URI location = URI.create("/fruit/" + newFruit.getId());
        return ResponseEntity.created(location).body(newFruit);
    }

    @PutMapping("/update")
    public ResponseEntity<Fruit> updateFruit(@RequestBody Fruit fruit) {
        Fruit updatedFruit = fruitService.updateFruit(fruit);
        URI location = URI.create("/fruit/" + updatedFruit.getId());
        return ResponseEntity.created(location).body(updatedFruit);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFruit(@PathVariable String id) {
        fruitService.deleteFruit(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruit> getOne(@PathVariable String id) {
        return ResponseEntity.ok(fruitService.getFruitById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> getAll() {
        return ResponseEntity.ok(fruitService.getAllFruits());
    }
}
