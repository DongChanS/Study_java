package Tutorial;

public class RTCtest {
    public static void main(String[] args){
        MainMember mm = new MainMember(15, 1000);
        Member m = (Member) mm;
        mm = (MainMember) m;
        System.out.println(mm.fee);
    }
}
