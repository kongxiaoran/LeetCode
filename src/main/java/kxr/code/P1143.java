package kxr.code;

/**
 * @Author: kxr
 * @Date: 2021/4/3
 * @Description
 *
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 示例 1：
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 *
 */

public class P1143 {

    public static  int longestCommonSubsequence(String text1, String text2) {
       char[] text1x = text1.toCharArray();
       char[] text2x = text2.toCharArray();
       int[][] result = new int[text1x.length+1][text2x.length+1];

       for(int i=1;i<=text1x.length;i++){
           for(int j=1;j<=text2x.length;j++){
               if(text1x[i-1] == text2x[j-1]){
                   result[i][j] = result[i-1][j-1]+1;
               }else{
                   result[i][j] = Math.max(result[i-1][j],result[i][j-1]);
               }
           }
       }
       return result[text1x.length][text2x.length];
    }

    public static void main(String[] args) {
        System.out.println(P1143.longestCommonSubsequence("abcde","ace"));;
    }

}
