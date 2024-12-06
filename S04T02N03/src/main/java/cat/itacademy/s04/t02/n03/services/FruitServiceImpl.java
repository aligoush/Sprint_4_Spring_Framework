package cat.itacademy.s04.t02.n03.services;

import cat.itacademy.s04.t02.n03.exception.DataNotFoundException;
import cat.itacademy.s04.t02.n03.exception.FruitAlreadyExistsException;
import cat.itacademy.s04.t02.n03.exception.FruitNotFoundException;
import cat.itacademy.s04.t02.n03.model.Fruit;
import cat.itacademy.s04.t02.n03.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitServiceImpl implements FruitService{
    @Autowired
    private FruitRepository fruitRepository;

    @Override
    public Fruit addFruit(Fruit fruit) {
        if(fruitRepository.existsByName(fruit.getName())){
            throw new FruitAlreadyExistsException("That kind of fruit already exists.");
        }
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit updateFruit(Fruit fruit) {
        Fruit fruitToUpdate = getFruitById(fruit.getId());
        fruitToUpdate.setQuantityKg(fruit.getQuantityKg());
        return fruitRepository.save(fruitToUpdate);
    }

    @Override
    public void deleteFruit(String id) {
        getFruitById(id);
        fruitRepository.deleteById(id);
    }

    @Override
    public Fruit getFruitById(String id) {
        return fruitRepository.findById(id).orElseThrow(() ->
                new FruitNotFoundException("Fruit with such id doesn't exist")
        );
    }

    @Override
    public List<Fruit> getAllFruits() {
        List<Fruit> fruits = fruitRepository.findAll();
        if(fruits.isEmpty()){
            throw new DataNotFoundException("There are no fruits in the Database");
        }
        return fruits;
    }
}
