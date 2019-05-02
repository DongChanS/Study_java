package Tutorial;

public class MemberMrg {
    Member[] members;
    int top;
    public MemberMrg(int limit){
        this.members = new Member[limit];
        this.top = 0;
    }
    public void addMember(Member m){
        this.members[top++] = m;
    }
    public Member getMember(int id){
        return this.members[id];
    }
    public static void main(String[] args){
        MainMember mm = new MainMember(15, 1000);
        MemberMrg mrg = new MemberMrg(15);
        mrg.addMember(mm);
        System.out.println(mrg.toString());
    }
}
