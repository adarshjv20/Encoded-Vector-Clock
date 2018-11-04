
import java.util.*;


public class array_of_hash {
    private static List<Object> array_of_hash = new ArrayList<>();

    synchronized static List<Object> getArray_of_hash(){
        return array_of_hash;
    }
}
