import com.sun.org.apache.bcel.internal.generic.BIPUSH;

import java.math.BigInteger;

public class gcd {
    public static BigInteger get_gcd(BigInteger a, BigInteger b)
    {
        if (a.compareTo(BigInteger.valueOf(0))==0) {
            return b;
        }

        return get_gcd(b.mod(a), a);
    }
}
