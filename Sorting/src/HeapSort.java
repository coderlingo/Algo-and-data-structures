import java.util.Arrays;

public class HeapSort {
    public static void buildHeap(int[] input) {
        for(int i = (int)Math.floor(input.length/2.0);i>0;i--) {
            heapify(input,i,input.length);
        }
    }
    public static void heapify(int[] input, int idx, int n ) {
        int max;
        while(idx<n) {
            max = idx;
            if ((idx * 2) < n) {
                if (input[max] < input[idx * 2]) {
                    max = idx * 2;
                }
            }
            if ((idx * 2) + 1 < n) {
                if (input[max] < input[(idx * 2) + 1]) {
                    max = (idx * 2) + 1;
                }
            }
            if (max != idx) {
                int temp = input[max];
                input[max] = input[idx];
                input[idx] = temp;
                idx = max;
            } else {
                break;
            }
        }
    }
    public static int[] heapSort(int[] input) {
        int[] result = new int[input.length-1];
        result[0] = -1;
        int idx = 0;
        for(int i=1;i<input.length;i++) {
            result[idx++] = input[1];
            input[1] = input[input.length-i];
            heapify(input,1,input.length-i);
        }
        return  result;
    }
    public static void main(String[] args) {
        int[] input = {-1,2,4,52,1,4,7,843,11,4,66};
        buildHeap(input);
        // Sorts in decreasing order since we are building a max heap
        System.out.println(Arrays.toString(heapSort(input)));
    }
}
