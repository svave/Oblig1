import java.util.Arrays;

public class main_tester {
    public static void main(String[]args){
        //Test på opppgave 1
        //int[] a = {3,2,4,6,8,1,5};
       // System.out.println(Oblig1.ombyttinger(a)+Arrays.toString(a));
       // System.out.println(Arrays.toString(a));

        //slutt på oppgave 1

/*
        //Test på oppgave 2
        System.out.println("-----------------oppgave 2-----------------");
        int[] a = {};
        int[] b = {1};
        int[] d = {1, 1};
        int[] e = {1, 2, 3, 4, 5, 6, 7};
        int[] f = {1, 1, 2, 2, 2, 3, 4, 4, 5, 6, 6, 6, 6, 7};

        if (Oblig1.antallUlikeSortert(a) != 0
                || Oblig1.antallUlikeSortert(b) != 1
                || Oblig1.antallUlikeSortert(d) != 1
                || Oblig1.antallUlikeSortert(e) != 7
                || Oblig1.antallUlikeSortert(f) != 7) {
            System.out.println("Oppgave 2: d) Metoden gir feil resultat!");
            System.out.println("Metoden A gir : "+Oblig1.antallUlikeSortert(a));
            System.out.println("Metoden B gir : "+Oblig1.antallUlikeSortert(b));
            System.out.println("Metoden d gir : "+Oblig1.antallUlikeSortert(d));
            System.out.println("Metoden E gir : "+Oblig1.antallUlikeSortert(e));
            System.out.println("Metoden F gir : "+Oblig1.antallUlikeSortert(f));

            //Test på oppgave 3
        int[] a = {};   // skal ikke kaste unntak her!
        int[] b = {1};  // skal ikke kaste unntak her!
        int[] c = {1, 1};
        int[] d = {6, 2, 4, 6, 9, 1, 4, 9, 10};
        int[] dkopi = {6, 2, 4, 6, 9, 1, 4, 9, 10};
        int[] e = {5, 4, 3, 2, 1};
        int[] f = {1, 2, 2, 2, 2, 2, 3};
        if (       Oblig1.antallUlikeUsortert(a) != 0
                || Oblig1.antallUlikeUsortert(b) != 1
                || Oblig1.antallUlikeUsortert(c) != 1
                || Oblig1.antallUlikeUsortert(d) != 6
                || Oblig1.antallUlikeUsortert(e) != 5
                || Oblig1.antallUlikeUsortert(f) != 3) {
            System.out.println("Oppgave 3: b) Metoden gir feil resultat!");
            System.out.println("Oppgave 2: d) Metoden gir feil resultat!");
            System.out.println("Metoden A gir : "+Oblig1.antallUlikeUsortert(a));
            System.out.println("Metoden B gir : "+Oblig1.antallUlikeUsortert(b));
            System.out.println("Metoden C gir : "+Oblig1.antallUlikeUsortert(c));
            System.out.println("Metoden d gir : "+Oblig1.antallUlikeUsortert(d));
             System.out.println("Metoden E gir : "+Oblig1.antallUlikeUsortert(e));
            System.out.println("Metoden F gir : "+Oblig1.antallUlikeUsortert(f));
        }
*/
        //oppgave 4
        int[] delsort = {6,10,9,4,1,3,8,5,2,7};
        Oblig1.delsortering(delsort);
        System.out.println("Delsortert array "+ Arrays.toString(delsort));
/*
        //oppgave 5
        char[] rotering = {'A','B','C','D','E','F','G','H','I','J'};
        Oblig1.rotasjon(rotering);
        System.out.println(Arrays.toString(rotering));
        System.out.println();

        //oppgave 6
        char[] rotering2 = {'A','B','C','D','E','F','G','H','I','J'};
        System.out.println(Arrays.toString(rotering2));

        Oblig1.rotasjon(rotering2,3);
        System.out.println(Arrays.toString(rotering2));
        Oblig1.rotasjon(rotering2,-2);
        System.out.println(Arrays.toString(rotering2));

        //Oppgave 8
        System.out.print("\n\n ////////Oppgave 8 ////////\n\n");

        int[] x = {6,10,16,11,7,12,3,9,8,5};
        int[] index = Oblig1.indekssortering(x);

        System.out.println("Array x : " + Arrays.toString(x));
        System.out.println("Array med indekssortering : " + Arrays.toString(index));
        for(int i = 0; i < x.length; i++){
            System.out.print(x[index[i]] + " ");
        }

        //Oppgave 9
        System.out.print("\n\n////////Oppgave 9 ////////\n\n");
        System.out.println("Array med de tre minste indexene : " + Arrays.toString(Oblig1.tredjeMin(x)));
*/
        String a = Oblig1.flett("ABC","DEFGH");
        String b = Oblig1.flett("IJKLMN","QPQ");
        String c = Oblig1.flett("","AB");
        System.out.println(a+" "+b+" "+c);
        // Utskrift: ADBECFGH IOJPKQLMN AB
        //Oppgave 7b ​"AM "​,​"L"​,​"GEDS"​,​"ORATKRR"​,​""​,​"R TRTE"​,​"IO"​,​"TGAUU"
       String h = Oblig1.flett("AM ","L","GEDS","ORATKRR","","R TRTE","IO","TGAUU");
        System.out.println(h); // ABCDE FGHI JKLM NOPQ RSTU VWXY
        String test = Oblig1.flett("AFK", "BGLP", "CHMQT", "DINRUW", "EJOSVXY");
        System.out.println(test);

    }
}

