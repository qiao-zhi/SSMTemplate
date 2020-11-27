import java.math.BigDecimal;

/**
 * @author: 乔利强
 * @date: 2020/11/25 10:04
 * @description:
 */
public class PlainTest {

    public static void main(String[] args) {
        BigDecimal bigDecimal1 = new BigDecimal(0.001);
        BigDecimal bigDecimal2 = new BigDecimal(0.002);
        BigDecimal bigDecimal3 = BigDecimal.ZERO;
        System.out.println(bigDecimal1.compareTo(bigDecimal2));
        System.out.println(bigDecimal1.compareTo(bigDecimal3));
    }
}
