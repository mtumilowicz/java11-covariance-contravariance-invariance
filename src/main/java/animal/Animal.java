package animal;

/**
 * Created by mtumilowicz on 2018-11-22.
 */
public interface Animal extends Comparable<Animal> {
    @Override
    default int compareTo(Animal o) {
        return 0; // mock
    }
}
