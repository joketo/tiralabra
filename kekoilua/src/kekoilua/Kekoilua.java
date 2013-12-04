package kekoilua;

public class Kekoilua {

    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    
    
    public static void main(String[] args) {
        //TODO, binäärikekokin minimikeoksi, on nyt maksimi

        System.out.println("Testataan kolmea kekoa:");
        System.out.println(ANSI_RED + "BINÄÄRIKEKO");
        System.out.println(ANSI_GREEN + "BINOMIKEKO");
        System.out.println(ANSI_BLUE + "FIBONACCIKEKO");

        testaa(1000, 1);
        testaa(10000, 2);
        testaa(100000, 3);
        testaa(1000000, 4);
    }

    public static void testaa(long n, int monesko) {
        System.out.println("\n\n" + monesko + ANSI_PURPLE + ". osio\n" + n + " alkiota");
        long startTime;
        Binomikeko binomikeko = new Binomikeko();
        Binaarikeko binaarikeko = new Binaarikeko();
        Fibonaccikeko fibonaccikeko = new Fibonaccikeko();
        System.out.println("\nINSERT:\nlisätään kekoihin "+n+" alkiota: ");
        startTime = System.currentTimeMillis();
        for (int i = 1; i <= n; i++) {
            binaarikeko.Insert(i);
        }
        long timenow = System.currentTimeMillis();
        System.out.println(ANSI_RED + "aikaa meni " + (timenow - startTime) + " millisekuntia");

        startTime = System.currentTimeMillis();
        for (int i = 1; i <= n; i++) {
            binomikeko.Insert(i);
        }
        timenow = System.currentTimeMillis();
        System.out.println(ANSI_GREEN + "aikaa meni " + (timenow - startTime) + " millisekuntia");

        startTime = System.currentTimeMillis();
        for (int i = 1; i <= n; i++) {
            fibonaccikeko.Insert(i);
        }
        timenow = System.currentTimeMillis();
        System.out.println(ANSI_BLUE + "aikaa meni " + (timenow - startTime) + " millisekuntia");

        //getylin
        System.out.println("");
        startTime = System.currentTimeMillis();
        System.out.println("GETMIN:\notetaan keon ylin\nbinäärikeko: " + binaarikeko.getYlin());
        timenow = System.currentTimeMillis();
        System.out.println(ANSI_RED + "aikaa meni " + (timenow - startTime) + " millisekuntia");

        startTime = System.currentTimeMillis();
        System.out.println("binomikeko: " + binomikeko.getYlin());
        timenow = System.currentTimeMillis();
        System.out.println(ANSI_GREEN + "aikaa meni " + (timenow - startTime) + " millisekuntia");

        startTime = System.currentTimeMillis();
        System.out.println("fibonaccikeko: " + fibonaccikeko.getYlin());
        timenow = System.currentTimeMillis();
        System.out.println(ANSI_BLUE + "aikaa meni " + (timenow - startTime) + " millisekuntia");

        //delete
        System.out.println("\nDELETE");
        startTime = System.currentTimeMillis();
        System.out.println("poistetaan keoista ylin alkio");
        binaarikeko.Delete();
        timenow = System.currentTimeMillis();
        System.out.println("Binäärikeko: " + ANSI_RED +  (timenow - startTime) + " millisekuntia");

        startTime = System.currentTimeMillis();
       // System.out.println("binomikeko");
        binomikeko.Delete();
        timenow = System.currentTimeMillis();
        System.out.println( "Binomikeko: " +  ANSI_GREEN +(timenow - startTime) + " millisekuntia");

        startTime = System.currentTimeMillis();
       // System.out.println("fibonaccikeko");
        fibonaccikeko.Delete();
        timenow = System.currentTimeMillis();
        System.out.println( "Fibonaccikeko " + ANSI_BLUE + (timenow - startTime) + " millisekuntia");
    }

}
