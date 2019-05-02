package Tutorial;

public class Member {
    int id;
    public Member(int id){
        this.id = id;
    }
    public void login(){
        System.out.println("회원 암호화 코드:" + this.hashCode());
    }
}
