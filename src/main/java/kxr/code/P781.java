package kxr.code;
import java.util.HashMap;
import java.util.Map;
/**
 * @Author: kxr
 * @Date: 2021/4/4
 * @Description
 *
 * 森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在 answers 数组里。
 *
 * 返回森林中兔子的最少数量。
 *
 * 示例:
 * 输入: answers = [1, 1, 2]
 * 输出: 5
 * 解释:
 * 两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
 * 之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
 * 设回答了 "2" 的兔子为蓝色。
 * 此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
 * 因此森林中兔子的最少数量是 5: 3 只回答的和 2 只没有回答的。
 *
 * 输入: answers = [10, 10, 10]
 * 输出: 11
 *
 * 输入: answers = []
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rabbits-in-forest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P781 {
    public int numRabbits(int[] answers) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int answer : answers){
            map.put(answer,map.getOrDefault(answer,0)+1);
        }
        int minNumber = 0 ;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int x= entry.getKey();
            int y= entry.getValue();
            //这里的 x，y表示  有y个兔子说自己的同类个数为 x
            //如果 x = y 则，有该颜色的兔子 x+1个
            //如果 x < y 则，有共有 y/x+1 种颜色的兔子各x+1
            //如果 x > y 则，有该颜色的兔子 x+1 个

            if(y == 0){
                continue;
            }
            if(x == y){
                minNumber+=x+1;
            }else if(x<y){
                minNumber+=(x+y)/(x+1)*(x+1);
            }else{
                minNumber+=x+1;
            }

        }
        return minNumber;
    }
}
