import java.util.Arrays;

public class CountingSort {
    public static void countingSort(int[] input, int range) {
        int[] count = new int[range+1];
        Arrays.stream(input).forEach(e->count[e]++);
        for(int i=1;i<count.length;i++) {
            count[i] = count[i-1]+count[i];
        }
        Arrays.fill(input,0);
        for(int i=1;i<count.length;i++) {
            if(count[i]!=count[i-1]) {
                for(int j=count[i-1];j<count[i];j++) {
                    input[j] = i;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] input1 = {2,4,1,7,8,9,3,4};
        // counting sort work in O(n). Its possible because we have the additional information about the expected range of values.
        countingSort(input1, 9);
        System.out.println(Arrays.toString(input1));
        int[] input2 = {2,4,1,7,8,9,3,4,3,3,3};
        // counting sort work in O(n). Its possible because we have the additional information about the expected range of values.
        countingSort(input2, 9);
        System.out.println(Arrays.toString(input2));
    }
}
