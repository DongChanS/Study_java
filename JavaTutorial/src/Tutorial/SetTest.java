package Tutorial;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Collection;

public class SetTest {
    public static void main(String[] args){
        Collection<Integer> list = new HashSet();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);

        // 방법1.
        Iterator<Integer> i = list.iterator();
        while(i.hasNext()){
            System.out.print(i.next()+" ");
        }
        System.out.println();

        // 방법2
        for(int num: list){
            System.out.print(num+" ");
        }
    }
}
