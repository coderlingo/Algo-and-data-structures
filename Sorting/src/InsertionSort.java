import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] input) {
        for(int i=1;i<input.length;i++) {
            int val = input[i];
            int j;
            for(j=i-1;j>=0 && input[j]>val;j--) {
                input[j+1] = input[j];
            }
            input[j+1] = val;
        }
    }
    public static void main(String[] args) {
        int[] input = {2,4,1,7,8,9,3,4};
        insertionSort(input);
        System.out.println(Arrays.toString(input));
    }
}
