import animal.Animal;
import animal.Cat;
import animal.Dog;
import io.vavr.collection.HashMap;
import io.vavr.collection.HashSet;
import io.vavr.collection.List;
import io.vavr.collection.TreeSet;
import org.junit.Test;

/**
 * Created by mtumilowicz on 2018-11-22.
 */
public class CovariantVavrCollections {
    @Test
    public void hashSet() {
        HashSet<Animal> animals = HashSet.of(new Dog(), new Cat());
    }

    @Test
    public void list() {
        List<Animal> animals = List.of(new Dog(), new Cat());
    }

    @Test
    public void treeSet() {
        TreeSet<Animal> animals = TreeSet.of(new Dog(), new Cat());
    }

    @Test
    public void map() {
        HashMap<Number, Animal> of = HashMap.of(
                1, new Dog(),
                2, new Cat());
    }
}
