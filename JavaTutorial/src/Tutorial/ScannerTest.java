package Tutorial;
import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for (int i=0; i<5; i++){
            System.out.println(sc.nextInt());
        }
    }
}
