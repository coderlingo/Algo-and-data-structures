import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort(int[] input) {
        for(int i=0;i<input.length;i++) {
            int min = i;
            // find min in remaining unsorted array
            for(int j=i+1;j<input.length;j++) {
                if(input[min]>input[j]) {
                    min = j;
                }
            }
            // swap to put min in correct index
            if(min!=i) {
                int temp = input[min];
                input[min] = input[i];
                input[i] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int[] input = {2,4,1,7,8,9,3,4};
        selectionSort(input);
        System.out.println(Arrays.toString(input));
    }
}
