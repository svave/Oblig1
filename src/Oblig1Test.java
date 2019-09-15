import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Oblig1Test {

    @org.junit.jupiter.api.Test
    void maks() {
        int[] a = {3};
        int[] b = {5, 2, 8, 4, 7, 6};
        int[] c = {5, 4, 3, 2, 1};
        int[] d = {1, 2, 3, 4, 5};
        if (//Oblig1.maks(a) != 3 ||
                Oblig1.maks(b) != 8
               //|| Oblig1.maks(c) != 5 || Oblig1.maks(d) != 5
                        ) {
            System.out.println("Oppgave 1: c) Maks-metoden: Feil resultat!");
            System.out.println(Arrays.toString(b));

        }

    }
    @org.junit.jupiter.api.Test
    void ombyttinger() {
        int[] a = {4,2,1,3};
        assertEquals(4, Oblig1.ombyttinger(a));
    }


    ///// Oppgave 1 //////////////////////////////////////
    @org.junit.jupiter.api.Test
    void oppgave1() {
        int antallFeil = 0;

        boolean unntak = false;
        int[] tom = {};
        try {
            Oblig1.maks(tom);  // kaller maks-metoden
        } catch (Exception e) {
            unntak = true;
            if (!(e instanceof java.util.NoSuchElementException)) {
                System.out.println("Opgave 1: a) Feil unntak for en tom tabell!");
                antallFeil++;
            }
        }

        if (!unntak) {
            System.out.println("Opgave 1: b) Kast unntak for en tom tabell!");
            antallFeil++;
        }

        int[] a = {3};
        int[] b = {5, 2, 8, 4, 7, 6};
        int[] c = {5, 4, 3, 2, 1};
        int[] d = {1, 2, 3, 4, 5};
        if (Oblig1.maks(a) != 3 || Oblig1.maks(b) != 8 ||
                Oblig1.maks(c) != 5 || Oblig1.maks(d) != 5) {
            System.out.println("Oppgave 1: c) Maks-metoden: Feil resultat!");
            antallFeil++;
        }

        int[] e = {1, 4, 3, 7, 6, 5, 10, 2, 9, 8};
        int[] f = {1, 3, 4, 6, 5, 7, 2, 9, 8, 10};

        Oblig1.maks(e);
        if (!Arrays.equals(e, f)) {
            System.out.println("Oppgave 1: d) Maks-metoden: feil i ombyttingene!");
            antallFeil++;
        }

        a = new int[]{6, 5, 4, 3, 2, 1};
        b = new int[]{1, 2, 3, 4, 5};
        c = new int[]{4, 9, 3, 6, 1, 5, 7, 8, 10, 2};
        d = new int[]{2, 5, 8, 4, 3, 10, 1, 7, 6, 9};

        if (Oblig1.ombyttinger(a) != 5 || Oblig1.ombyttinger(b) != 0
                || Oblig1.ombyttinger(c) != 7 || Oblig1.ombyttinger(d) != 6) {
            System.out.println("Oppgave 1: e) Feil opptelling i ombyttingsmetoden!");
            antallFeil++;
        }
        //assertEquals(0, antallFeil, "Du har for mange feil i oppgave 1");
    }

    void oppgave2() {
        int antallFeil = 0;

        int[] a = {};
        int[] b = {1};
        int[] c = {1, 2, 3, 4, 5, 4};

        try {
            Oblig1.antallUlikeSortert(a);  // kaller metoden
            Oblig1.antallUlikeSortert(b);  // kaller metoden
        } catch (Exception e) {
            System.out.println
                    ("Oppgave 2: a) Ikke unntak for tabell med 0 eller 1 verdi!");
            antallFeil++;
        }

        boolean unntak = false;

        try {
            Oblig1.antallUlikeSortert(c);  // kaller metoden
        } catch (Exception e) {
            unntak = true;
            if (!(e instanceof IllegalStateException)) {
                System.out.println
                        ("Oppgave 2: b) Feil unntak for en usortert tabell!");
                antallFeil++;
            }
        }

        if (!unntak) {
            System.out.println
                    ("Oppgave 2: c) Kast et unntak for en usortert tabell!");
            antallFeil++;
        }

        int[] d = {1, 1};
        int[] e = {1, 2, 3, 4, 5, 6, 7};
        int[] f = {1, 1, 2, 2, 2, 3, 4, 4, 5, 6, 6, 6, 6, 7};

        if (Oblig1.antallUlikeSortert(a) != 0
                || Oblig1.antallUlikeSortert(b) != 1
                || Oblig1.antallUlikeSortert(d) != 1
                || Oblig1.antallUlikeSortert(e) != 7
                || Oblig1.antallUlikeSortert(f) != 7) {
            System.out.println("Oppgave 2: d) Metoden gir feil resultat!");
            antallFeil++;
        }
        assertEquals(0, antallFeil, "Du har for mange feil i oppgave 2");
    }
    ///// Oppgave 3 //////////////////////////////////////
    @org.junit.jupiter.api.Test
    void oppgave3() {
        int antallFeil = 0;

        int[] a = {};   // skal ikke kaste unntak her!
        int[] b = {1};  // skal ikke kaste unntak her!
        int[] c = {1, 1};
        int[] d = {6, 2, 4, 6, 9, 1, 4, 9, 10};
        int[] dkopi = {6, 2, 4, 6, 9, 1, 4, 9, 10};
        int[] e = {5, 4, 3, 2, 1};
        int[] f = {1, 2, 2, 2, 2, 2, 3};

        try {
            Oblig1.antallUlikeUsortert(a);  // kaller metoden
            Oblig1.antallUlikeUsortert(b);  // kaller metoden
        } catch (Exception ex) {
            System.out.println
                    ("Oppgave 3: a) Ikke unntak for tabell med 0 eller 1 verdi!");
            antallFeil++;
        }

        if (Oblig1.antallUlikeUsortert(a) != 0
                || Oblig1.antallUlikeUsortert(b) != 1
                || Oblig1.antallUlikeUsortert(c) != 1
                || Oblig1.antallUlikeUsortert(d) != 6
                || Oblig1.antallUlikeUsortert(e) != 5
                || Oblig1.antallUlikeUsortert(f) != 3) {
            System.out.println("Oppgave 3: b) Metoden gir feil resultat!");
            antallFeil++;
        }

        if (!Arrays.equals(d, dkopi)) {
            System.out.println("Oppgave 3: c) Metoden endrer tabellen!");
            antallFeil++;
        }

        //assertEquals(0, antallFeil, "Du har for mange feil i oppgave 3");
    }

    ///// Oppgave 4 //////////////////////////////////////
    @org.junit.jupiter.api.Test
    void oppgave4() {
        int antallFeil = 0;

        int[] a = {};   // skal ikke kaste unntak her!

        try {
            Oblig1.delsortering(a);  // kaller metoden
        } catch (Exception ex) {
            System.out.println
                    ("Oppgave 4: a) Ikke unntak for en tom tabell!");
            antallFeil++;
        }

        a = new int[]{5};
        int[] b = {5};

        try {
            Oblig1.delsortering(a);  // kaller metoden
        } catch (Exception ex) {
            System.out.println
                    ("Oppgave 4: b) Skal ikke kastes unntak her!");
            antallFeil++;
        }

        if (!Arrays.equals(a, b)) {
            System.out.println
                    ("Oppgave 4: c) Metoden gjør feil for en tabell en verdi!");
            antallFeil++;
        }

        a = new int[]{4};
        b = new int[]{4};

        try {
            Oblig1.delsortering(a);  // kaller metoden
        } catch (Exception ex) {
            System.out.println
                    ("Oppgave 4: d) Skal ikke kastes unntak her!");
            antallFeil++;
        }

        if (!Arrays.equals(a, b)) {
            System.out.println
                    ("Oppgave 4: e) Metoden gjør feil for en tabell en verdi!");
            antallFeil++;
        }

        a = new int[]{4, 2, 6, 10, 8};
        b = new int[]{2, 4, 6, 8, 10};

        try {
            Oblig1.delsortering(a);  // kaller metoden
        } catch (Exception ex) {
            System.out.println
                    ("Oppgave 4: f) Det går galt hvis det kun er partall!");
            antallFeil++;
        }

        if (!Arrays.equals(a, b)) {
            System.out.println
                    ("Oppgave 4: g) Det blir feil hvis det kun er partall!");
            antallFeil++;
        }

        a = new int[]{9, 5, 3, 1, 7};
        b = new int[]{1, 3, 5, 7, 9};

        try {
            Oblig1.delsortering(a);  // kaller metoden
        } catch (Exception ex) {
            System.out.println
                    ("Oppgave 4: h) Det går galt hvis det kun er oddetall!");
            antallFeil++;
        }

        if (!Arrays.equals(a, b)) {
            System.out.println
                    ("Oppgave 4: i) Det blir feil hvis det kun er oddetall!");
            antallFeil++;
        }

        a = new int[]{1, 2, 3, 4, 5, 6};
        b = new int[]{1, 3, 5, 2, 4, 6};
        boolean flere = true;

       /* do {
            int[] c = a.clone();
            Oblig1.delsortering(c);

            if (!Arrays.equals(c, b)) {
                System.out.println
                        ("Oppgave 4: j) Gitt tabell:     " + Arrays.toString(a));
                System.out.println
                        ("              Metoden skal gi: " + Arrays.toString(b));
                System.out.println
                        ("              Du fikk:         " + Arrays.toString(c));

                antallFeil++;
                break;
            }
        } while (nestePermutasjon(a));*/

        a = new int[]{-4, -1, 3, 0, 2, -3, -2, 4, 1};
        b = new int[]{-3, -1, 1, 3, -4, -2, 0, 2, 4};

        try {
            Oblig1.delsortering(a);  // kaller metoden
        } catch (Exception ex) {
            System.out.println
                    ("Oppgave 4: k) Skal ikke kastes unntak her!");
            antallFeil++;
        }

        if (!Arrays.equals(a, b)) {
            System.out.println
                    ("Oppgave 4: l) Metoden gjør feil for negative verdier!");
            antallFeil++;
        }

        if (antallFeil == 0) {
            //a = randPerm(100000);
            long tid = System.currentTimeMillis();
            Oblig1.delsortering(a);
            tid = System.currentTimeMillis() - tid;

            for (int i = 0; i < 50000; i++) {
                if (a[i] != 2 * i + 1) {
                    System.out.println
                            ("Oppgave 4: m) Feil resultat for denne tabellen!");
                    antallFeil++;
                    break;
                }
            }

            for (int i = 50000; i < 100000; i++) {
                if (a[i] != 2 * (i - 49999)) {
                    System.out.println
                            ("Oppgave 4: n) Feil resultat for denne tabellen!");
                    antallFeil++;
                    break;
                }
            }

            if (tid > 100) {
                System.out.println
                        ("Oppgave 4: o) Tid: " + tid + ". Metoden er for ineffektiv!");
                System.out.println
                        ("              Hint: Bruk en partisjoneringsteknikk!");
                antallFeil++;
            }
        }

        assertEquals(0, antallFeil, "Du har for mange feil i oppgave 4");
    }


    ///// Oppgave 5 //////////////////////////////////////
    @org.junit.jupiter.api.Test
    void oppgave5() {
        int antallFeil = 0;

        char[] a = {};

        try {
            Oblig1.rotasjon(a);  // kaller metoden
        } catch (Exception e) {
            System.out.println
                    ("Oppgave 5: a) Skal ikke kaste unntak for en tom tabell!!");
            antallFeil++;
        }

        char[] b = {'A'};
        char[] b0 = {'A'};
        Oblig1.rotasjon(b);
        if (!Arrays.equals(b, b0)) {
            System.out.println("Oppgave 5: b) Feil hvis tabellen har ett element!");
            antallFeil++;
        }

        char[] c = {'A', 'B'};
        char[] c0 = {'B', 'A'};
        Oblig1.rotasjon(c);
        if (!Arrays.equals(c, c0)) {
            System.out.println("Oppgave 5: c) Feil hvis tabellen har to elementer!");
            antallFeil++;
        }

        char[] d = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        char[] d0 = {'J', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};

        Oblig1.rotasjon(d);
        if (!Arrays.equals(d, d0)) {
            System.out.println("Oppgave 5: d) Feil hvis tabellen har flere elementer!");
            antallFeil++;
        }

        assertEquals(0, antallFeil, "Du har for mange feil i oppgave 5");
    }




    @org.junit.jupiter.api.Test
    void oppgave7() {

/*        String a = Oblig1.flett("ABC", "DEFGH");
        String b = Oblig1.flett("IJKLMN","OPQ");
        String c = Oblig1.flett("","AB");
        System.out.println(a + " "+ b +" "+ c);
*/
        System.out.println("\n------------------------\nOppgave 7b");
        String[] test = {"AM ","L","GEDS","ORAKTRS","","R TRTE","IO","TAGAUU"};
        String d = Oblig1.flett(test);
        System.out.println(d);
        //​ Utskrift: ALGORITMER OG DATASTRUKTURER
    }

    @org.junit.jupiter.api.Test
    void oppgave10() {
        /* Funker å finne a i b
        String a = "Katt";
        String b = "Finner du Katt i denne stringen?";
        System.out.println(Oblig1.inneholdt(a,b));
        */

        /*Prøver b i a
        * String b = "Katt";
        String a = "finner du Katt i denne stringen?";
        System.out.println(Oblig1.inneholdt(b,a));
        * */

        /*Tester med to tomme strings
        * String a = "";
        String b = "";
        System.out.println(Oblig1.inneholdt(a,b));
        * */
        boolean b = false;
        /*try {
            b = Oblig1.inneholdt("", "A");  // kaller metoden
        } catch (Exception e) {
            System.out.println(e);
            System.out.println
                    ("Oppgave 10: c) Skal ikke kaste unntak for et tomt ord!!");
         } if (b != true) {
            System.out.println
                    ("Oppgave 10: d) Svaret skal bli lik true her!");
        }
        try {
            b = Oblig1.inneholdt("A", "");  // kaller metoden
        } catch (Exception e) {
            System.out.println(e);
            System.out.println
                    ("Oppgave 10: e) Skal ikke kaste unntak for et tomt ord!!");
        }

        if (b != false) {
            System.out.println
                    ("Oppgave 10: f) Svaret skal bli lik false her!");
        }
        b = Oblig1.inneholdt("ABBA", "ABBA");
        if (b != true) {
            System.out.println
                    ("Oppgave 10: g) Svaret skal bli lik true her!");
            }

        b = Oblig1.inneholdt("XYYX", "AAAAAAAYXXY");
        if (b != true) {
            System.out.println
                    ("Oppgave 10: h) Svaret skal bli lik true her!");
        }*/
        String a = "XYYX";
        String c = "AAAAAAAAYXXY";
        System.out.println(Oblig1.inneholdt(a,c));

    }
}