import animal.Animal;
import animal.Dog;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import org.junit.Test;

/**
 * Created by mtumilowicz on 2018-11-22.
 */
public class GuavaCollectionsTest {

    @Test
    public void immutableSet() {
        ImmutableSet<Dog> dogs = ImmutableSet.of(new Dog(), new Dog());
        ImmutableSet<Animal> animals = ImmutableSet.of(new Dog(), new Dog());
    }

    @Test
    public void immutableList() {
        ImmutableList<Dog> dogs = ImmutableList.of(new Dog(), new Dog());
        ImmutableList<Animal> animals = ImmutableList.of(new Dog(), new Dog());
    }

    @Test
    public void immutableSortedSet() {
        ImmutableSortedSet<Dog> dogs = ImmutableSortedSet.of(new Dog(), new Dog());
        ImmutableSortedSet<Animal> animals = ImmutableSortedSet.of(new Dog(), new Dog());
    }

    @Test
    public void immutableMap() {
        ImmutableMap<Integer, Dog> integerDogMap = ImmutableMap.of(
                1, new Dog(),
                2, new Dog());
        
        ImmutableMap<Number, Animal> numberAnimalMap = ImmutableMap.of(
                1, new Dog(),
                2, new Dog());
    }
}
