package Tutorial;

public class Operator1 {
    public static void main(String[] args){
        int[] arr = new int[5];
        int var = 5;
        System.out.println(++var); // 6
        System.out.println(var++); // 6

        var = 5; // 101
        System.out.println(~var); // -6

        for (int i=0; i<100; i++){
            System.out.print(~i+" ");
        }
        System.out.println();

        String a = "abc";
        String b = "abc";
        System.out.println("a와 b가 동일한가요?");
        System.out.println(a == b);
    }
}
