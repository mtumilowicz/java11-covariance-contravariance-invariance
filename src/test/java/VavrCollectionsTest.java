import animal.Animal;
import animal.Dog;
import io.vavr.collection.HashMap;
import io.vavr.collection.HashSet;
import io.vavr.collection.List;
import io.vavr.collection.TreeSet;
import org.junit.Test;

/**
 * Created by mtumilowicz on 2018-11-22.
 */
public class VavrCollectionsTest {
    @Test
    public void hashSet() {
        HashSet<Dog> dogs = HashSet.of(new Dog(), new Dog());
        HashSet<Animal> animals = HashSet.ofAll(dogs);
        HashSet<Animal> animals2 = HashSet.narrow(dogs);
        
        HashSet<Animal> animals3 = HashSet.of(new Dog(), new Dog());
    }

    @Test
    public void list() {
        List<Dog> dogs = List.of(new Dog(), new Dog());
        List<Animal> animals = List.ofAll(dogs);
        List<Animal> animals2 = List.narrow(dogs);
        
        List<Animal> animals3 = List.of(new Dog(), new Dog());
    }

    @Test
    public void treeSet() {
        TreeSet<Dog> dogs = TreeSet.of(new Dog(), new Dog());
        TreeSet<Animal> animals = TreeSet.ofAll(dogs);
        TreeSet<Animal> animals2 = TreeSet.narrow(dogs);
        
        TreeSet<Animal> animals3 = TreeSet.of(new Dog(), new Dog());
    }

    @Test
    public void map() {
        HashMap<Integer, Dog> integerDogMap = HashMap.of(
                1, new Dog(),
                2, new Dog());

//        HashMap.ofAll(integerDogMap); // only for java.util.map
        HashMap<Number, Animal> numberAnimalMap2 = HashMap.narrow(integerDogMap);
                
        HashMap<Number, Animal> numberAnimalMap3 = HashMap.of(
                1, new Dog(),
                2, new Dog());
    }
}
