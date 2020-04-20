package pers.ma.leetcode;

import java.util.*;

/**
 * 统计整型数组中的重复元素数据并以List集合方式返回重复元素
 * 时间复杂度O（n），空间复杂度O（1）
 *
 * @author mabc
 * @date 2020/4/20
 */
public class ArrayDuplicateElement {
    public static List<Integer> findDuplicates(int[] nums) {
        //创建返回的重复元素数组
        List<Integer> result =  new ArrayList<Integer>();

        //该题题解思路来自剑指OFFER，假设该数组中所有元素如果都不重复的话排序完，每个元素应该就在数组对应的下标位置上，
        //我们从前往后扫描，进行比较交换将其交换到数组对应的位置上，这样做的们可以边排序边进行比较。整体的时间复杂度在O（N）空间复杂度为O（1）
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == i) {
                //case1：判断当前数组中的数据是否和下标相同，如果相同直接往下扫
                System.out.println("the element is match the nums[" + i + "] is " + nums[i] + " and the i is " + i);
                continue;

            } else if (nums[nums[i]] == nums[i]) {
                //case2：判断当前指向的数据是否已经在数组中对应的位置，如果是那么这就是一个重复元素
                System.out.println("find dup element the nums[" + i + "] is " +  nums[i] + " the nums[" + nums[i] + "] is " + nums[nums[i]]);
                result.add(nums[i]);

            } else {
                //case3：该情况是当前数组的元素和这个元素相同的数组下标所对应的元素不相同的情况下，我们要将其进行交换，将当前数据放置到它应该在的位置
                System.out.println("switch the element because of the nums[" + i + "] is " +  nums[i] + " the nums[" + nums[i] + "] is " + nums[nums[i]]);
                int index = nums[i];
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
            }
        }

        return result;
}

     public static void main(String[] args)
     {
         //测试数据
         int[] nums = {0,1,2,2,3,3,4,5};
         List<Integer> duplicateElement;
         duplicateElement = findDuplicates(nums);
         System.out.println(duplicateElement);
     }
}
