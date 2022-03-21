import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CoinChange {
    /**
     * Many variations of coin change with repetition allowed in all cases.
     * 1) Count of all combinations of getting a sum
     * 2) Count of all permutations of getting a sum
     * 3) Min no. of values to make a sum
     * 4) Return all solutions where sum is K with distinct values
     * 5) Return all distinct solutions where sum is K with non-distinct values
     */
    public static int countCombination(int[] nums, int sum) {
        int[]dp = new int[sum+1];
        dp[0] = 1;
        // Works because values dont repeat. Otherwise recounting was possible.
        for(int i = 0;i<nums.length;i++) {
            for(int j = 1;j<=sum;j++) {
                if (j - nums[i] >= 0) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }
        return dp[sum];
    }

    public static int countPermutation(int[] nums, int sum) {
        int[] dp = new int[sum+1];
        dp[0] = 1;
        for(int i = 1;i<=sum;i++) {
            for(int j = 0;j<nums.length;j++) {
                // permutation because 5-2, 5-3 both will be counted. which means {2,3}, {3,2} both will add to the final count.
                if(i-nums[j]>=0) {
                    dp[i] += dp[i-nums[j]];
                }
            }
        }
        return dp[sum];
    }
    public static int minCount(int[] nums, int sum) {
        int dp[] = new int[sum+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int j=0;j<nums.length;j++) {
            for(int i=1;i<=sum;i++) {
                if(i-nums[j]>=0 && dp[i-nums[j]]!=Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i],dp[i-nums[j]]+1);
                }
            }
        }
        return dp[sum];
    }
    public static void helperDistinctVal(int idx, int[] candidates, int target, List<List<Integer>> result, List<Integer> cur) {
        if(target == 0) {
            result.add(new LinkedList<>(cur));
            return;
        }
        if(idx == candidates.length || target<=0) {
            return;
        }
        for(int i = idx;i<candidates.length;i++) {
            cur.add(candidates[i]);
            helperDistinctVal(i,candidates,target-candidates[i],result,cur);
            cur.remove(cur.size()-1);
        }

    }
    public static List<List<Integer>> solutionDistinctVal(int[] nums, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> cur = new LinkedList<>();
        helperDistinctVal(0,nums,sum,result,cur);
        return result;
    }
    public static void helperNonDistinctVal(int idx, int[] candidates, int target, List<List<Integer>> result, List<Integer> cur) {
        if(target == 0) {
            result.add(new LinkedList<>(cur));
            return;
        }
        if(idx == candidates.length || target<=0) {
            return;
        }
        for(int i = idx;i<candidates.length;i++) {
            if(i == idx || candidates[i] !=candidates[i-1]) {
                cur.add(candidates[i]);
                helperNonDistinctVal(i+1,candidates,target-candidates[i],result,cur);
                cur.remove(cur.size()-1);
            }
        }
    }
    public static List<List<Integer>> solutionNonDistinctVal(int[] nums, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> cur = new LinkedList<>();
        Arrays.sort(nums);
        helperNonDistinctVal(0,nums,sum,result,cur);
        return result;
    }
    public static void main(String args[]) {
        // Problem 1: Count of all combinations of getting a sum
        int[] arr1 = {1,2,3};
        int sum1 = 4;
        System.out.println(countCombination(arr1,sum1));
        System.out.println("##################################");

        // Problem 2: Count of all permutations of getting a sum
        int[] arr2 = {1,2,3};
        int sum2 = 4;
        System.out.println(countPermutation(arr2,sum2));
        System.out.println("##################################");

        // Problem 3: Min no. of values to make a sum
        int[] arr3 = {9, 6, 5, 1};
        int sum3 = 11;
        System.out.println(minCount(arr3,sum3));
        System.out.println("##################################");

        // Problem 4: Return all solutions where sum is K with distinct values
        int[] arr4 = {2,3,6,7};
        int sum4 = 7;
        solutionDistinctVal(arr4,sum4).stream().forEach(e->System.out.print(e+" "));
        System.out.println("\n##################################");

        // Problem 5: Return all distinct solutions where sum is K with non-distinct values
        int[] arr5 = {10,1,2,7,6,1,5};
        int sum5 = 8;
        solutionNonDistinctVal(arr5,sum5).stream().forEach(e->System.out.print(e+" "));
    }
}
