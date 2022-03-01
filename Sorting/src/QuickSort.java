import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] input, int low, int high, int[] output) {
        if(low<high) {
            int mid = partition(input,low,high);
            quickSort(input, low, mid-1, output);
            quickSort(input, mid + 1, high, output);
        }
    }
    public static int partition(int[] input, int low, int high) {
        int idx = low;
        int i = low+1;
        int j = high;
        while(i<j){
            while(i<input.length && input[i]<=input[idx]){
                i++;
            }
            while(j>i && input[j]>input[idx]) {
                j--;
            }
            if(i<j) {
                int temp = input[i];
                input[i] = input[j];
                input[j] = temp;
                i++;
            }
        }
        int temp = input[i-1];
        input[i-1] = input[idx];
        input[idx] = temp;
        return i-1;
    }
    public static void main(String[] args) {
        int[] input = {4,2,4,1,7,8,9,3,4};
        int[] output=new int[input.length];
        quickSort(input, 0, input.length-1,output);
        System.out.println(Arrays.toString(input));
        int[] input1 = {432,13,532,218,543,12,8,43,8};
        int[] output1 = new  int[input1.length];
        quickSort(input1, 0, input.length-1, output1);
        System.out.println(Arrays.toString(input1));
    }
}
