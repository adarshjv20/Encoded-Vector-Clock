import java.math.BigInteger;

public class send_event {

    synchronized public void start_event(int process_id){
    //Send event

        rand_num_gen_class rand_num_obj = new rand_num_gen_class();
        //System.out.println("Send Event at process:"+process_id);

        Hash_table.getId_table().put(process_id,Hash_table.getId_table().get(process_id).multiply(BigInteger.valueOf(main.process_prime[process_id]))); //Local process clock increment
        if(Hash_table.getId_table().get(process_id).compareTo(main.Max_val)==1){
            System.out.println("Overflown Process!= "+process_id);
            main.overflow_proc = process_id;
            System.exit(0);
        }
        int destination_process_id = rand_num_obj.rand_num_gen_func(process_id); // randomly generate a destination process id
        //System.out.println("sender_id:" + process_id);
        //System.out.println("Send event from process:"+process_id+" to destination Process:" + destination_process_id);
        queue_array.get_queue()[destination_process_id].add(new queue_objects(2,System.currentTimeMillis()+10,Hash_table.getId_table().get(process_id)));
        try {
            Thread.sleep(1 * 1000);
        }
        catch (InterruptedException f){
            f.printStackTrace();
        }

}
}
