import java.util.Arrays;

public class RadixSort {
    public static void countingSort(int[] input, int range, int pow) {
        int[] count = new int[range];
        int[] index = new int[range];
        int[] output = new int[input.length];

        Arrays.stream(input).forEach(e->count[(e/pow)%10]++);
        index[0] = count[0];
        for(int i=1;i<count.length;i++) {
            index[i] = index[i-1]+count[i];
        }
        for(int i =0;i<input.length;i++) {
            int idx = (input[i]/pow)%10;
            output[index[idx]-count[idx]] = input[i];
            count[idx]--;
        }
        for(int i = 0;i<input.length;i++) {
            input[i] = output[i];
        }
    }
    public static void radixSort(int[] input) {
        int n;
        int max = 0;
        for(int i=0;i<input.length;i++) {
            max = max>input[i]?max:input[i];
        }
        int i =1;
        while(max!=0) {
            countingSort(input,10,i);
            i=i*10;
            max = max/10;
        }
    }
    public static void main(String[] args) {
        int[] input1 = {21,33,52,611,36,43,101,299};
        radixSort(input1);
        System.out.println(Arrays.toString(input1));
        int[] input2 = {221,2144,3114,3377,9648,249,763,4432,533,364,6433};
        radixSort(input2);
        System.out.println(Arrays.toString(input2));
    }
}
