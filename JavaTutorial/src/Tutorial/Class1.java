package Tutorial;

public class Class1 {

    public static class Member {
        int id;
        public Member(int id) {
            this.id = id;
        }
        public void getinfo(int id){
            System.out.println("Member id :" + id);
        }
        public void getinfo(){
            System.out.println("Member id :" + id);
        }
    }
    public static void main(String[] args){
        Member m = new Member(1);
        m.getinfo(2);
        m.getinfo();
    }
}
