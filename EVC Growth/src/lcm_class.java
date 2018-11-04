import java.math.BigInteger;
import java.security.acl.LastOwnerException;

public class lcm_class {
    synchronized public static BigInteger get_lcm(BigInteger x, BigInteger y){
        return (x.multiply(y)).divide(gcd.get_gcd(x,y));


    }
}

