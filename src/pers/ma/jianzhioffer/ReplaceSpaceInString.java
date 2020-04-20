package pers.ma.jianzhioffer;

/**
 * 面试题5
 *
 * 问题：替换在字符串中的空格
 *
 * 例子：
 * Hello world将其中的空格替换为指定字符串%20（这里的算法可以应用在一些url请求中将所有不可见字符全部转称ascii码的操作，这里简化了整个操作就替换空格）
 *
 *
 *  解决方案：
 *  这里不使用java库自带的替换函数进行处理，但是会利用到将String转换称char数组的操作
 *  和char数组转回String的操作（这里也完全可以手工模拟但是没有必要），这里我们首先考虑
 *  将String转称char数组然后每次碰到空格然后就插入相应的字符串然后将后面的内容进行后移，
 *  但是考虑到这样的话整体移动的开销其实并不小其时间复杂度要O(n^2)。上述的方法并不是一个
 *  高效的方法，主要问题出在了大量移动工作，为了避免大量移动，我们可以一次性扫描整个字符串
 *  统计空格数，然后直接就可以计算出替换后的数组大小，那么我们就可以直接进行复制碰到空格就
 *  将其转换称%20复制进去，这样整体的时间复杂度就是O(n)，比上述的复杂度降低了一个量级。
 *
 *  时间复杂度：
 *  时间复杂度O(n) 空间复杂度O(n)
 *
 * @author mabc
 * @date 2020/4/20
 */
public class ReplaceSpaceInString {
    public static String replaceSapce(String str){

        String result = null;
        char[] originalCharArray = str.toCharArray();
        //统计空格
        int count = 0;
        for (int i = 0; i < originalCharArray.length; i++) {
            if(originalCharArray[i] == ' ') {
                count++;
            }
        }
        //开辟新的数组进行复制操作
        char[] newCharArray = new char[str.length() + count * 2];

        for (int i = 0,j = 0; i < originalCharArray.length; i++, j++) {
            if (originalCharArray[i] == ' ') {
                //碰到如果是空格的话那么我们就需要进行替换操作
                newCharArray[j++] = '%';
                newCharArray[j++] = '2';
                newCharArray[j] = '0';
            } else {
                newCharArray[j] = originalCharArray[i];
            }
        }
        //将数组转回字符串
        result = new String(newCharArray);
        return result;
    }
    public static void main(String[] args)
    {
        String str = "hello world ";
        System.out.println(replaceSapce(str));
    }
}
