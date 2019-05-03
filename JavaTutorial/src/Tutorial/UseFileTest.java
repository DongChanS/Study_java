package Tutorial;
import java.io.File;
import java.util.Date;

public class UseFileTest {
    public static void main(String[] args){
        File currentDir = new File(".");
        System.out.println(currentDir.getName());
        if (currentDir.exists()){
            File[] childs = currentDir.listFiles();
            for (File child : childs){
                Date time = new Date(child.lastModified());
                String name = child.getName();
                long length = child.length();
                System.out.printf(
                        name,time,length
                );
                System.out.println();
                // 아하 JavaTutorial 에서 출력되는구나!!
            }
        }
    }
}
