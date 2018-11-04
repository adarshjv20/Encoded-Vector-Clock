import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class static_array {
    private static List<array_of_hash> arrayList = new ArrayList<>();
    synchronized public static List<array_of_hash> getArrayList(){
        return arrayList;
    }
}
