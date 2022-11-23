package Array;

import java.util.Arrays;

public class Array {
    public static int removeDuplicates(int[] nums) {
        int k=0;
        int j=0;
        int length = nums.length;
        if(length == 0 || length == 1) return length;
        while (j<length ) {
            while (nums[k] == nums[j]){
//                System.out.println(nums[k]+ "()" + k + "<->" + nums[j]+ "()" + j);
                j++;
                if(j == length) {
                    j--;
                    System.out.println("Length Full" + j + k);
                    if(k != j) {
                        nums[++k] = nums[j];
                    }else {
                        nums[k] = nums[j];
                        k++;
                    }
                    return k;

                }
            }
           nums[++k] = nums[j];

        }

        return k;
    }
    public static int removeDupli2(int[] nums) {
        int length = nums.length;
        int insertIndex = 1;
        Arrays.sort(nums);

        for(int i=1;i<length;i++) {
            if(nums[i] != nums[i-1]) {
                nums[insertIndex] = nums[i];
                insertIndex++;
            }
        }
        for (int i = insertIndex; i < length; i++) {
            nums[i] = -111;
        }
        return insertIndex;
    }

    public static int removeElement(int[] nums, int val) {
        int length = nums.length;
        int insertIndex = 0;
        for(int i=0;i<length;i++) {
            if(nums[i] != val) {
                nums[insertIndex] = nums[i];
                insertIndex ++;
            }
        }
        return insertIndex;
    }

    public static int maxProfit(int[] prices) {
        int length = prices.length;
        int[] diff = new int[length-1];
        int k=0,profit=0;
        if (length == 0 || length == 1) return 0;
        int allNeg = 0;
        for (int i = 1; i < length; i++) {
            int d = prices[i]- prices[i-1];
            if( d > 0) allNeg++;
            diff[k++] = d;
        }
        if(allNeg == 0) return 0;
        int max = diff[0];
        int maxIndex = 0;
        int maxStart = maxIndex;
        boolean dupli = false;
        while(allNeg > 0) {
            System.out.println(allNeg);
            for (int i = 1; i < length-1; i++) {
                System.out.println(diff[i] + "diff max" + max);
                if(diff[i] > max) {
                    if(dupli) {
                        dupli = false;
                        break;
                    }
                    max = diff[i];
                    maxIndex = maxStart = i;
                }
                else if(diff[i] == max) {
                    maxIndex = i;
                    dupli = true;
                }
            }
            System.out.println("Max " +maxStart + maxIndex + max);
            if(max > 0) {
                if(maxStart != maxIndex) {
                    System.out.println(maxStart + " to " + maxIndex + " all Neg" +allNeg);
                    allNeg -= maxIndex - maxStart + 1;
                    profit += prices[maxIndex+1] - prices[maxStart];
                    System.out.println("Profit " + profit);
                    for (int i = maxStart; i < maxIndex+1; i++) {
                        System.out.println(diff[i] + "index" + i);
                        diff[i] = -1;
                    }

                }else {
                    diff[maxIndex] = -1;
                    profit += max;
                    max = -1;
                    allNeg--;
                }
            }

        }
        return profit;
    }
    public static int maxProfit2(int[] prices) {
        int[] diff = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int max = -1;
            int maxIndex = -1;
            for (int j = i+1; j < prices.length ; j++) {
                if(prices[j] < prices[j-1]) break;
                if(prices[j] - prices[i] > max) {
                    max = prices[j] - prices[i];
                    maxIndex = j;
                }
            }
            System.out.println(max + "<-->" + maxIndex);
        }
        return 0;
    }
    public static int singleNumber (int[] nums) {
        int [] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = -1;
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(i + "-- i");
            if(temp[i] == -1) {
                for (int j = i+1; j < nums.length; j++) {
                    System.out.println(j + "-- j");
                    if(nums[i] == nums[j]) {
                        temp[i] = j;
                        temp[j] = i;
                        break;
                    }
                    if(j == nums.length -1 && temp[i] == -1) {
                        System.out.println(temp[j] + "Temp Check");
                        return nums[i];
                    }
                }
            }

        }
        for (int i = 0; i < nums.length; i++) {
            if(temp[i] == -1) return nums[i];
        }
        return 0;
    }

    public static int singleNumberBitWise (int[] nums) {
        int ans=0;
        for (int i = 0; i < nums.length; i++) {
            ans^= nums[i];
        }
        return ans;
    }


    public static void rotateArray(int[] nums, int k) {
        int l = nums.length;
        if(l == 0 || l==1) return;
        k=k%l;
        swap(nums,0, l-1);
        swap(nums,0,k-1);
        swap(nums,k,l-1);

    }
    public static void swap(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int nums[] = {1,1,2,3,4,4,4,4}; //4,5,1,2,3
        int k = removeDupli2(nums);
        System.out.println(k + "start");
//        for (int x:
//             nums) {
//            System.out.println(x);
//        }


    }
}
