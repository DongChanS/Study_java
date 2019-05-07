package Tutorial;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerTest {
    public static void main(String[] args){
        try (ServerSocket ss = new ServerSocket(6547)){
            System.out.println("Server is ready!");

            while (true) {
                try (Socket socket = ss.accept()){
                    System.out.printf("client 접속 : %s%n", socket.getInetAddress());
                    InputStreamReader isr = new InputStreamReader(socket.getInputStream(),"UTF-8");
                    BufferedReader br = new BufferedReader(isr);
                    OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream(),"UTF-8");
                    BufferedWriter bw = new BufferedWriter(osw);

                    bw.write(socket.getInetAddress().getHostName() + "님 성함은?");
                    bw.newLine();
                    bw.flush();
                    String line = br.readLine();
                    System.out.println(line);
                    bw.write(line + "님 반갑습니다");
                    bw.flush();
                } catch (IOException e){
                    System.out.println("통신 오류");
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
