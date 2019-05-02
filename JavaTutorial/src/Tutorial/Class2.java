package Tutorial;
import java.lang.reflect.Array;

public class Class2 {
    static int count = 0;
    int var = 1;
    public Class2(){
        count += 1;
    }

    public static void main(String[] args){
        System.out.println(Class2.count);
        Class2 test1 = new Class2();
        Class2 test2 = new Class2();
        System.out.println(Class2.count);
        int[] su = new int[5];

    }
}
