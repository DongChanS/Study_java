package Algorithm;
import java.io.*;
import java.util.StringTokenizer;

public class 백준15552 {
    static int T, t1, t2;
    static String str;

    public static void main(String[] args) throws IOException {
        // input 을 받기 위한 장치
        String path = "baekjoon" + File.separator + "15552_input.txt";
        File f = new File(path);
        FileInputStream fis = new FileInputStream(f);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        // input 받기
        T = Integer.parseInt(br.readLine());

        // nums 를 빠르게 출력하기 위한 장치
        OutputStream os = System.out;
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);

        for (int i=0; i<T; i++){
            str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            t1 = Integer.parseInt(st.nextToken());
            t2 = Integer.parseInt(st.nextToken());
            str = (t1 + t2) + "\n";
            bw.write(str);
        }
        bw.flush();
    }
}
