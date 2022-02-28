import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] input) {
        for(int i = 0;i<input.length;i++) {
            boolean flag = false;
            for(int j=0;j<input.length-i-1;j++) {
                if(input[j]>input[j+1]) {
                    flag = true;
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                }
            }
            if(!flag){
                break;
            }
        }
    }
    public static void main(String[] args) {
        int[] input = {2,4,1,7,8,9,3,4};
        bubbleSort(input);
        System.out.println(Arrays.toString(input));
        int[] input1 = {1,2,3,4,5,6,7};
        bubbleSort(input1);
        System.out.println(Arrays.toString(input1));
    }
}
