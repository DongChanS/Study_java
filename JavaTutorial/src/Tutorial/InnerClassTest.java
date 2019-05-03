package Tutorial;

public class InnerClassTest {
    private int id;
    public InnerClassTest(int id){
        this.id = id;
    }

    public static class StaticNestedClass {
        int id;
        public StaticNestedClass(int id){
            this.id = id;
        }
    }

    public class InnerClass {
        int id;
        public InnerClass(int id){
            this.id = id;
        }
        public void print(){
            System.out.println(id);
            System.out.println(InnerClassTest.this.id);
            System.out.println(this.id);
        }
    }

    public static void main(String[] args){
        InnerClassTest ict = new InnerClassTest(50);
        InnerClass ic = ict.new InnerClass(40);
        InnerClassTest.InnerClass ic2 = ict.new InnerClass(41);
        // 두가지방법으로 선언이 가능한데 그냥 InnerClass로 하는게 더 직관적일듯?
        StaticNestedClass snc = new InnerClassTest.StaticNestedClass(30);
        ic.print();
        System.out.println();
        ic2.print();
    }
}
