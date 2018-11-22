import animal.Animal;
import animal.Cat;
import animal.Dog;
import org.junit.Test;

import java.util.*;

/**
 * Created by mtumilowicz on 2018-11-22.
 */
public class CovariantJavaUtilCollectionsTest {

    @Test
    public void list() {
        List<Animal> animals = List.of(new Dog(), new Cat());
    }

    @Test
    public void unmodifiableList() {
        List<Dog> dogs = new LinkedList<>();
        dogs.add(new Dog());

        List<Animal> dogsAsAnimals = Collections.unmodifiableList(dogs);
    }

    @Test
    public void set() {
        Set<Animal> animals = Set.of(new Dog(), new Cat());
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
                2, new Cat());
    }
    
    @Test
    public void unmodifiableMap() {
        Map<Integer, Cat> cats = new HashMap<>();
        cats.put(1, new Cat());

        Map<Number, Animal> map = Collections.unmodifiableMap(cats);
    }
    
    @Test
    public void unmodifiableNavigableSet() {
        TreeSet<Cat> cats = new TreeSet<>();
        cats.add(new Cat());

        NavigableSet<Cat> catsAsAnimals = Collections.unmodifiableNavigableSet(cats);
    }

    @Test
    public void unmodifiableSortedSet() {
        TreeSet<Cat> cats = new TreeSet<>();
        cats.add(new Cat());

        SortedSet<Cat> catsAsAnimals = Collections.unmodifiableSortedSet(cats);
    }
    
    @Test
    public void unmodifiableCollection() {
        Set<Dog> dogs = new HashSet<>();
        dogs.add(new Dog());

        Collection<Animal> map = Collections.unmodifiableCollection(dogs);
    }
}
