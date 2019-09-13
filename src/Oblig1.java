import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Oblig1 {
    //Oppgave 1
    /*
    *  ● Når blir det flest ombyttinger?
    *       -Det blir flest ombyttinger når tallet foran alltid er større enn tallet som kommer etter. Feks (10,9,8,7,6,5,4..1)
    *       Grunnen til dette er at vi må bytte rundt hele arrayet.
     * ● Når blir det færrest?
     *      -Det vil bli færrest når det er i stigende rekkefølge. Dette vil føre til at tallet foran ikke er større enn det bak og
     *      dermed kommer vi ikke til å måtte ha noen bytte operasjoner.
     * ● Hvor mange blir det i gjennomsnitt?
     *      -I gjennomsnitt er det n-1 sammenligninger.
    * */
    public static int størst(int[] a){

        if(a.length == 0){
            throw new NoSuchElementException("Array :"+a+" can not be empty");
        } else{
        int storst_tall = a[0];
        int storste_indeks = 0;

        for(int i = (a.length-1); i>=0; i--){
            for(int j = 1; j<i; j++){
                if(a[j] > storst_tall){
                    storst_tall = a[i];
                    bytt(a, storst_tall,i);
                }
            }
        }
            return storst_tall;
        }
    }
    public static void bytt(int[] a, int i, int j)
    {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }
    public static int ombyttinger(int[] a){
        int antall =0;
        return antall;
    }
    //Slutt på oppgave 1

    //Oppgave 2
    public static int antallUlikeSortert(int[] a){
        int antallForskjellig = 0;
        if(!(sortertKontroll(a))){
            throw new IllegalStateException("The array is not sorted and can thus not be runs");
        } else {
            for(int i = 1; i<a.length; i++){
                if(i != a[i]){
                    antallForskjellig++;
                }else if(i == a[i]){
                    antallForskjellig++;
                }//else if{ //NOTE: Fikse så at hvis det er 0 elementer så returnerer utkallet 0.}
            }
        }
        return antallForskjellig;
    }

    public static int maks(int[] a, int fra, int til) {
        fratilKontroll(a.length,fra,til);

        if (fra == til) {
            throw new NoSuchElementException("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");
        }

        if(a == null) {
            throw new NullPointerException("Arrayet metoden fikk inn er en nullpeker!");
        }

        int m = fra;              // indeks til største verdi i a[fra:til>
        int maksverdi = a[fra];   // største verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++)
        {
            if (a[i] > maksverdi)
            {
                m = i;                // indeks til største verdi oppdateres
                maksverdi = a[m];     // største verdi oppdateres
            }
        }

        return maksverdi;  // posisjonen til største verdi i a[fra:til>
    }
    public static void fratilKontroll(int tablengde, int fra, int til) {
        if (fra < 0)                                  // fra er negativ
            throw new ArrayIndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");

        if (til > tablengde)                          // til er utenfor tabellen
            throw new ArrayIndexOutOfBoundsException
                    ("til(" + til + ") > tablengde(" + tablengde + ")");

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
    }

    public static int maks(int[] a)
    { // bruker hele tabellen
        return maks(a,0,a.length);     // kaller metoden over
    }
    public static boolean sortertKontroll(int[] a){
        int lengde = a.length;
        if(lengde < 2){
            throw new NoSuchElementException("Has to be more than two numbers");
        } else{
            for(int i = lengde; i>1; i--){
                int max_tall = maks(a, 0, i);
                if(!(max_tall == i-1)){
                    bytt(a, max_tall, i-1);
                    return true;
                }
            }
        }
        return false;
    }
    //Slutt på oppgave 2


    //Start på oppgave 3
    public static int antallUlikeUSortert(int[] a){
        int ulike = 1;

        for(int i = 1; i<a.length; i++){
            int j =0;
            for(j = 0; j<i; j++){
                if(a[i] == a[j]){
                    break;
                }
            }
            if(i == j){
                ulike++;
            }
        }
        return ulike;
    }
    //Slutt på oppgave 3

    //Oppgave 4

    //Oppgave 8
    //funker nesten. sliter med tall med 2 siffre
    public static int[] indekssortering(int[] x) {

        //her opprettes hjelpelister
        int[] index_pos = new int[x.length];
        int[] y = x.clone();

        //her loopes det gjennom array y for å samle inn indexverdiene til elementene
        for (int i = 0; i < y.length; i++) {
            int min_value = y[i];
            int index = 0;

            //i denne loopen blir den innhentede indexverdien lagt inn i indexsortering arrayet
            for (int j = 0; j < index_pos.length; j++) {
                if (y[j] < min_value) {
                    min_value = y[j];
                    index = j;
                }
            }
            index_pos[i] = index;
            y[index] = Integer.MAX_VALUE;
        }
        return index_pos;
    }
    public static boolean nestePermutasjon(int[] a)
    {
        int i = a.length - 2;                    // i starter nest bakerst
        while (i >= 0 && a[i] > a[i + 1]) i--;   // går mot venstre
        if (i < 0) return false;                 // a = {n, n-1, . . . , 2, 1}

        int j = a.length - 1;                    // j starter bakerst
        while (a[j] < a[i]) j--;                 // stopper når a[j] > a[i]
        bytt(a,i,j); snu(a,i + 1);               // bytter og snur

        return true;                             // en ny permutasjon
    }

    public static void snu(int[] a, int v, int h)  // snur intervallet a[v:h]
    {
        while (v < h) bytt(a, v++, h--);
    }

    public static void snu(int[] a, int v)  // snur fra og med v og ut tabellen
    {
        snu(a, v, a.length - 1);
    }

    public static void snu(int[] a)  // snur hele tabellen
    {
        snu(a, 0, a.length - 1);
    }
    //Oppgave 9
    /*
    public static int[] tredjeMinst(int[] x){
        int tredje = x.length;
        if(tredje > 3){
            new java.util.NoSuchElementException("Arrayet er for lite");
        }

        //posisjonene til verdiene
        int minst_pos = 0;
        int nMinst_pos = 1;
        int tMinst_pos = 2;

        //bytter om posisjonen hvis x[1] er mindre enn x[0]
        if(x[1] < x[0]){
            minst_pos = 1;
            nMinst_pos = 0;
        }
        //bytter om posisjonen hvis x[2] er mindre enn x[0]
        if(x[2] < x[0]){
            minst_pos = 1;
            tMinst_pos = 0;
        }
        //bytter om posisjonen hvis x[3] er mindre enn x[1]
        if(x[2] < x[1]){
            tMinst_pos = 1;
            nMinst_pos = 2;
        }


        int minst_verdi = x[minst_pos];
        int nMinst_verdi = x[nMinst_pos];
        int tMinst_verdi = x[tMinst_pos];

        for(int i = 0; i < tredje; i++){

        }

        return tredje;
    }
    */
   }

