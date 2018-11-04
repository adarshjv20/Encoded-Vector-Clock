import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;
import org.apfloat.ApfloatRuntimeException;

import java.math.BigInteger;

import static org.apfloat.ApfloatMath.exp;
import static org.apfloat.ApfloatMath.negate;

public class error_computations implements Runnable {
    public int event_num;
    public static int e_mod_f;
    public static int f_mod_e;
    public static int e_sub_f;
    public static int f_sub_e;
    public static int case_1;
    public static int case_2;
    public static int case_3;
    public static int case_4;
    public static int case_5;
    public static int case_6;
    public static int case_7;
    public static int case_8;
    public static int case_9;
    public static int case_10;
    public static int case_11;
    public static int case_12;
    public static int test_postive;
    public static Apfloat var1;
    public static Apfloat var2;

    public error_computations(int event_no) {
        this.event_num = event_no;
    }

    {

    }

    synchronized public void run() {
        for (int y = event_num + 1; y < part2_array.get_part2_arraylist().size(); y++) {
            //System.out.println("x="+event_num+"y="+y);

            //main.setTotal_loop_events(main.getTotal_loop_events()+1);
            ++main.total_loop_events;
            try {
                if((part2_array.get_part2_arraylist().get(event_num).getLog_evc_val().compareTo(part2_array.get_part2_arraylist().get(y).getLog_evc_val()))==1){
                    var1 = exp(ApfloatMath.log(new Apfloat(10, main.precision)).multiply(part2_array.get_part2_arraylist().get(event_num).getLog_evc_val().subtract(part2_array.get_part2_arraylist().get(y).getLog_evc_val())));
                }
                else {
                    var1 = new Apfloat(1.11111111111111111111,main.precision);
                    //System.out.println(var1.precision(var1.floor().toBigInteger().toString().length() + 10).compareTo(var1.floor()) == 0);
                }
                if((part2_array.get_part2_arraylist().get(event_num).getLog_evc_val().compareTo(part2_array.get_part2_arraylist().get(y).getLog_evc_val()))==-1){
                    var2 = exp(ApfloatMath.log(new Apfloat(10, main.precision)).multiply(part2_array.get_part2_arraylist().get(y).getLog_evc_val().subtract(part2_array.get_part2_arraylist().get(event_num).getLog_evc_val())));
                }
                else {
                    var2 = new Apfloat(1.111111111111111,main.precision);
                }

                if(!(part2_array.get_part2_arraylist().get(event_num).getEvc_val().mod(part2_array.get_part2_arraylist().get(y).getEvc_val())).equals(BigInteger.ZERO)&&
                        !(part2_array.get_part2_arraylist().get(y).getEvc_val().mod(part2_array.get_part2_arraylist().get(event_num).getEvc_val())).equals(BigInteger.ZERO)&&
                        !(var1.precision(var1.floor().toBigInteger().toString().length() + 10).compareTo(var1.floor()) == 0)&&
                        !(var2.precision(var2.floor().toBigInteger().toString().length() + 10).compareTo(var2.floor()) == 0))
                {
                    ++main.true_negative;
                    ++case_1;
                }
                if (!(part2_array.get_part2_arraylist().get(event_num).getEvc_val().mod(part2_array.get_part2_arraylist().get(y).getEvc_val())).equals(BigInteger.ZERO)&&
                        !(part2_array.get_part2_arraylist().get(y).getEvc_val().mod(part2_array.get_part2_arraylist().get(event_num).getEvc_val())).equals(BigInteger.ZERO)&&
                        (var1.precision(var1.floor().toBigInteger().toString().length() + 10).compareTo(var1.floor()) == 0)&&
                        !(var2.precision(var2.floor().toBigInteger().toString().length() + 10).compareTo(var2.floor()) == 0)){
                    ++main.false_positive;//case 2
                    ++case_2;
                }
                if (!(part2_array.get_part2_arraylist().get(event_num).getEvc_val().mod(part2_array.get_part2_arraylist().get(y).getEvc_val())).equals(BigInteger.ZERO)&&
                        !(part2_array.get_part2_arraylist().get(y).getEvc_val().mod(part2_array.get_part2_arraylist().get(event_num).getEvc_val())).equals(BigInteger.ZERO)&&
                        !(var1.precision(var1.floor().toBigInteger().toString().length() + 10).compareTo(var1.floor()) == 0)&&
                        (var2.precision(var2.floor().toBigInteger().toString().length() + 10).compareTo(var2.floor()) == 0)){
                    ++main.false_positive;//case 3
                    ++case_3;
                }
                if ((part2_array.get_part2_arraylist().get(event_num).getEvc_val().mod(part2_array.get_part2_arraylist().get(y).getEvc_val())).equals(BigInteger.ZERO)&&
                        !(part2_array.get_part2_arraylist().get(y).getEvc_val().mod(part2_array.get_part2_arraylist().get(event_num).getEvc_val())).equals(BigInteger.ZERO)&&
                        !(var1.precision(var1.floor().toBigInteger().toString().length() + 10).compareTo(var1.floor()) == 0)&&
                        !(var2.precision(var2.floor().toBigInteger().toString().length() + 10).compareTo(var2.floor()) == 0)){
                    ++main.false_negative;// case 4
                    ++case_4;
                }
                if ((part2_array.get_part2_arraylist().get(event_num).getEvc_val().mod(part2_array.get_part2_arraylist().get(y).getEvc_val())).equals(BigInteger.ZERO)&&
                        !(part2_array.get_part2_arraylist().get(y).getEvc_val().mod(part2_array.get_part2_arraylist().get(event_num).getEvc_val())).equals(BigInteger.ZERO)&&
                        (var1.precision(var1.floor().toBigInteger().toString().length() + 10).compareTo(var1.floor()) == 0)&&
                        !(var2.precision(var2.floor().toBigInteger().toString().length() + 10).compareTo(var2.floor()) == 0)){
                    ++main.true_positive;//case 5
                    ++case_5;
                }
                if ((part2_array.get_part2_arraylist().get(event_num).getEvc_val().mod(part2_array.get_part2_arraylist().get(y).getEvc_val())).equals(BigInteger.ZERO)&&
                        !(part2_array.get_part2_arraylist().get(y).getEvc_val().mod(part2_array.get_part2_arraylist().get(event_num).getEvc_val())).equals(BigInteger.ZERO)&&
                        !(var1.precision(var1.floor().toBigInteger().toString().length() + 10).compareTo(var1.floor()) == 0)&&
                        (var2.precision(var2.floor().toBigInteger().toString().length() + 10).compareTo(var2.floor()) == 0)){
                    ++main.false_negative;//case 6
                    ++case_6;
                }
                if (!(part2_array.get_part2_arraylist().get(event_num).getEvc_val().mod(part2_array.get_part2_arraylist().get(y).getEvc_val())).equals(BigInteger.ZERO)&&
                        (part2_array.get_part2_arraylist().get(y).getEvc_val().mod(part2_array.get_part2_arraylist().get(event_num).getEvc_val())).equals(BigInteger.ZERO)&&
                        !(var1.precision(var1.floor().toBigInteger().toString().length() + 10).compareTo(var1.floor()) == 0)&&
                        !(var2.precision(var2.floor().toBigInteger().toString().length() + 10).compareTo(var2.floor()) == 0)){
                    ++main.false_negative;//case 7
                    ++case_7;
                }
                if (!(part2_array.get_part2_arraylist().get(event_num).getEvc_val().mod(part2_array.get_part2_arraylist().get(y).getEvc_val())).equals(BigInteger.ZERO)&&
                        (part2_array.get_part2_arraylist().get(y).getEvc_val().mod(part2_array.get_part2_arraylist().get(event_num).getEvc_val())).equals(BigInteger.ZERO)&&
                        (var1.precision(var1.floor().toBigInteger().toString().length() + 10).compareTo(var1.floor()) == 0)&&
                        !(var2.precision(var2.floor().toBigInteger().toString().length() + 10).compareTo(var2.floor()) == 0)){
                    ++main.false_negative;//case 8
                    ++case_8;
                }
                else if (!(part2_array.get_part2_arraylist().get(event_num).getEvc_val().mod(part2_array.get_part2_arraylist().get(y).getEvc_val())).equals(BigInteger.ZERO)&&
                        (part2_array.get_part2_arraylist().get(y).getEvc_val().mod(part2_array.get_part2_arraylist().get(event_num).getEvc_val())).equals(BigInteger.ZERO)&&
                        !(var1.precision(var1.floor().toBigInteger().toString().length() + 10).compareTo(var1.floor()) == 0)&&
                        (var2.precision(var2.floor().toBigInteger().toString().length() + 10).compareTo(var2.floor()) == 0)){
                    ++main.true_positive;//case 9
                    ++case_9;
                }
                if (!(part2_array.get_part2_arraylist().get(event_num).getEvc_val().mod(part2_array.get_part2_arraylist().get(y).getEvc_val())).equals(BigInteger.ZERO)&&
                        !(part2_array.get_part2_arraylist().get(y).getEvc_val().mod(part2_array.get_part2_arraylist().get(event_num).getEvc_val())).equals(BigInteger.ZERO)&&
                        (var1.precision(var1.floor().toBigInteger().toString().length() + 10).compareTo(var1.floor()) == 0)&&
                        (var2.precision(var2.floor().toBigInteger().toString().length() + 10).compareTo(var2.floor()) == 0)){
                    ++main.false_positive;//case 10
                    ++case_10;
                }
                if ((part2_array.get_part2_arraylist().get(event_num).getEvc_val().mod(part2_array.get_part2_arraylist().get(y).getEvc_val())).equals(BigInteger.ZERO)&&
                        !(part2_array.get_part2_arraylist().get(y).getEvc_val().mod(part2_array.get_part2_arraylist().get(event_num).getEvc_val())).equals(BigInteger.ZERO)&&
                        (var1.precision(var1.floor().toBigInteger().toString().length() + 10).compareTo(var1.floor()) == 0)&&
                        (var2.precision(var2.floor().toBigInteger().toString().length() + 10).compareTo(var2.floor()) == 0)) {
                    ++main.true_positive;//case 11
                    ++case_11;
                }
                if ((!(part2_array.get_part2_arraylist().get(event_num).getEvc_val().mod(part2_array.get_part2_arraylist().get(y).getEvc_val())).equals(BigInteger.ZERO))&&
                        ((part2_array.get_part2_arraylist().get(y).getEvc_val().mod(part2_array.get_part2_arraylist().get(event_num).getEvc_val())).equals(BigInteger.ZERO))&&
                        ((var1.precision(var1.floor().toBigInteger().toString().length() + 10).compareTo(var1.floor()) == 0))&&
                        ((var2.precision(var2.floor().toBigInteger().toString().length() + 10).compareTo(var2.floor()) == 0))) {
                    System.out.println("----------------------------------------------------------------------------");
                    System.out.println((part2_array.get_part2_arraylist().get(event_num).getEvc_val().mod(part2_array.get_part2_arraylist().get(y).getEvc_val())));
                    System.out.println((part2_array.get_part2_arraylist().get(y).getEvc_val().mod(part2_array.get_part2_arraylist().get(event_num).getEvc_val())));
                    System.out.println((var1.precision(var1.floor().toBigInteger().toString().length() + 10).compareTo(var1.floor()) == 0));
                    System.out.println((var2.precision(var2.floor().toBigInteger().toString().length() + 10).compareTo(var2.floor()) == 0));
                    System.out.println("-----------------------------------------------------------------------------");
                    ++main.true_positive;//case 12
                    ++case_12;
                }
//                if((part2_array.get_part2_arraylist().get(event_num).getEvc_val().compareTo(part2_array.get_part2_arraylist().get(y).getEvc_val()))==1){
//                    ++main.total_y_less_x;
//                    if ((part2_array.get_part2_arraylist().get(event_num).getEvc_val().mod(part2_array.get_part2_arraylist().get(y).getEvc_val())).equals(BigInteger.ZERO)) {
//                        ++main.total_y_happen_before_x;
//                        e_mod_f = 1;
//
//                    }
//                    else {
//                        e_mod_f = 0;
//                    }
//                }
//                if((part2_array.get_part2_arraylist().get(event_num).getEvc_val().compareTo(part2_array.get_part2_arraylist().get(y).getEvc_val()))==-1){
//                    ++main.total_x_less_y;
//                    if ((part2_array.get_part2_arraylist().get(y).getEvc_val().mod(part2_array.get_part2_arraylist().get(event_num).getEvc_val())).equals(BigInteger.ZERO)) {
//                        ++main.total_x_happen_before_y;
//                        f_mod_e = 1;
//                    }
//                    else {
//                        f_mod_e = 0;
//                    }
//                }
//
//                try {
//                    if((part2_array.get_part2_arraylist().get(event_num).getLog_evc_val().compareTo(part2_array.get_part2_arraylist().get(y).getLog_evc_val()))==1){
//                        Apfloat var = exp(ApfloatMath.log(new Apfloat(10, main.precision)).multiply(part2_array.get_part2_arraylist().get(event_num).getLog_evc_val().subtract(part2_array.get_part2_arraylist().get(y).getLog_evc_val())));
//                        if (var.precision(var.floor().toBigInteger().toString().length() + 10).compareTo(var.floor()) == 0) {
//                        //if (var.compareTo(var.floor()) == 0) {
//                            e_sub_f = 1;
//                        }
//                        else {
//                            e_sub_f = 0;
//                        }
//                    }
//                    if((part2_array.get_part2_arraylist().get(event_num).getLog_evc_val().compareTo(part2_array.get_part2_arraylist().get(y).getLog_evc_val()))==-1){
//                        Apfloat var = exp(ApfloatMath.log(new Apfloat(10, main.precision)).multiply(part2_array.get_part2_arraylist().get(y).getLog_evc_val().subtract(part2_array.get_part2_arraylist().get(event_num).getLog_evc_val())));
//                        if (var.precision(var.floor().toBigInteger().toString().length() + 10).compareTo(var.floor()) == 0) {
//                        //if (var.compareTo(var.floor()) == 0) {
//                            f_sub_e = 1;
//                        }
//                        else {
//                            f_sub_e = 0;
//                        }
//                    }
//
//
//                } catch (ApfloatRuntimeException e) {
//
//                }
//                if(e_mod_f == 0 && f_mod_e == 0 && e_sub_f ==0 && f_sub_e ==0){
//                    ++main.true_negative;//case 1
//                    ++case_1;
//                }
//                else if (e_mod_f == 0 && f_mod_e == 0 && e_sub_f ==1 && f_sub_e ==0){
//                    ++main.false_positive;//case 2
//                    ++case_2;
//                }
//                else if (e_mod_f == 0 && f_mod_e == 0 && e_sub_f ==0 && f_sub_e ==1){
//                    ++main.false_positive;//case 3
//                    ++case_3;
//                }
//                else if (e_mod_f == 1 && f_mod_e == 0 && e_sub_f ==0 && f_sub_e ==0){
//                    ++main.false_negative;// case 4
//                    ++case_4;
//                }
//                else if (e_mod_f == 1 && f_mod_e == 0 && e_sub_f ==1 && f_sub_e ==0){
//                    ++main.true_positive;//case 5
//                    ++case_5;
//                }
//                else if (e_mod_f == 1 && f_mod_e == 0 && e_sub_f ==0 && f_sub_e ==1){
//                    ++main.false_negative;//case 6
//                    ++case_6;
//                }
//                else if (e_mod_f == 0 && f_mod_e == 1 && e_sub_f ==0 && f_sub_e ==0){
//                    ++main.false_negative;//case 7
//                    ++case_7;
//                }
//                else if (e_mod_f == 0 && f_mod_e == 1 && e_sub_f ==1 && f_sub_e ==0){
//                    ++main.false_negative;//case 8
//                    ++case_8;
//                }
//                else if (e_mod_f == 0 && f_mod_e == 1 && e_sub_f ==0 && f_sub_e ==1){
//                    ++main.true_positive;//case 9
//                    ++case_9;
//                }
//                else if (e_mod_f == 0 && f_mod_e == 0 && e_sub_f ==1 && f_sub_e ==1){
//                    ++main.false_positive;//case 10
//                    ++case_10;
//                }
//                else if (e_mod_f == 1 && f_mod_e == 0 && e_sub_f ==1 && f_sub_e ==1) {
//                    ++main.true_positive;//case 11
//                    ++case_11;
//                }
//                else if (e_mod_f == 0 && f_mod_e == 1 && e_sub_f ==1 && f_sub_e ==1) {
//                    ++main.true_positive;//case 12
//                    ++case_12;
//                }
//                e_mod_f=0;
//                f_mod_e=0;
//                e_sub_f=0;
//                f_sub_e=0;
            } catch (IndexOutOfBoundsException|ApfloatRuntimeException e) {
                break;
            }
        }
    }
}





