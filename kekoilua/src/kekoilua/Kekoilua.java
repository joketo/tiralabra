package kekoilua;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Kekoilua {

    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String CLOSE = "\u001B[m"; //estetään värivuodot

    public static void main(String[] args) {
        String syote = args[0];
        int montako;
        if (syote.equals("binomi") || syote.equals("binääri") || syote.equals("fibonacci") || syote.equals("vertailu")) {
            Keko keko;
            System.out.println("\n"+ANSI_YELLOW + "TERVETULOA! ＼（＾▽＾）／" + CLOSE + "\nTestataan kolmea kekoa:");
            System.out.println(ANSI_RED + "BINÄÄRIKEKO");
            System.out.println(ANSI_GREEN + "BINOMIKEKO");
            System.out.println(ANSI_BLUE + "FIBONACCIKEKO");
            System.out.println(CLOSE);

            if (syote.equals("binomi") || syote.equals("binääri") || syote.equals("fibonacci")) {
                montako = Integer.parseInt(args[1]);
                if (syote.equals("binomi")) {
                    System.out.println(ANSI_GREEN + "Binomikeon testausta:" + CLOSE);
                    keko = new Binomikeko();
                    testaaJarjestamista(montako, keko);
                }
                if (syote.equals("binääri")) {
                    System.out.println(ANSI_RED + "Binäärikeon testausta:" + CLOSE);
                    keko = new Binaarikeko();
                    testaaJarjestamista(montako, keko);
                }
                if (syote.equals("fibonacci")) {
                    System.out.println(ANSI_BLUE + "Fibonaccikeon testausta:" + CLOSE);
                    keko = new Fibonaccikeko();
                    testaaJarjestamista(montako, keko);
                }
            } else if (syote.equals("vertailu")) {
                muodostaVertailu();
            }
            System.out.println("testit loppuvat tähän\n");
        }
        else{
            System.out.println("kirjoita keon nimi ja alkioiden lukumäärä, esim. binomi 1000\ntai kirjoita vertailu, jos haluat vertailutaulukon");
        }

    }

    public static void testaaJarjestamista(long n, Keko keko) {
        ArrayList<Integer> testiArray = new ArrayList<>();
        long startTime;
        Random rand = new Random();
        System.out.println("Laitetaan kekoon ja Arraylistiin satunnaiset " + n + " alkiota");
        for (int i = 0; i < n; i++) {
            int randomNum = rand.nextInt();
            testiArray.add(randomNum);
        }
        startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            keko.insert(testiArray.get(i));
        }
        long timenow = System.currentTimeMillis();
        System.out.println("Aikaa " + n + " alkion lisäämiseen kului " + ANSI_RED + (timenow - startTime) + " millisekuntia" + CLOSE);
        System.out.println("Sortataan Arraylist ja katsotaan palauttaako Keon Pop alkiot oikeassa järjestyksessä");
        Collections.sort(testiArray);
        startTime = System.currentTimeMillis();
        int pienin = keko.getYlin();
        timenow = System.currentTimeMillis();
        System.out.println("Keon päällimmäinen on " + ANSI_PURPLE + pienin + CLOSE + " ja sen hakemiseen meni " + ANSI_RED + (timenow - startTime) + " ms" + CLOSE);
        ArrayList<Integer> keonalkiot = new ArrayList<>();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < testiArray.size(); i++) {
            keonalkiot.add(keko.pop());
        }
        timenow = System.currentTimeMillis();
        System.out.println("Aikaa " + n + " alkion poistamiseen keosta kului " + ANSI_RED + (timenow - startTime) + " millisekuntia" + CLOSE);
        if (keonalkiot.equals(testiArray)) {
            System.out.println("Havaittiin että sortattu ArrayList on sama kuin Popeista muodostettu lista eli");
            System.out.println(ANSI_GREEN + "Poppaus ja ns. järjestäminen keolla toimii" + CLOSE);
        } else {
            System.out.println(ANSI_RED + "Jokin meni pieleen..." + CLOSE);
        }
        System.out.println("");
    }

    public static ArrayList<Integer> muodostaRandomArray(int n) {
        ArrayList<Integer> a = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            a.add(rand.nextInt());
        }
        return a;
    }
    
    public static void tulostaInsertTaulukko(){
        ArrayList<>
        
    }
    //täällä on aika copypastea, kun aikamittauksen kanssa oli muuten ongelmia
    public static void muodostaVertailu() {
        Binaarikeko binaari;
        Binomikeko binomi;
        Fibonaccikeko fibo;
        ArrayList<Integer> tuhat = muodostaRandomArray(1000);
        ArrayList<Integer> ktuh = muodostaRandomArray(10000);
        ArrayList<Integer> stuh = muodostaRandomArray(100000);
        ArrayList<Integer> kaksistuh = muodostaRandomArray(200000);
        ArrayList<Integer> milli = muodostaRandomArray(1000000);
        ArrayList<Integer> viisimilli = muodostaRandomArray(5000000);
        ArrayList<Integer> kty = muodostaRandomArray(10001);

        System.out.println("Insertin kesto millisekunneissa eri syötteillä");
        System.out.println("Kaikkiin kekoihin lisätään samat randomgeneroidut luvut.");
        System.out.println("Uudet keot luodaan jokaista n:ää kohden.\n");
        System.out.println("  n      " + ANSI_RED + "binäärikeko    " + ANSI_GREEN + "binomikeko    " + ANSI_BLUE + "fibonaccikeko" + CLOSE);
        binaari = new Binaarikeko();
        binomi = new Binomikeko();
        fibo = new Fibonaccikeko();
        long binaAika = testaaInsert(binaari, tuhat);
        long binoAika = testaaInsert(binomi, tuhat);
        long fiboAika = testaaInsert(fibo, tuhat);
        System.out.println("1000         " + binaAika + "ms           "
                + binoAika + "ms             " + fiboAika + "ms");
        binaari = new Binaarikeko();
        binomi = new Binomikeko();
        fibo = new Fibonaccikeko();
        
        binaAika = testaaInsert(binaari, ktuh);
        binoAika = testaaInsert(binomi, ktuh);
        fiboAika = testaaInsert(fibo, ktuh);
        System.out.println("10000        " + binaAika + "ms          "
                + binoAika + "ms            " + fiboAika + "ms");
        
        ArrayList<Integer> popatut = new ArrayList<>();
        Collections.sort(ktuh);
        
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < 10000; i++){
            popatut.add(binomi.pop());
        }
        long endTime = System.currentTimeMillis();
        System.out.println(popatut.get(0));
        System.out.println(ktuh.get(0));
        long ktuhatpoistoAika = endTime - startTime;
        if(popatut.equals(ktuh)){
            System.out.println("poppaus toimii");
        }
        System.out.println(popatut.size());
        binaari = new Binaarikeko();
        binomi = new Binomikeko();
        fibo = new Fibonaccikeko();
        binaAika = testaaInsert(binaari, stuh);
        binoAika = testaaInsert(binomi, stuh);
        fiboAika = testaaInsert(fibo, stuh);
        System.out.println("100000       " + binaAika + "ms           "
                + binoAika + "ms            " + fiboAika + "ms");
        
        binaari = new Binaarikeko();
        binomi = new Binomikeko();
        fibo = new Fibonaccikeko();
        binaAika = testaaInsert(binaari, kaksistuh);
        binoAika = testaaInsert(binomi, kaksistuh);
        fiboAika = testaaInsert(fibo, kaksistuh);
        System.out.println("200000       " + binaAika + "ms           "
                + binoAika + "ms            " + fiboAika + "ms");
        binaari = new Binaarikeko();
        binomi = new Binomikeko();
        fibo = new Fibonaccikeko();
        binaAika = testaaInsert(binaari, milli);
        binoAika = testaaInsert(binomi, milli);
        fiboAika = testaaInsert(fibo, milli);
        System.out.println("1000000      " + binaAika + "ms          "
                + binoAika + "ms           " + fiboAika + "ms");
        binaari = new Binaarikeko();
        binomi = new Binomikeko();
        fibo = new Fibonaccikeko();
        binaAika = testaaInsert(binaari, viisimilli);
        binoAika = testaaInsert(binomi, viisimilli);
        fiboAika = testaaInsert(fibo, viisimilli);
        System.out.println("5000000       " + binaAika + "ms           "
                + binoAika + "ms            " + fiboAika + "ms");
        
        binaari = new Binaarikeko();
        binomi = new Binomikeko();
        fibo = new Fibonaccikeko();
        binaAika = testaaInsert(binaari, kty);
        binoAika = testaaInsert(binomi, kty);
        fiboAika = testaaInsert(fibo, kty);
        System.out.println("10001       " + binaAika + "ms           "
                + binoAika + "ms            " + fiboAika + "ms");
    }

    public static long testaaInsert(Keko keko, ArrayList<Integer> a) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < a.size(); i++) {
            keko.insert(a.get(i));
        }
        long timenow = System.currentTimeMillis();
        long tulos = timenow- startTime;
        return tulos;
    }

    public static long testaaDelete(Keko keko, int n) {
        long startTime = System.currentTimeMillis();
        for (int i = 1; i <= n; i++) {
            keko.pop();
        }
        long timenow = System.currentTimeMillis();
        return timenow - startTime;
    }

    public long testaaGetmin(Keko keko, int n) {
        long startTime = System.currentTimeMillis();
        for (int i = 1; i <= n; i++) {
            keko.getYlin();
        }
        long timenow = System.currentTimeMillis();
        return timenow - startTime;
    }

    public static void testaa(int n, int monesko) {//monesko + ". osio\n" +
        System.out.println("\n\n" + ANSI_PURPLE + n + " alkiota" + CLOSE);
        long startTime;
        ArrayList<Integer> a = muodostaRandomArray(n);
        Binomikeko binomikeko = new Binomikeko();
        Binaarikeko binaarikeko = new Binaarikeko();
        Fibonaccikeko fibonaccikeko = new Fibonaccikeko();
        System.out.println("\nINSERT:\nlisätään kekoihin " + n + " alkiota: ");
        System.out.println(a.size());
        startTime = System.currentTimeMillis();
        for (int i = 0; i < a.size(); i++) {
            binaarikeko.insert(a.get(i));
        }
        long timenow = System.currentTimeMillis();
        System.out.println(ANSI_RED + "aikaa meni " + (timenow - startTime) + " millisekuntia" + CLOSE);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < a.size(); i++) {
            binomikeko.insert(a.get(i));
        }
        timenow = System.currentTimeMillis();
        System.out.println(ANSI_GREEN + "aikaa meni " + (timenow - startTime) + " millisekuntia" + CLOSE);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < a.size(); i++) {
            fibonaccikeko.insert(a.get(i));
        }
        timenow = System.currentTimeMillis();
        System.out.println(ANSI_BLUE + "aikaa meni " + (timenow - startTime) + " millisekuntia" + CLOSE);

        //getylin
        System.out.println("");
        startTime = System.currentTimeMillis();
        System.out.println("GETMIN:\notetaan keon ylin\nbinäärikeko: " + binaarikeko.getYlin());
        timenow = System.currentTimeMillis();
        System.out.println(ANSI_RED + "aikaa meni " + (timenow - startTime) + " millisekuntia" + CLOSE);

        startTime = System.currentTimeMillis();
        System.out.println("binomikeko: " + binomikeko.getYlin());
        timenow = System.currentTimeMillis();
        System.out.println(ANSI_GREEN + "aikaa meni " + (timenow - startTime) + " millisekuntia" + CLOSE);

        startTime = System.currentTimeMillis();
        System.out.println("fibonaccikeko: " + fibonaccikeko.getYlin());
        timenow = System.currentTimeMillis();
        System.out.println(ANSI_BLUE + "aikaa meni " + (timenow - startTime) + " millisekuntia" + CLOSE);

        //delete
        System.out.println("\nDELETE");
        startTime = System.currentTimeMillis();
        System.out.println("poistetaan keoista ylin alkio");
        System.out.println(binaarikeko.pop());
        timenow = System.currentTimeMillis();
        System.out.println("Binäärikeko: ");
        System.out.println(ANSI_RED + (timenow - startTime) + " millisekuntia" + CLOSE);

        startTime = System.currentTimeMillis();
        System.out.println(binomikeko.pop());
        timenow = System.currentTimeMillis();
        System.out.println("Binomikeko:");
        System.out.println(ANSI_GREEN + (timenow - startTime) + " millisekuntia" + CLOSE);

        System.out.println("Koska fibonaccikeon poiston kesto vaihtelee, poistetaan näytöksi useampi alkio:");
        startTime = System.currentTimeMillis();
        System.out.println(fibonaccikeko.pop());
        timenow = System.currentTimeMillis();
        System.out.println("Fibonaccikeko 1.poisto:");
        System.out.println(ANSI_BLUE + (timenow - startTime) + " millisekuntia" + CLOSE);

        startTime = System.currentTimeMillis();
        System.out.println(fibonaccikeko.pop());
        timenow = System.currentTimeMillis();
        System.out.println("Fibonaccikeko 2.poisto:");
        System.out.println(ANSI_BLUE + (timenow - startTime) + " millisekuntia" + CLOSE);

        startTime = System.currentTimeMillis();
        fibonaccikeko.pop();
        timenow = System.currentTimeMillis();
        System.out.println("Fibonaccikeko 3.poisto:");
        System.out.println(ANSI_BLUE + (timenow - startTime) + " millisekuntia" + CLOSE);

        startTime = System.currentTimeMillis();
        fibonaccikeko.pop();
        timenow = System.currentTimeMillis();
        System.out.println("Fibonaccikeko 4.poisto:");
        System.out.println(ANSI_BLUE + (timenow - startTime) + " millisekuntia" + CLOSE);
    }
}
