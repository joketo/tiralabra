package kekoilua;

public class Kekoilua {
   
    public static void main(String[] args) {
       Binomikeko binomikeko = new Binomikeko();
       Binaarikeko binaarikeko = new Binaarikeko();
       Fibonaccikeko fibonaccikeko = new Fibonaccikeko();
       
        System.out.println("binäärikekoon 100 alkiota:");
        for(int i = 0; i < 100; i++){
            binaarikeko.Insert(i);
        }
        System.out.println("binomikekoon 100 alkiota:");
        for(int i = 0; i < 100; i++){
            binomikeko.Insert(i);
        }
        System.out.println("fibonaccikekoon 100 alkiota:");
        for(int i = 0; i < 100; i++){
            fibonaccikeko.Insert(i);
        }
        
    }
}
