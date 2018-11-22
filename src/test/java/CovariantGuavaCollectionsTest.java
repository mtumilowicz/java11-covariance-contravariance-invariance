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
        ImmutableSet<String> asStrings = ImmutableSet.of("a");
        ImmutableSet<CharSequence> asCharSequence = ImmutableSet.of("a");
    }

    @Test
    public void immutableList() {
        ImmutableList<String> asStrings = ImmutableList.of("a");
        ImmutableList<CharSequence> asCharSequence = ImmutableList.of("a");
    }
    
    @Test
    public void immutableSortedSet() {
        ImmutableSortedSet<String> asStrings = ImmutableSortedSet.of("a");
//        ImmutableSortedSet<CharSequence> asCharSequence = ImmutableSortedSet.of("a");
    }

    @Test
    public void immutableMap() {
        ImmutableMap<String, Integer> stringIntegerMap = ImmutableMap.of("a", 1);
        ImmutableMap<CharSequence, Number> charSequenceNumber = ImmutableMap.of("a", 1);
    }
}
