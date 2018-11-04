import java.math.BigInteger;

public class receive_event {
    synchronized public void start_event(int process_id,BigInteger evc){
        //System.out.println("Receive event at process:"+process_id);

        try {
            Hash_table.getId_table().put(process_id,lcm_class.get_lcm(Hash_table.getId_table().get(process_id),evc).multiply(BigInteger.valueOf(main.process_prime[process_id])));
            if(Hash_table.getId_table().get(process_id).compareTo(main.Max_val)==1){
                System.out.println("Overflown Process!= "+process_id);
                main.overflow_proc = process_id;
                System.exit(0);
            }
        }
        catch (NullPointerException e) {
            try {
                Thread.sleep(1 * 1000);
            }
            catch (InterruptedException f){
                f.printStackTrace();
            }

        }


    }
}
