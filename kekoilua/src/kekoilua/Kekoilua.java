package kekoilua;

public class Kekoilua {

    public static void main(String[] args) {

        //TODO, binäärikekokin minimikeoksi, on nyt maksimi
        Binomikeko binomikeko = new Binomikeko();
        Binaarikeko binaarikeko = new Binaarikeko();
        Fibonaccikeko fibonaccikeko = new Fibonaccikeko();

        System.out.println("INSERT:\nbinäärikekoon 100 alkiota");
        for (int i = 1; i <= 100; i++) {
            binaarikeko.Insert(i);
        }

        System.out.println("binomikekoon 100 alkiota");
        for (int i = 1; i <= 100; i++) {
            binomikeko.Insert(i);
        }
        System.out.println("fibonaccikekoon 100 alkiota");
        for (int i = 1; i <= 100; i++) {
            fibonaccikeko.Insert(i);
        }
        System.out.println("binäärikeon keon ylin");
        System.out.println(binaarikeko.getYlin());
        System.out.println("binomikeon ylin");
        System.out.println(binomikeko.getYlin());
        System.out.println("fibonaccikeon ylin");
        System.out.println(fibonaccikeko.getYlin());

        System.out.println("");
        System.out.println("GETMIN:\nbinäärikeosta otetaan keon ylin");
        System.out.println(binaarikeko.getYlin());
        System.out.println("binomikeosta otetaan keon ylin");
        System.out.println(binomikeko.getYlin());
        System.out.println("fibonaccikeosta otetaan keon ylin");
        System.out.println(fibonaccikeko.getYlin());

        System.out.println("\nDELETE");
        System.out.println("binäärikeosta poistetaan ylin alkio");
        binaarikeko.Delete();
        System.out.println("ylin nyt:\n" + binaarikeko.getYlin());
        System.out.println("binomikeosta poistetaan ylin alkio");
        binomikeko.Delete();
        System.out.println("ylin nyt:\n" + binomikeko.getYlin());
        System.out.println("fibonaccikeosta poistetaan ylin alkio");
        fibonaccikeko.Delete();
        System.out.println("ylin nyt:\n" + fibonaccikeko.getYlin());
    }
}
