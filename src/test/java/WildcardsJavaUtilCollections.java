import animal.Animal;
import animal.BigDog;
import animal.Dog;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by mtumilowicz on 2018-11-22.
 */
public class WildcardsJavaUtilCollections {
    
    @Test
    public void covariance_is_readOnly() {
        Dog dog = new Dog();
        
        List<Dog> dogs = new LinkedList<>();
        dogs.add(dog);
        
        List<? extends Animal> dogsAsAnimal = dogs;
//        dogsAsAnimal.add(new Dog()); compile time error
//        Dog getDog = dogsAsAnimal.get(0);
        
        Animal getDog = dogsAsAnimal.get(0);

        assertThat(getDog, is(dog));
    }

    @Test
    public void contravariance_is_writeOnly() {
        Dog dog = new Dog();

        List<Dog> dogs = new LinkedList<>();

        List<? super Dog> onlyDogSpecies = dogs;
        onlyDogSpecies.add(new Dog());
        onlyDogSpecies.add(new BigDog());

//        Animal getDog = dogsAsAnimal.get(0); compile time error

        assertThat(onlyDogSpecies.size(), is(2));
    }
}
