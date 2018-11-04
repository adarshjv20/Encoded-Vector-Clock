import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class event_count {
    private static int[] count_array = new int[main.inp_processes + 1];
    public static int j = 0;
    public static int x = 0;


    synchronized public static void increment_Count(int process_id) {
        ++count_array[process_id];
        ++x;
        if(x==18) {
            //++k;
            //System.out.println(Hash_table.getId_table());
            //non_static_Hashtable abcd = new non_static_Hashtable();
            array_of_hash.getArray_of_hash().add(Hash_table.getId_table().clone());

            //System.out.println(array_of_hash.getArray_of_hash());
            x=0;
        }
        ++j;
        System.out.println("events executed:="+j);
    }
//

        public static int[] getCount_array () {
            return count_array;
        }
    }

