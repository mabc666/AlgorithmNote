package pers.ma.jianzhioffer;

/**
 * 面试题4
 *
 * 问题：在二维有序数组中查找指定的元素，该数组从左到右升序，从上到下升序
 *
 * 例子：
 * 在下面的数组中查找元素5是否存在
 *  1 2 3 4
 *  5 6 7 8
 *  9 10 11 12
 *
 *  解决方案：
 *  首先这个问题的解法有很多，这里讲一个比较简单的，我们从第一行最后一列开始往前追溯我们要查找的数字
 * （想想为什么这里要从这个位置开始而不是1行1列，见tips），首先判断当前数组位置中的内容是否跟我们的要寻找的数字相同，
 *  如果当前的数字比目标数字大的话我们就向左走一步，否则的话就向下走一步。
 *  tips：这里不用1行1列作为起始点的话是因为其右边和下边都是比1大的我们无法确定单一的方向
 *
 *
 *  时间复杂度：
 *  时间复杂度O(n) 空间复杂度O(1)
 *
 * @author mabc
 * @date 2020/4/20
 */
public class FindInPartiallySortedMatrix {
    public static boolean findElement(int[][] orderedArray, int target){
        //保存行列数
        int row = orderedArray.length;
        int col = orderedArray[0].length;
        //存放最终结果，用一个result来保存结果主要是为了保持函数单一出口
        boolean result = false;

        //i,j分别是数组的当前的行和列
        int i,j;

        //开始查找
        for (i = 0, j = col - 1; i < row  && j >= 0; ){

            if (orderedArray[i][j] == target) {
                //case1: 假设当前位置中的数据就是我们的目标值直接返回
                System.out.println("找到目标值,目标值在[" + i + "," + j + "]");
                result = true;
                break;
            }else if (orderedArray[i][j] < target) {
                //case2: 假设当前位置中的数据比我们的目标数值要小的话，我们向下走一步
                System.out.println("当前的位置是：[" + i + "," + j + "]，即将向下走一步！");
                i++;
            }else {
                //case3：假设当前位置中的数据比我们的目标数值要大的话，我们向左走一步
                System.out.println("当前的位置是：[" + i + "," + j + "]，即将向左走一步！");
                j--;
            }
        }
        return result;
    }
    public static void main(String[] args)
    {
        int[][] orderedArray = { {1,2,3,4},
                                 {5,6,7,8},
                                 {9,10,11,12} };

        System.out.println(findElement(orderedArray,5));
    }
}
