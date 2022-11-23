package Array;

import java.util.*;

public class Array2 {

    public static boolean containDupli (int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if(nums[i-1] == nums[i]) {
                return true;
            }
        }
        return false;
    }
    public static boolean containDupli2 (int[] nums) {
        Set<int[]> targetSet = new HashSet<int[]>(Collections.singleton(nums));
        System.out.println(targetSet.size());
        for (int i = 1; i < nums.length; i++) {
            if(nums[i-1] == nums[i]) {
                return true;
            }
        }
        return false;
    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> copy = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0;
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] < nums2[j]) {
                i++;
            }
            else if(nums1[j] > nums2[j]) {
                j++;
            }
            else {
                copy.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] arr = copy.stream().mapToInt(k -> k).toArray();
        return arr;
    }

    public static void main(String[] args) {
        int nums1[] = {1,2,2,1};
        int nums2[] = {2,2};
        int[] copy = intersection(nums1, nums2);
        for (int x :
                copy) {
            System.out.println(x);
        }
    }
}
