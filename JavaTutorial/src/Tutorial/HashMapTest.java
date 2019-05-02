package Tutorial;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args){
        Map<String, Integer> hm = new HashMap<String, Integer>();
        hm.put("Dongchan",100);
        hm.put("Excellent",90);
        hm.put("Good",80);
        hm.put("Satisfied",70);
        // 키로 가져오기
        System.out.println(hm.get("Good"));
        // iterator를 통해서 가져오기
        Iterator<String> i = hm.keySet().iterator();
        // for문을 통해서 가져오기
        for(Integer num:hm.values()){
            System.out.print(num+" ");
        }
        System.out.println();
    }
}
