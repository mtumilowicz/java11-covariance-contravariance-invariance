import animal.Animal;
import animal.Dog;
import org.junit.Test;

import java.util.*;

/**
 * Created by mtumilowicz on 2018-11-22.
 */
public class CovariantJavaUtilCollectionsTest {
    
    @Test
    public void array_ok() {
        Integer[] intArr = new Integer[5];
        Number[] numArr = intArr;

        numArr[0] = 1;
    }

    @Test(expected = ArrayStoreException.class)
    public void array_runtimeError() {
        Integer[] intArr = new Integer[5];
        Number[] numArr = intArr;

        numArr[0] = 1.5;
    }

    @Test
    public void list() {
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
        Map<Number, Animal> animals = Map.of(
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
