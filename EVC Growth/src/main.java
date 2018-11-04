import java.math.BigInteger;
import java.util.*;

public class main {
    static int inp_processes;
    static int no_of_events;
    int get_inp_processes(){
        return inp_processes;
    }
    public int get_no_of_events(){
        return no_of_events;
    }
    public static long[] process_prime;
    public static BigInteger Max_val ;
    public static int overflow_proc;
    public static int internal_count = 0;
    public static int comm_count = 0;

    public static void main(String[] args) {
        prime_gen pr_gen = new prime_gen();
//      Get the number of processes from the user
        //System.out.println("start Time:"+System.currentTimeMillis());
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number of processes:");
        inp_processes = sc.nextInt();
        System.out.println("Enter the bit size ");
        int bit_size = sc.nextInt();
        Max_val = new BigInteger("2").pow(((inp_processes*bit_size)-1));
        process_prime = new long[inp_processes+1];

        //initialize queues for processes
        queue_array queue_obj = new queue_array();
        //*queue_obj.initialize_queue(inp_processes);
        queue_obj.initialize_priority_queue(inp_processes);

        //initialize hash_table and process_prime array
        for(int i = 1; i<=inp_processes;i++){
            long a = pr_gen.prime_gen();
            process_prime[i] = a;
            Hash_table.getId_table().put(i, BigInteger.valueOf(a));
            //*gen_thread set_queue_obj = new gen_thread(i);
            //*set_queue_obj.set_queue();
        }


        //start the entered number of threads
        for(int i = 1; i<=inp_processes;i++){
            Thread t = new Thread(new gen_thread(i));
            t.start();
        }
//        new Thread(){             //check if process value has overflown
//            public void run(){
//                while (true) {
//                    for (overflow_proc=1;overflow_proc<=inp_processes;overflow_proc++) {
//                        if(Hash_table.getId_table().get(overflow_proc).compareTo(main.Max_val)==1){
//                            System.out.println("OVERFLOWN PROCESS!="+ overflow_proc);
//                            System.exit(0);
//                        }
//
//                    }
//                }
//            }
//        }.start();

        //After process value has overflown

        Runtime.getRuntime().addShutdownHook(new Thread(){
            public void run(){
                //System.out.println("original hashtable"+Hash_table.getId_table());
                System.out.println("total events at each process"+Arrays.toString(event_count.getCount_array()));
                int j = 0;
                for(int i:event_count.getCount_array()){
                    j = j+i;
                }
                System.out.println("Total number of events="+ j);

                //calculating the log of evc values of the overflown process at required number of events
                //System.out.println(array_of_hash.getArray_of_hash().size());
                System.out.println();
                    for(int i = 0;i<array_of_hash.getArray_of_hash().size();i++) {

                        Hashtable<Integer, BigInteger> hashtable = (Hashtable<Integer, BigInteger>) array_of_hash.getArray_of_hash().get(i);
                        double a = (Math.log(hashtable.get(overflow_proc).doubleValue()))/Math.log(2);

                        System.out.print(((double)(Math.round(a*100)))/100+", ");

                        //System.out.println(hashtable.get(overflow_proc));
                    }
                System.out.println();
                System.out.println("Internal Events count: " + internal_count);
                System.out.println("communication events count: " + comm_count);


            }
        });

    }

}

