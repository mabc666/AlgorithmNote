package pers.ma.jianzhioffer;

import java.util.*;

/**
 * 面试题3
 *
 * 问题：统计整型数组中的重复元素数据并以List集合方式返回重复元素，该数组大小为n其中的整数只能在[0,n)之间。
 *
 * 例子：
 * 在下面的数组中查找重复元素
 * [0,1,2,3,3,4,4,5,6,7]
 *
 * 解决方案：
 * 假设该数组中所有元素如果都不重复的话将其进行排序排序结果应该是所有的数组中的数据都与下标对应，
 * 我们从前往后扫描，对数组中的数字进行比较，如果与该数组下标对应我们就什么都不做，
 * 如果碰到其中的数字在其对应的位置上已经有过了，那么说明这是一个重复的数字，那我们将其记录下来。
 * 最后如果我们发现当前数组中的数字与下标不同，并且与对应的位置上的数字也不同的话那我们就要交换他们。
 *
 * 复杂度：
 * 时间复杂度O(n)，空间复杂度O(1)
 *
 * @author mabc
 * @date 2020/4/20
 */
public class DuplicationInArray {
    public static List<Integer> findDuplicates(int[] nums) {
        //创建返回的重复元素数组
        List<Integer> result =  new ArrayList<Integer>();

        //对数组进行从前往后的扫描
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == i) {
                // case1：判断当前数组中的数据是否和下标相同，如果相同直接往下扫
                System.out.println("the element is match the nums[" + i + "] is " + nums[i] + " and the i is " + i);
                continue;

            } else if (nums[nums[i]] == nums[i]) {
                // case2：判断当前指向的数据是否已经在数组中对应的位置，如果是那么这就是一个重复元素
                System.out.println("find dup element the nums[" + i + "] is " +  nums[i] + " the nums[" + nums[i] + "] is " + nums[nums[i]]);
                result.add(nums[i]);

            } else {
                // case3：该情况是当前数组的元素和这个元素相同的数组下标所对应的元素不相同的情况下，我们要将其进行交换，将当前数据放置到它应该在的位置
                System.out.println("switch the element because of the nums[" + i + "] is " +  nums[i] + " the nums[" + nums[i] + "] is " + nums[nums[i]]);
                // 这里有一个坑，我们需要记录下nums[i]中的index，
                // 因为这个nums[i]在交换的时候会被修改，所以会导致我们交换出错。
                // 下面被注释掉的是一段会出错的代码可以仔细思考一下为什么
                // int temp = nums[i];
                // nums[i] = nums[nums[i]];
                // nums[nums[i]] = temp;
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
