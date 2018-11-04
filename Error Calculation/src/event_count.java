import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;

import java.math.BigInteger;
import java.util.*;

import static org.apfloat.ApfloatMath.exp;

public class event_count {
    private static int[] count_array = new int[main.inp_processes + 1];
    public static int j = 0;
    public static int x = 0;
    public static int k = 0;

    synchronized public static int increment_Count(int process_id) throws InterruptedException {
        ++count_array[process_id];
        ++j;

        if(j==(main.inp_processes*50)+1) {
            if (k==0){
                k=1;
                Collections.shuffle(part2_array.get_part2_arraylist());

                System.out.println("max number of events reached at process: "+ process_id);
                Thread myThreads[] = new Thread[part2_array.get_part2_arraylist().size()+5];
                //for(int x = 1 ; x<=part2_array.get_part2_arraylist().size();x++){
                    for (int j = 0; j < part2_array.get_part2_arraylist().size(); j++) {
                        //System.out.println("----"+part2_array.get_part2_arraylist().size());
                        //System.out.println(j);
                        myThreads[j] = new Thread(new error_computations(j));
                        myThreads[j].start();
                    }
                    for (int j = 0; j < part2_array.get_part2_arraylist().size(); j++) {
                        myThreads[j].join(); //todo add catch exception
                        //System.out.println("----"+part2_array.get_part2_arraylist().size());
                    }
                //}

                System.exit(0);
            }
            //for second part

//            //for first part
//            System.out.println(Hash_table.getId_table());
//            //non_static_Hashtable abcd = new non_static_Hashtable();
//            array_of_hash.getArray_of_hash().add(Hash_table.getId_table().clone());
//
//            System.out.println(array_of_hash.getArray_of_hash());
//            //x=0;
        }

        System.out.println("events executed:="+j);
//        System.out.println(Hash_table.getId_table());
//        System.out.println(Hash_table.get_log_hashtable());
        return j;
    }
//

        public static int[] getCount_array () {
            return count_array;
        }
    }

