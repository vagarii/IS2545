/**
 * Created by XINLAI on 7/11/16.
 */

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Random;

public class ArrayListTest {

    //numbers of array: 1000
    private final static int numArray = 1000;

    private int[] generateArray() {

        Random rd = new Random();

        //array length: 1 - 100(inclusive)
        int length = rd.nextInt(100) + 1;
        int[] array = new int[length];

        //array values: 1 - 100(inclusive)
        for(int i = 0; i < array.length; i++) {
            array[i] = rd.nextInt(100) + 1;
        }

        return array;
    }

    //1st Property Test: Array Size property
    //The output array should always have a length that is one
    //greater than the input array.
    @Test
    public void testArraySize() {
        for(int i = 0; i < numArray; i++) {
            int[] a = generateArray();
            int[] result = MapFunction.billify(a);
            if(result.length != (a.length + 1)) {
                fail();
            }
        }
    }

    //2ed Property Test: Input equals Output property
    //Each integer of the input array, should equal to the square of
    //output array, except the last integer; meantime, the index of input
    //array should also the same of the output array.
    @Test
    public void testSquare() {
        for(int i = 0; i < numArray; i++) {
            int[] a = generateArray();
            int[] result = MapFunction.billify(a);

            for(int j = 0; j < a.length; j++) {
                int result1 = a[j] * a[j];
                if(result[j] != result1) {
                    fail();
                }
            }
        }
    }

    //3th Property Test: Sum property
    //The last value of the output array should be the
    //sum of each other integer's square
    @Test
    public void testSum() {
        for(int i = 0; i < numArray; i++) {
            int sum = 0;
            int[] a = generateArray();
            int[] result = MapFunction.billify(a);

            for(int j = 0; j < a.length; j++) {
                sum += a[j] * a[j];
            }

            if(result[a.length] != sum) {
                fail();
            }
        }
    }

    //4th Property Test: Purity property
    //Running it twice on same input array should
    //always result in same output array.
    @Test
    public void testPurity() {

        for(int i = 0; i < numArray; i++) {
            int [] r = generateArray();
            int[] result = MapFunction.billify(r);
            int[] result1 = MapFunction.billify(r);

            assertArrayEquals(result, result1);
        }

    }

}
