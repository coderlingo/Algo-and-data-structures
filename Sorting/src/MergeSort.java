import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] input, int low, int high, int[] output) {
        if(low<high) {
            int mid = low + (high - low) / 2;
            mergeSort(input, low, mid, output);
            mergeSort(input, mid + 1, high, output);
            merge(input, low,mid+1,high,output);
        }
    }
    public static void merge(int[] input, int low,int mid, int high, int[] output) {
        int l = low;
        int l1 = low,h1=mid-1;
        int l2 = mid, h2= high;
        while(l1<=h1 && l2<=h2) {
            if(input[l1]<=input[l2]) {
                output[l++]= input[l1++];
            }
            else{
                output[l++] = input[l2++];
            }
        }
        while(l1<=h1) {
            output[l++] = input[l1++];
        }
        while(l2<=h2) {
            output[l++] = input[l2++];
        }
        for(int i=low;i<=high;i++){
            input[i] = output[i];
        }
    }
    public static void main(String[] args) {
        int[] input = {4,2,4,1,7,8,9,3,4};
        int[] output=new int[input.length];
        mergeSort(input, 0, input.length-1,output);
        System.out.println(Arrays.toString(output));
        int[] input1 = {432,13,532,218,543,12,8,43,8};
        int[] output1 = new  int[input1.length];
        mergeSort(input1, 0, input.length-1, output1);
        System.out.println(Arrays.toString(output1));
    }
}
