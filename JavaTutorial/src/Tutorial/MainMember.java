package Tutorial;

public class MainMember extends Member{
    int fee;
    public MainMember(int id, int fee){
        super(id);
        System.out.println(super.id);
        super.login();
        this.fee = fee;
    }
    public static void main(String[] args){
        MainMember dongchan = new MainMember(1, 500);
    }
}
