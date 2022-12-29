package sorting;

import java.util.Arrays;

/**
 * Let a be an array of integers. In this exercise we are interested in finding
 * the two entries i and j such that a[i] + a[j] is the closest from a target x.
 * In other words, there are no entries k,l such that |x - (a[i] + a[j])| > |x - (a[k] + a[l])|.
 * Note that we can have i = j.
 * Your program must return the values a[i] and a[j].
 * <p>
 * For example let a = [5, 10, 1, 75, 150, 151, 155, 18, 75, 50, 30]
 * <p>
 * then for x = 20, your program must return the array [10, 10],
 * for x = 153 you must return [1, 151] and
 * for x = 170 you must return [18, 151]
 */
public class ClosestPair {

    /**
     * Finds the pair of integers which sums up to the closest value of x
     *
     * @param a the array in which the value are looked for
     * @param x the target value for the sum
     */
    public static int[] closestPair(int[] a, int x) {
        // TODO STUDENT return null;
        Arrays.sort(a);
        int lo= 0;
        int hi = a.length-1;
        int x_val = a[lo];
        int y_val = a[hi];
        while (lo <hi) {
            int sum = (a[lo] + a[hi]);
            if(sum > x) {
                hi --;
            } else if (sum < x) {
                lo ++;
            } else {
                x_val = a[lo];
                y_val = a[hi];
                break;
            }
            if(Math.abs(x - (a[lo] + a[hi]))< Math.abs(x - (x_val + y_val))) {
                x_val = a[lo];
                y_val = a[hi];
            }
        }
        return new int[] {x_val, y_val};
    }
}
