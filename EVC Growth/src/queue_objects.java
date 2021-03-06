import java.math.BigInteger;

public class queue_objects implements Comparable<queue_objects> {
    private int event_id;
    private long event_time;
    private BigInteger evc_stamp;

    public queue_objects(int id,long time,BigInteger evc){
        event_id=id;
        event_time=time;
        evc_stamp = evc;

    }
    synchronized public int get_event_ID(){
        return event_id;
    }
    synchronized public long getTime(){
        return event_time;
    }
    synchronized public BigInteger get_evc_stamp(){
        return evc_stamp;
    }
    synchronized public boolean equals(queue_objects other){
        return  this.getTime()==other.getTime();
    }

    @Override
    synchronized public int compareTo(queue_objects other) {
        if(this.equals(other)){
            return 0;
        }
        else if(getTime()>other.getTime())
        {
            return -1;
        }
        return 1;
    }
}
