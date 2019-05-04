package Tutorial;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest{
    public static void main(String[] args) throws UnknownHostException {
        InetAddress naver = InetAddress.getByName("naver.com");
        System.out.println(naver.getHostAddress());
        System.out.println(naver.getHostName());

        InetAddress local = InetAddress.getByAddress(new byte[] {(byte)192, (byte)168, 1, (byte)100 });
        System.out.println(local.getHostAddress());
        System.out.println(local.getHostName());
    }

}
