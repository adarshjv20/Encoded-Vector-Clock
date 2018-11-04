import java.math.BigInteger;

public class local_event {
    synchronized public void start_event(int process_id){
        //System.out.println("Local Event at process:" + process_id);
        Hash_table.getId_table().put(process_id,Hash_table.getId_table().get(process_id).multiply(BigInteger.valueOf(main.process_prime[process_id]))); //incrementing by 1 the process's local clock
        if(Hash_table.getId_table().get(process_id).compareTo(main.Max_val)==1){
            System.out.println("Overflown Process!= "+process_id);
            main.overflow_proc = process_id;
            System.exit(0);
        }
    }
}
