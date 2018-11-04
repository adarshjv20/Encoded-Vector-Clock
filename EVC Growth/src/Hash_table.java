import java.math.BigInteger;
import java.util.Hashtable;

public class Hash_table {
    private static Hashtable<Integer,BigInteger> id_table = new Hashtable<>();

    synchronized public static Hashtable<Integer,BigInteger> getId_table(){
        return id_table;
    }
}
