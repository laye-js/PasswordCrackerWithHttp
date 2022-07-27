import java.util.Scanner;
public class Test {
    public static void main(String args[]) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
          System.out.println("choose 1 for brute force and 2 for dictionaryAttack");
          int val=sc.nextInt();

          if(val==1){
          
            Attack attack1=new ForceBrute();
            ((ForceBrute) attack1).mdpCracker();
          }else{
        Attack attack2 = new Dictionnaire();
        ((Dictionnaire) attack2).mdpCrack();
          }
        }
    }
}