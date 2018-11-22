import animal.Animal;
import animal.Cat;
import animal.Dog;
import org.junit.Test;

import java.util.*;

/**
 * Created by mtumilowicz on 2018-11-22.
 */
public class JavaUtilCollectionsTest {
    
    @Test
    public void array_ok() {
        Dog[] dogs = new Dog[5];
        Animal[] animals = dogs;

        animals[0] = new Dog();
    }

    @Test(expected = ArrayStoreException.class)
    public void array_runtimeError() {
        Dog[] dogs = new Dog[5];
        Animal[] animals = dogs;

        animals[0] = new Cat();
    }

    @Test
    public void list() {
        List<Dog> dogs = List.of(new Dog(), new Dog());
        List<Animal> animals = List.of(new Dog(), new Dog());
    }

    @Test
    public void unmodifiableList() {
        List<Dog> dogs = new LinkedList<>();
        dogs.add(new Dog());

        List<Animal> dogsAsAnimals = Collections.unmodifiableList(dogs);
    }

    @Test
    public void set() {
        Set<Dog> dogs = Set.of(new Dog(), new Dog());
        Set<Animal> animals = Set.of(new Dog(), new Dog());
    }
    
    @Test
    public void unmodifiableSet() {
        Set<Dog> dogs = new HashSet<>();
        dogs.add(new Dog());

        Set<Animal> dogsAsAnimals = Collections.unmodifiableSet(dogs);
    }

    @Test
    public void map() {
        Map<Integer, Dog> integerDogMap = Map.of(
                1, new Dog(),
                2, new Dog());
        
        Map<Number, Animal> numberAnimalMap = Map.of(
                1, new Dog(),
                2, new Dog());
    }
    
    @Test
    public void unmodifiableMap() {
        Map<Integer, Dog> dogs = new HashMap<>();
        dogs.put(1, new Dog());

        Map<Number, Animal> map = Collections.unmodifiableMap(dogs);
    }
    
    @Test
    public void unmodifiableNavigableSet() {
        TreeSet<Dog> dogs = new TreeSet<>();
        dogs.add(new Dog());

        NavigableSet<Dog> dogsAsAnimals = Collections.unmodifiableNavigableSet(dogs);
    }

    @Test
    public void unmodifiableSortedSet() {
        TreeSet<Dog> dogs = new TreeSet<>();
        dogs.add(new Dog());

        SortedSet<Dog> dogsAsAnimals = Collections.unmodifiableSortedSet(dogs);
    }
    
    @Test
    public void unmodifiableCollection() {
        Set<Dog> dogs = new HashSet<>();
        dogs.add(new Dog());

        Collection<Animal> map = Collections.unmodifiableCollection(dogs);
    }
}
