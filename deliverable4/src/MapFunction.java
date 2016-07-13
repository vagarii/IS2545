import java.util.Arrays;

/**
 * Created by XINLAI on 7/11/16.
 */
public class MapFunction {

    public static void main(String[] args) {

        //Test the billify
        int[] a = {1, 2, 3};
        int[] b = {4};
        int[] c = {10 ,10 ,10};
        int[] d = {1, 1, 2, 2, 3, 3};
        int[] e = {5 ,3 ,9};


        int[] a1 = billify(a);
        System.out.println(Arrays.toString(a)+" -> "+Arrays.toString(a1));
        int[] b2 = billify(b);
        System.out.println(Arrays.toString(b)+" -> "+Arrays.toString(b2));
        int[] c3 = billify(c);
        System.out.println(Arrays.toString(c)+" -> "+Arrays.toString(c3));
        int[] d4 = billify(d);
        System.out.println(Arrays.toString(d)+" -> "+ Arrays.toString(d4));
        int[] e5 = billify(e);
        System.out.println(Arrays.toString(e)+" -> "+ Arrays.toString(e5));

    }

    public static int[] billify(int[] a) {

        //add one more entry for square value
        int[] array = new int[a.length + 1];
        int sum = 0;

        //square each entry and add it to sum
        for(int i = 0; i < a.length; i++) {
            array[i] = square(a[i]);
            sum += array[i];
        }

        //add sum to the end of array
        array[a.length] = sum;

        return array;
    }

    public static int square(int n) {

        return n * n;
    }
}
