import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Oblig1Test {

    @org.junit.jupiter.api.Test
        void indekssortering() {
            int [] forventet = new int[]{6, 9, 0, 4, 8, 7, 1, 3, 5, 2};
            assertArrayEquals(forventet, Oblig1.indekssortering(new int[]{6,10,16,11,7,12,3,9,8,5}));
        }

    @org.junit.jupiter.api.Test
    void oppgave8() {
        int antallFeil = 0;

        int[] a = {};  // en tom tabell
        int[] indeks = null;

        try {
            indeks = Oblig1.indekssortering(a);  // kaller metoden
        } catch (Exception e) {
            System.out.println
                    ("Opgave 8: a) Skal ikke kastes unntak for en tom tabell!");
            antallFeil++;
        }

        if (indeks == null || indeks.length > 0) {
            System.out.println
                    ("Opgave 8: b) Indekstabellen skal ha lengde 0!");
            antallFeil++;
        }

        a = new int[]{5};

        try {
            indeks = Oblig1.indekssortering(a);  // kaller metoden
        } catch (Exception e) {
            System.out.println
                    ("Opgave 8: c) Skal ikke kastes unntak her!");
            antallFeil++;
        }

        if (indeks == null || indeks.length == 0 || indeks.length > 1) {
            System.out.println
                    ("Opgave 8: d) Indekstabellen skal ha lengde 1!");
            antallFeil++;
        }

        if (indeks[0] != 0) {
            System.out.println
                    ("Opgave 8: e) indeks[0] skal være lik 0!");
            antallFeil++;
        }

        a = new int[]{1, 2, 3, 4, 5, 6};
        int[] b = new int[]{1, 2, 3, 4, 5, 6};
        boolean flere = true;

        do {
            int[] c = a.clone();
            indeks = Oblig1.indekssortering(c);

            if (!Arrays.equals(a, c)) {
                System.out.println
                        ("Oppgave 8: f) Tabellen før kallet:   " + Arrays.toString(a));
                System.out.println
                        ("              Tabellen etter kallet: " + Arrays.toString(c));
                System.out.println
                        ("              Parametertabellen skal ikke endres!");

                antallFeil++;
                break;
            }

            int[] d = new int[a.length];
            for (int i = 0; i < d.length; i++) d[i] = a[indeks[i]];

            if (!Arrays.equals(b, d)) {
                System.out.println
                        ("Oppgave 8: g) Feil i indekstabellen for a = " + Arrays.toString(a));

                antallFeil++;
                break;
            }

        } while (Oblig1.nestePermutasjon(a));

        a = new int[]{5, 2, 8, 3, 5, 10, 7, 5, 2, 10, 6};
        int[] c = a.clone();
        b = new int[]{2, 2, 3, 5, 5, 5, 6, 7, 8, 10, 10};
        indeks = Oblig1.indekssortering(a);
        int[] d = new int[a.length];
        for (int i = 0; i < d.length; i++) d[i] = a[indeks[i]];

        if (!Arrays.equals(a, c)) {
            System.out.println
                    ("Oppgave 8: h) Parametertabellen endres når den er lik");
            System.out.println
                    ("            " + Arrays.toString(a));

            antallFeil++;
        }

        if (!Arrays.equals(b, d)) {
            System.out.println
                    ("Oppgave 8: i) Feil i indekstabellen for a = " + Arrays.toString(a));

            antallFeil++;
        }

        assertEquals(0, antallFeil, "Du har for mange feil i oppgave 8");
    }

}