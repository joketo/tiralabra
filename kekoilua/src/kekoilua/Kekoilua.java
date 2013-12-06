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
            System.out.println("\n" + ANSI_YELLOW + "TERVETULOA! ＼（＾▽＾）／" + CLOSE + "\nTestataan kolmea kekoa:");
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
            } else if (syote.equals("demo")) {
                montako = Integer.parseInt(args[1]);
                testaa(1000);
            }
            System.out.println("testit loppuvat tähän\n");
        } else {
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
    public static ArrayList<Long> poistoAjat;
    public static ArrayList<Long> gettiAjat;

    public static ArrayList<Integer> muodostaRandomArray(int n) {
        ArrayList<Integer> a = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            a.add(rand.nextInt());
        }
        return a;
    }

    public static void muodostaVertailu() {
        System.out.println(ANSI_RED + "HUOM! kaikki laskut tehdään Insertin ohella, siksi se saattaa jumittaa" + CLOSE);
        System.out.println("Javan roskienkerääjä näyttää vaikuttavan tuloksiin\n");
        tulostaInsertTaulukko();
        System.out.println("");
        tulostaGettiTaulukko();
        System.out.println("");
        tulostaDeleteTaulukko();
    }

    public static void tulostaDeleteTaulukko() {
        System.out.println("Deleten kesto millisekunneissa eri syötemäärillä\n");
        System.out.println("  n      " + ANSI_RED + "binäärikeko    " + ANSI_GREEN + "binomikeko    " + ANSI_BLUE + "fibonaccikeko" + CLOSE);
        System.out.println("1000         " + poistoAjat.get(0) + "ms           "
                + poistoAjat.get(1) + "ms             " + poistoAjat.get(2) + "ms");
        System.out.println("10000        " + poistoAjat.get(3) + "ms           "
                + poistoAjat.get(4) + "ms             " + poistoAjat.get(5) + "ms");
        System.out.println("100000       " + poistoAjat.get(6) + "ms          "
                + poistoAjat.get(7) + "ms             " + poistoAjat.get(8) + "ms");
        System.out.println("200000       " + poistoAjat.get(9) + "ms           "
                + poistoAjat.get(10) + "ms             " + poistoAjat.get(11) + "ms");
        System.out.println("1000000      " + poistoAjat.get(12) + "ms         "
                + poistoAjat.get(13) + "ms             " + poistoAjat.get(14) + "ms");
        System.out.println("5000000      " + poistoAjat.get(15) + "ms        "
                + poistoAjat.get(16) + "ms             " + poistoAjat.get(17) + "ms");
    }

    public static void tulostaGettiTaulukko() {
        System.out.println("Minimin ottamisen kesto millisekunneissa eri syötemäärillä\n");
        System.out.println("  n      " + ANSI_RED + "binäärikeko    " + ANSI_GREEN + "binomikeko    " + ANSI_BLUE + "fibonaccikeko" + CLOSE);
        System.out.println("1000         " + gettiAjat.get(0) + "ms           "
                + gettiAjat.get(1) + "ms             " + gettiAjat.get(2) + "ms");
        System.out.println("10000        " + gettiAjat.get(3) + "ms           "
                + gettiAjat.get(4) + "ms             " + gettiAjat.get(5) + "ms");
        System.out.println("100000       " + gettiAjat.get(6) + "ms          "
                + gettiAjat.get(7) + "ms             " + gettiAjat.get(8) + "ms");
        System.out.println("200000       " + gettiAjat.get(9) + "ms           "
                + gettiAjat.get(10) + "ms             " + gettiAjat.get(11) + "ms");
        System.out.println("1000000      " + gettiAjat.get(12) + "ms         "
                + gettiAjat.get(13) + "ms           " + gettiAjat.get(14) + "ms");
        System.out.println("5000000      " + gettiAjat.get(15) + "ms        "
                + gettiAjat.get(16) + "ms           " + gettiAjat.get(17) + "ms");
    }

    //VAROITUS!!! HIRVEÄÄ COPYPASTEA!!
    public static void tulostaInsertTaulukko() {
        poistoAjat = new ArrayList<>();
        gettiAjat = new ArrayList<>();
        Binaarikeko binaari;
        Binomikeko binomi;
        Fibonaccikeko fibo;
        ArrayList<Integer> tuhat = muodostaRandomArray(1000);
        ArrayList<Integer> ktuh = muodostaRandomArray(10000);
        ArrayList<Integer> stuh = muodostaRandomArray(100000);
        ArrayList<Integer> kaksistuh = muodostaRandomArray(200000);
        ArrayList<Integer> milli = muodostaRandomArray(1000000);
        ArrayList<Integer> viisimilli = muodostaRandomArray(5000000);

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

        //otetaan gettiajat talteen:
        long gStartTime = System.currentTimeMillis(); //binääri
        for (int i = 0; i < 1000; i++) {
            binaari.getYlin();
        }
        long gEndTime = System.currentTimeMillis();
        long gPoistoAika = gEndTime - gStartTime;
        gettiAjat.add(gPoistoAika);

        gStartTime = System.currentTimeMillis(); //binomi
        for (int i = 0; i < 1000; i++) {
            binomi.getYlin();
        }
        gEndTime = System.currentTimeMillis();
        gPoistoAika = gEndTime - gStartTime;
        gettiAjat.add(gPoistoAika);

        gStartTime = System.currentTimeMillis(); //fibonacci
        for (int i = 0; i < 1000; i++) {
            fibo.getYlin();
        }
        gEndTime = System.currentTimeMillis();
        gPoistoAika = gEndTime - gStartTime;
        gettiAjat.add(gPoistoAika);
        //

        //otetaan deleteajat talteen
        long dStartTime = System.currentTimeMillis(); //binääri
        for (int i = 0; i < 1000; i++) {
            binaari.pop();
        }
        long endTime = System.currentTimeMillis();
        long poistoAika = endTime - dStartTime;
        poistoAjat.add(poistoAika);

        dStartTime = System.currentTimeMillis(); //binomi
        for (int i = 0; i < 1000; i++) {
            binomi.pop();
        }
        endTime = System.currentTimeMillis();
        poistoAika = endTime - dStartTime;
        poistoAjat.add(poistoAika);

        dStartTime = System.currentTimeMillis(); //fibonacci
        for (int i = 0; i < 1000; i++) {
            fibo.pop();
        }
        endTime = System.currentTimeMillis();
        poistoAika = endTime - dStartTime;
        poistoAjat.add(poistoAika);
        //

        binaari = new Binaarikeko();
        binomi = new Binomikeko();
        fibo = new Fibonaccikeko();
        binaAika = testaaInsert(binaari, ktuh);
        binoAika = testaaInsert(binomi, ktuh);
        fiboAika = testaaInsert(fibo, ktuh);
        System.out.println("10000        " + binaAika + "ms          "
                + binoAika + "ms            " + fiboAika + "ms");

        //otetaan gettiajat talteen:
        gStartTime = System.currentTimeMillis(); //binääri
        for (int i = 0; i < 10000; i++) {
            binaari.getYlin();
        }
        gEndTime = System.currentTimeMillis();
        gPoistoAika = gEndTime - gStartTime;
        gettiAjat.add(gPoistoAika);

        gStartTime = System.currentTimeMillis(); //binomi
        for (int i = 0; i < 10000; i++) {
            binomi.getYlin();
        }
        gEndTime = System.currentTimeMillis();
        gPoistoAika = gEndTime - gStartTime;
        gettiAjat.add(gPoistoAika);

        gStartTime = System.currentTimeMillis(); //fibonacci
        for (int i = 0; i < 10000; i++) {
            fibo.getYlin();
        }
        gEndTime = System.currentTimeMillis();
        gPoistoAika = gEndTime - gStartTime;
        gettiAjat.add(gPoistoAika);
        //

        //otetaan deleteajat talteen
        dStartTime = System.currentTimeMillis(); //binääri
        for (int i = 0; i < 10000; i++) {
            binaari.pop();
        }
        endTime = System.currentTimeMillis();
        poistoAika = endTime - dStartTime;
        poistoAjat.add(poistoAika);

        dStartTime = System.currentTimeMillis(); //binomi
        for (int i = 0; i < 10000; i++) {
            binomi.pop();
        }
        endTime = System.currentTimeMillis();
        poistoAika = endTime - dStartTime;
        poistoAjat.add(poistoAika);

        dStartTime = System.currentTimeMillis(); //fibonacci
        for (int i = 0; i < 10000; i++) {
            fibo.pop();
        }
        endTime = System.currentTimeMillis();
        poistoAika = endTime - dStartTime;
        poistoAjat.add(poistoAika);
        //

        binaari = new Binaarikeko();
        binomi = new Binomikeko();
        fibo = new Fibonaccikeko();
        binaAika = testaaInsert(binaari, stuh);
        binoAika = testaaInsert(binomi, stuh);
        fiboAika = testaaInsert(fibo, stuh);
        System.out.println("100000       " + binaAika + "ms           "
                + binoAika + "ms            " + fiboAika + "ms");

        //otetaan gettiajat talteen:
        gStartTime = System.currentTimeMillis(); //binääri
        for (int i = 0; i < 100000; i++) {
            binaari.getYlin();
        }
        gEndTime = System.currentTimeMillis();
        gPoistoAika = gEndTime - gStartTime;
        gettiAjat.add(gPoistoAika);

        gStartTime = System.currentTimeMillis(); //binomi
        for (int i = 0; i < 100000; i++) {
            binomi.getYlin();
        }
        gEndTime = System.currentTimeMillis();
        gPoistoAika = gEndTime - gStartTime;
        gettiAjat.add(gPoistoAika);

        gStartTime = System.currentTimeMillis(); //fibonacci
        for (int i = 0; i < 100000; i++) {
            fibo.getYlin();
        }
        gEndTime = System.currentTimeMillis();
        gPoistoAika = gEndTime - gStartTime;
        gettiAjat.add(gPoistoAika);
        //

        //otetaan deleteajat talteen
        dStartTime = System.currentTimeMillis(); //binääri
        for (int i = 0; i < 100000; i++) {
            binaari.pop();
        }
        endTime = System.currentTimeMillis();
        poistoAika = endTime - dStartTime;
        poistoAjat.add(poistoAika);

        dStartTime = System.currentTimeMillis(); //binomi
        for (int i = 0; i < 100000; i++) {
            binomi.pop();
        }
        endTime = System.currentTimeMillis();
        poistoAika = endTime - dStartTime;
        poistoAjat.add(poistoAika);

        dStartTime = System.currentTimeMillis(); //fibonacci
        for (int i = 0; i < 100000; i++) {
            fibo.pop();
        }
        endTime = System.currentTimeMillis();
        poistoAika = endTime - dStartTime;
        poistoAjat.add(poistoAika);
        //

        binaari = new Binaarikeko();
        binomi = new Binomikeko();
        fibo = new Fibonaccikeko();
        binaAika = testaaInsert(binaari, kaksistuh);
        binoAika = testaaInsert(binomi, kaksistuh);
        fiboAika = testaaInsert(fibo, kaksistuh);
        System.out.println("200000       " + binaAika + "ms          "
                + binoAika + "ms            " + fiboAika + "ms");

        //otetaan gettiajat talteen:
        gStartTime = System.currentTimeMillis(); //binääri
        for (int i = 0; i < 20000; i++) {
            binaari.getYlin();
        }
        gEndTime = System.currentTimeMillis();
        gPoistoAika = gEndTime - gStartTime;
        gettiAjat.add(gPoistoAika);

        gStartTime = System.currentTimeMillis(); //binomi
        for (int i = 0; i < 20000; i++) {
            binomi.getYlin();
        }
        gEndTime = System.currentTimeMillis();
        gPoistoAika = gEndTime - gStartTime;
        gettiAjat.add(gPoistoAika);

        gStartTime = System.currentTimeMillis(); //fibonacci
        for (int i = 0; i < 20000; i++) {
            fibo.getYlin();
        }
        gEndTime = System.currentTimeMillis();
        gPoistoAika = gEndTime - gStartTime;
        gettiAjat.add(gPoistoAika);
        //

        //otetaan deleteajat talteen
        dStartTime = System.currentTimeMillis(); //binääri
        for (int i = 0; i < 20000; i++) {
            binaari.pop();
        }
        endTime = System.currentTimeMillis();
        poistoAika = endTime - dStartTime;
        poistoAjat.add(poistoAika);

        dStartTime = System.currentTimeMillis(); //binomi
        for (int i = 0; i < 20000; i++) {
            binomi.pop();
        }
        endTime = System.currentTimeMillis();
        poistoAika = endTime - dStartTime;
        poistoAjat.add(poistoAika);

        dStartTime = System.currentTimeMillis(); //fibonacci
        for (int i = 0; i < 20000; i++) {
            fibo.pop();
        }
        endTime = System.currentTimeMillis();
        poistoAika = endTime - dStartTime;
        poistoAjat.add(poistoAika);
        //

        binaari = new Binaarikeko();
        binomi = new Binomikeko();
        fibo = new Fibonaccikeko();
        binaAika = testaaInsert(binaari, milli);
        binoAika = testaaInsert(binomi, milli);
        fiboAika = testaaInsert(fibo, milli);
        System.out.println("1000000      " + binaAika + "ms         "
                + binoAika + "ms           " + fiboAika + "ms");

        //otetaan gettiajat talteen:
        gStartTime = System.currentTimeMillis(); //binääri
        for (int i = 0; i < 1000000; i++) {
            binaari.getYlin();
        }
        gEndTime = System.currentTimeMillis();
        gPoistoAika = gEndTime - gStartTime;
        gettiAjat.add(gPoistoAika);

        gStartTime = System.currentTimeMillis(); //binomi
        for (int i = 0; i < 1000000; i++) {
            binomi.getYlin();
        }
        gEndTime = System.currentTimeMillis();
        gPoistoAika = gEndTime - gStartTime;
        gettiAjat.add(gPoistoAika);

        gStartTime = System.currentTimeMillis(); //fibonacci
        for (int i = 0; i < 1000000; i++) {
            fibo.getYlin();
        }
        gEndTime = System.currentTimeMillis();
        gPoistoAika = gEndTime - gStartTime;
        gettiAjat.add(gPoistoAika);
        //

        //otetaan deleteajat talteen
        dStartTime = System.currentTimeMillis(); //binääri
        for (int i = 0; i < 1000000; i++) {
            binaari.pop();
        }
        endTime = System.currentTimeMillis();
        poistoAika = endTime - dStartTime;
        poistoAjat.add(poistoAika);

        dStartTime = System.currentTimeMillis(); //binomi
        for (int i = 0; i < 1000000; i++) {
            binomi.pop();
        }
        endTime = System.currentTimeMillis();
        poistoAika = endTime - dStartTime;
        poistoAjat.add(poistoAika);

        dStartTime = System.currentTimeMillis(); //fibonacci
        for (int i = 0; i < 1000000; i++) {
            fibo.pop();
        }
        endTime = System.currentTimeMillis();
        poistoAika = endTime - dStartTime;
        poistoAjat.add(poistoAika);
        //

        binaari = new Binaarikeko();
        binomi = new Binomikeko();
        fibo = new Fibonaccikeko();
        binaAika = testaaInsert(binaari, viisimilli);
        binoAika = testaaInsert(binomi, viisimilli);
        fiboAika = testaaInsert(fibo, viisimilli);
        System.out.println("5000000      " + binaAika + "ms        "
                + binoAika + "ms          " + fiboAika + "ms");

        //otetaan gettiajat talteen:
        gStartTime = System.currentTimeMillis(); //binääri
        for (int i = 0; i < 5000000; i++) {
            binaari.getYlin();
        }
        gEndTime = System.currentTimeMillis();
        gPoistoAika = gEndTime - gStartTime;
        gettiAjat.add(gPoistoAika);

        gStartTime = System.currentTimeMillis(); //binomi
        for (int i = 0; i < 5000000; i++) {
            binomi.getYlin();
        }
        gEndTime = System.currentTimeMillis();
        gPoistoAika = gEndTime - gStartTime;
        gettiAjat.add(gPoistoAika);

        gStartTime = System.currentTimeMillis(); //fibonacci
        for (int i = 0; i < 5000000; i++) {
            fibo.getYlin();
        }
        gEndTime = System.currentTimeMillis();
        gPoistoAika = gEndTime - gStartTime;
        gettiAjat.add(gPoistoAika);
        //

        //otetaan deleteajat talteen
        dStartTime = System.currentTimeMillis(); //binääri
        for (int i = 0; i < 5000000; i++) {
            binaari.pop();
        }
        endTime = System.currentTimeMillis();
        poistoAika = endTime - dStartTime;
        poistoAjat.add(poistoAika);

        dStartTime = System.currentTimeMillis(); //binomi
        for (int i = 0; i < 5000000; i++) {
            binomi.pop();
        }
        endTime = System.currentTimeMillis();
        poistoAika = endTime - dStartTime;
        poistoAjat.add(poistoAika);

        dStartTime = System.currentTimeMillis(); //fibonacci
        for (int i = 0; i < 5000000; i++) {
            fibo.pop();
        }
        endTime = System.currentTimeMillis();
        poistoAika = endTime - dStartTime;
        poistoAjat.add(poistoAika);
        //

    }

    public static long testaaInsert(Keko keko, ArrayList<Integer> a) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < a.size(); i++) {
            keko.insert(a.get(i));
        }
        long timenow = System.currentTimeMillis();
        long tulos = timenow - startTime;
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

    public static void testaa(int n) {
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
