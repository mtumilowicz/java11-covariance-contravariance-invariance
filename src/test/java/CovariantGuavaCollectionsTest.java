import animal.Animal;
import animal.Cat;
import animal.Dog;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import org.junit.Test;

/**
 * Created by mtumilowicz on 2018-11-22.
 */
public class CovariantGuavaCollectionsTest {

    @Test
    public void immutableSet() {
        ImmutableSet<Animal> animals = ImmutableSet.of(new Dog(), new Cat());
    }

    @Test
    public void immutableList() {
        ImmutableList<Animal> animals = ImmutableList.of(new Dog(), new Cat());
    }

    @Test
    public void immutableSortedSet() {
        ImmutableSortedSet<Animal> animals = ImmutableSortedSet.of(new Dog(), new Cat());
    }

    @Test
    public void immutableMap() {
        ImmutableMap<Number, Animal> stringIntegerMap = ImmutableMap.of(
                1, new Dog(),
                2, new Cat());
    }
}
