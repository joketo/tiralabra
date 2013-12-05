package kekoilua;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Kekoilua {

    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String CLOSE = "\u001B[m";

    public static void main(String[] args) {
        //TODO, binäärikekokin minimikeoksi, on nyt maksimi
        Keko keko;
        System.out.println("Testataan kolmea kekoa:");
        System.out.println(ANSI_RED + "BINÄÄRIKEKO");
        System.out.println(ANSI_GREEN + "BINOMIKEKO");
        System.out.println(ANSI_BLUE + "FIBONACCIKEKO");
        System.out.println(CLOSE);
        
        System.out.println(ANSI_RED + "Binäärikeon testausta:"+ CLOSE);
        keko = new Binaarikeko();
        testaaJarjestamista(10, keko);
        
        System.out.println(ANSI_GREEN + "Binomikeon testausta:"+ CLOSE);
        keko = new Binomikeko();
        testaaJarjestamista(10, keko);
        
        System.out.println(ANSI_BLUE + "Fibonaccikeon testausta:"+ CLOSE);
        keko = new Binomikeko();
        testaaJarjestamista(10, keko);
        
        testaa(1000, 1);
        testaa(10000, 2);
        testaa(100000, 3);
        testaa(1000000, 4);
        testaa(3000000, 5);
        System.out.println("\ntestit loppuvat tähän\n");
    }
    public static void testaaJarjestamista(long n, Keko keko){
        ArrayList<Integer> testiArray = new ArrayList<>();
        Random rand = new Random();
        System.out.println("Laitetaan kekoon ja Arraylistiin satunnaiset "+ n +" alkiota");
        for(int i = 0; i < n; i++){
            int randomNum = rand.nextInt();
            keko.Insert(randomNum);
            testiArray.add(randomNum);
        }
        System.out.println("Sortataan Arraylist ja katsotaan palauttaako Keon Delete alkiot oikeassa järjestyksessä");
        Collections.sort(testiArray);
//        System.out.println(testiArray.get(0));
//        System.out.println(keko.Delete());
        boolean onkoTotta = true;
        for(int i = 0; i < testiArray.size(); i++){
            if(keko.Delete() != testiArray.get(i)){
                onkoTotta = false;
            }
        }
        if(onkoTotta){
            System.out.println(ANSI_GREEN + "Poppaus ja ns. järjestäminen keolla toimii"+ CLOSE);
        }else{
            System.out.println(ANSI_RED + "Jokin meni pieleen..."+ CLOSE);
        }
        System.out.println("");
    }

    public static void testaa(long n, int monesko) {
        System.out.println("\n\n"+ ANSI_PURPLE+ monesko + ". osio\n" + n + " alkiota" + CLOSE);
        long startTime;
        Binomikeko binomikeko = new Binomikeko();
        Binaarikeko binaarikeko = new Binaarikeko();
        Fibonaccikeko fibonaccikeko = new Fibonaccikeko();
        System.out.println("\nINSERT:\nlisätään kekoihin " + n + " alkiota: ");
        startTime = System.currentTimeMillis();
        for (int i = 1; i <= n; i++) {
            binaarikeko.Insert(i);
        }
        long timenow = System.currentTimeMillis();
        System.out.println(ANSI_RED + "aikaa meni " + (timenow - startTime) + " millisekuntia" + CLOSE);

        startTime = System.currentTimeMillis();
        for (int i = 1; i <= n; i++) {
            binomikeko.Insert(i);
        }
        timenow = System.currentTimeMillis();
        System.out.println(ANSI_GREEN + "aikaa meni " + (timenow - startTime) + " millisekuntia"+ CLOSE);

        startTime = System.currentTimeMillis();
        for (int i = 1; i <= n; i++) {
            fibonaccikeko.Insert(i);
        }
        timenow = System.currentTimeMillis();
        System.out.println(ANSI_BLUE + "aikaa meni " + (timenow - startTime) + " millisekuntia"+ CLOSE);

        //getylin
        System.out.println("");
        startTime = System.currentTimeMillis();
        System.out.println("GETMIN:\notetaan keon ylin\nbinäärikeko: " + binaarikeko.getYlin());
        timenow = System.currentTimeMillis();
        System.out.println(ANSI_RED + "aikaa meni " + (timenow - startTime) + " millisekuntia"+ CLOSE);

        startTime = System.currentTimeMillis();
        System.out.println("binomikeko: " + binomikeko.getYlin());
        timenow = System.currentTimeMillis();
        System.out.println(ANSI_GREEN + "aikaa meni " + (timenow - startTime) + " millisekuntia"+ CLOSE);

        startTime = System.currentTimeMillis();
        System.out.println("fibonaccikeko: " + fibonaccikeko.getYlin());
        timenow = System.currentTimeMillis();
        System.out.println(ANSI_BLUE + "aikaa meni " + (timenow - startTime) + " millisekuntia"+ CLOSE);

        //delete
        System.out.println("\nDELETE");
        startTime = System.currentTimeMillis();
        System.out.println("poistetaan keoista ylin alkio");
        binaarikeko.Delete();
        timenow = System.currentTimeMillis();
        System.out.println("Binäärikeko: ");
        System.out.println(ANSI_RED + (timenow - startTime) + " millisekuntia"+ CLOSE);

        startTime = System.currentTimeMillis();
        binomikeko.Delete();
        timenow = System.currentTimeMillis();
        System.out.println("Binomikeko:");
        System.out.println(ANSI_GREEN + (timenow - startTime) + " millisekuntia"+ CLOSE);

        System.out.println("Koska fibonaccikeon poiston kesto vaihtelee, poistetaan näytöksi useampi alkio:");
        startTime = System.currentTimeMillis();
        fibonaccikeko.Delete();
        timenow = System.currentTimeMillis();
        System.out.println("Fibonaccikeko 1.poisto:");
        System.out.println(ANSI_BLUE + (timenow - startTime) + " millisekuntia"+ CLOSE);
        
        startTime = System.currentTimeMillis();
        fibonaccikeko.Delete();
        timenow = System.currentTimeMillis();
        System.out.println("Fibonaccikeko 2.poisto:");
        System.out.println(ANSI_BLUE + (timenow - startTime) + " millisekuntia"+ CLOSE);
        
        startTime = System.currentTimeMillis();
        fibonaccikeko.Delete();
        timenow = System.currentTimeMillis();
        System.out.println("Fibonaccikeko 3.poisto:");
        System.out.println(ANSI_BLUE + (timenow - startTime) + " millisekuntia"+ CLOSE);
        
        startTime = System.currentTimeMillis();
        fibonaccikeko.Delete();
        timenow = System.currentTimeMillis();
        System.out.println("Fibonaccikeko 4.poisto:");
        System.out.println(ANSI_BLUE + (timenow - startTime) + " millisekuntia"+ CLOSE);   
    }
}
