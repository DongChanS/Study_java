package Tutorial;
import java.util.Collection;
import java.util.ArrayList;

public class ListTest {
    public static void main(String[] args){
        Collection<String> al = new ArrayList<>();
        al.add("a");
        al.add("b");
        al.add("c");
        al.add("d");

        for (String st : al){
            System.out.print(st+" ");
        }
        System.out.println();
        System.out.println(al.toArray()[3]);
    }
}
