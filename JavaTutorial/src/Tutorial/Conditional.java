package Tutorial;

public class Conditional {
    public static void main(String[] args){
        label:
        for (int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                for(int k=0; k<5; k++){
                    System.out.println(i + "," + j + "," + k);
                    if (k==3) break label;
                }
            }
        }
        int[] su = new int[7];
        System.out.println(su.length);
    }
}
