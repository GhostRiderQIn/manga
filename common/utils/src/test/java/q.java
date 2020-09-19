import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @program: manga
 * @description:
 * @author: qinda
 * @create: 2020-08-30 22:47
 **/
public class q {
    public static void main(String[] args) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('c',6);
        map.put('d',66);
        map.put('a',60);
        map.put('b',10);

        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((o1, o2)->{
            return o2.getValue()-o1.getValue();
        });
        queue.addAll(map.entrySet());
        for(int i=0;i<3;i++){
            System.out.println(queue.poll());
        }
    }
}
