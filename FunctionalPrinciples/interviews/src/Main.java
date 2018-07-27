import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 2;i<=1000;i = i+3){
            if (sum + i > 1000){
                break;
            }
            sum += i;
        }
        System.out.println(sum);
    }

    public int[] mergeSort(int[] nums){
        int mid = nums.length/2;
        if (mid==0){
            return nums;
        }
        else{
            low,high = split(nums,mid);
            return merge(mergeSort(low),mergeSort(high));
        }

    }

    public int[] merge(int[] nums1, int[] nums2, int[] acc){
        if (nums1.length==0){
            return nums2;
        }

        else if (nums2.length==0){
            return nums1;
        }

        else {
            if (nums1[0]<nums2[0]){
                return merge(nums1.[1:],nums2,acc);
            }
            else{
                return merge(nums1.[1:],nums2,acc);
            }
        }
    }

    public ArrayList<int[]> split(int[] nums,int index){
        ArrayList<int[]> res;
        res.add(nums[0:index])
    }


}
