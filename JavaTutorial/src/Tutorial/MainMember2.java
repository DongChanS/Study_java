package Tutorial;


public class MainMember2 extends  Member {
    int fee;
    Member m = new Member(15);
    public MainMember2(int id, int fee){
        super(id);
        System.out.println(super.id);
        super.login();
        this.fee = fee;
    }
    public static void main(String[] args){
        MainMember dongchan = new MainMember(1, 500);
    }
}