//                    if((part2_array.get_part2_arraylist().get(event_num).getEvc_val().compareTo(part2_array.get_part2_arraylist().get(y).getEvc_val()))==1){
//                    //main.setTotal_y_less_x(main.getTotal_y_less_x()+1);
//                    //++main.total_y_less_x;
//                    if((part2_array.get_part2_arraylist().get(event_num).getEvc_val().mod(part2_array.get_part2_arraylist().get(y).getEvc_val())).equals(BigInteger.ZERO)){
//                        //++main.total_y_happen_before_x;
//                        if((part2_array.get_part2_arraylist().get(event_num).getLog_evc_val().compareTo(part2_array.get_part2_arraylist().get(y).getLog_evc_val()))==-1){
//                            //main.setFalse_negative(main.getFalse_negative()+1);
//                            ++main.false_positive;
//                        }
//                        else if((part2_array.get_part2_arraylist().get(event_num).getLog_evc_val().compareTo(part2_array.get_part2_arraylist().get(y).getLog_evc_val()))==1){
//                            Apfloat var = exp(ApfloatMath.log(new Apfloat(10,main.precision)).multiply(part2_array.get_part2_arraylist().get(event_num).getLog_evc_val().subtract(part2_array.get_part2_arraylist().get(y).getLog_evc_val())));
//                            if(var.precision(var.floor().toBigInteger().toString().length()+3).compareTo(var.floor())==0){
//                                //System.out.println(var);
//                                //main.setTrue_positive(main.getTrue_positive()+1);
//                                ++main.true_negative;
//                            }
//                            else{
//                                //System.out.println(var);
//                                //main.setFalse_negative(main.getFalse_negative()+1);
//                                ++main.false_positive;
//                            }
//                        }
//                    }
//                    else if((part2_array.get_part2_arraylist().get(y).getEvc_val().mod(part2_array.get_part2_arraylist().get(event_num).getEvc_val())).equals(BigInteger.ZERO)){
//
//                    }
//                    }
//                else if((part2_array.get_part2_arraylist().get(event_num).getEvc_val().compareTo(part2_array.get_part2_arraylist().get(y).getEvc_val()))==-1){
//                    //main.setTotal_x_less_y(main.getTotal_x_less_y()+1);
//                    ++main.total_x_less_y;
//
//                    if((part2_array.get_part2_arraylist().get(y).getEvc_val().mod(part2_array.get_part2_arraylist().get(event_num).getEvc_val())).equals(BigInteger.ZERO)){
//                        ++main.total_x_happen_before_y;
//                        if((part2_array.get_part2_arraylist().get(event_num).getLog_evc_val().compareTo(part2_array.get_part2_arraylist().get(y).getLog_evc_val()))==1){
//                            //main.setFalse_positive(main.getFalse_positive()+1);
//                            ++main.false_negative;
//                        }
//                        else if((part2_array.get_part2_arraylist().get(event_num).getLog_evc_val().compareTo(part2_array.get_part2_arraylist().get(y).getLog_evc_val()))==-1){
//                            try {
//                                Apfloat var = exp(ApfloatMath.log(new Apfloat(10, main.precision)).multiply(part2_array.get_part2_arraylist().get(y).getLog_evc_val().subtract(part2_array.get_part2_arraylist().get(event_num).getLog_evc_val())));
//                                if(var.precision(var.floor().toBigInteger().toString().length()+3).compareTo(var.floor())==0){
//                                    //System.out.println(var);
//                                    //main.setTrue_negative(main.getTrue_negative()+1);
//                                    ++main.true_positive;
//                                }
//                                else {
//                                    //System.out.println(var);
//                                    //main.setFalse_positive(main.getFalse_positive()+1);
//                                    ++main.false_negative;
//                                }
//                            }
//                            catch (ApfloatRuntimeException e){
//
//                            }
//
//                        }
//
//                    }
//
//                }
//            }
//            catch (IndexOutOfBoundsException|NullPointerException e){
//                break;
//            }
//
//        }
//    }
//}
