public class BSearch {
    public static void main(String[] args) {
        int[] input = {1,2,3,4,5,6,6,8};
        // find the number just greater than 6 in  a sorted array.
        int n = 0;
        int low =0;
        int high = input.length-1;
        int result = -1;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(input[mid] > n) {
                result = input[mid];
                high = mid-1;
            } else {
                low = mid +1;
            }
        }
        System.out.println(result);
    }
}
