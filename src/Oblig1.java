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
    //v.5 working with test!!
    public static int maks(int[] a){
        if(a.length == 0){
            throw new NoSuchElementException("Array :"+a+" can not be empty");
        } else{
        for(int i = 0; i<a.length-1; i++){
                if(a[i] > a[i+1]){
                    bytt(a, i,i+1);
                }
            }
        }
            return a[a.length-1]; //Returnere siste tallet
        }

    public static void bytt(int[] a, int i, int j)
    {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }
    //Fungerende ombyttinger!!! passerer test
    public static int ombyttinger(int[] a){
        int antallOmbyttinger =0;
        if(a.length == 0){
            throw new NoSuchElementException("Array :"+a+" can not be empty");
        } else {
            for (int i= 0; i < a.length-1; i++) {
                    if (a[i] > a[i+1]) {
                        bytt(a, i, i+1);
                        antallOmbyttinger++;
                    }
                }
            }
        return antallOmbyttinger;
        }
    //Slutt på oppgave 1

    //Oppgave 2
    public static int antallUlikeSortert(int[] a){
        int antallForskjellig = 0;
        if(!(sortertKontroll(a))){
            throw new IllegalStateException("The array is not sorted and can thus not be run");
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

    public static int størst(int[] a)
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
    public static int antallUlikeUsortert(int[] a){
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

    //Oppgave4
    public static void delsortering(int[] a) {
    }

    //Oppgave 7 i plenum
    public static String flett(String s, String t){
        //Finner lengden på korteste stringen
        int lengde = Math.min(s.length(), t.length());
        String ut = "";
        StringBuilder sb = new StringBuilder();

        if(lengde == 0 ){
            ut += " ";
            return ut;
        }else if(s.length() == 0 && t.length()>1 || s.length()>1 && t.length() == 0){
            sb.append(s.substring(lengde)).append(t.substring(lengde));
        }

        for(int i =0; i< lengde; i++){
            sb.append(s.charAt(i)).append(t.charAt(i));
        }
        sb.append(s.substring(lengde)).append(t.substring(lengde));
        return sb.toString();
    }
    //Oppgave 7.b
    public static String flett(String[] s){
        String ut = "";
        int lengde = s.length;
        String karakter = s[0];

        StringBuilder sb = new StringBuilder();
        for(int i =0; i<lengde; i++){
            sb.append(s[i].charAt(i));
            karakter = s[i];
        }
        return karakter;
    }
    //Oppgave 8
    //funker nesten. sliter med tall med 2 siffre
    public static int[] indekssortering(int[] x) {

        //her opprettes hjelpelister
        int[] index_pos = new int[x.length];
        int[] y = x.clone();

        if(y.length < 0){
            new java.util.NoSuchElementException("Arrayet er tomt");
        }

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
    //Oppgave 9

    public static int[] tredjeMinst(int[] x){
        int[] tredjeMinst = new int[3];
        for(int k = 0; k < x.length; k++) {
            //variabler for å lagre posisjonene
            int minst_pos = 0;
            int nMinst_pos = 1;
            int tMinst_pos = 2;

            //variabler for å lagre elementenes verdier
            int minst_verdi = x[0];
            int nMinst_verdi = x[1];
            int tMinst_verdi = x[2];

            for (int i = 0; i < tredjeMinst.length; i++) {
                if (x[i] < minst_verdi) {
                    minst_verdi = x[i];
                    minst_pos = i;
                } else if (x[i] < tMinst_verdi && x[i] > minst_verdi) {
                    nMinst_verdi = x[i];
                    nMinst_pos = i;
                } else if (x[i] < nMinst_verdi && x[i] < minst_verdi) {
                    tMinst_verdi = x[i];
                    tMinst_pos = i;
                }
            }
            tredjeMinst[0] = minst_pos;
            tredjeMinst[1] = nMinst_pos;
            tredjeMinst[2] = tMinst_pos;

        }
        return tredjeMinst;
    }
    public static int[] test(int[] x){
        if(x.length < 3){
            throw new java.util.NoSuchElementException("For kort array");
        }
        //Posisjonene til minste og nest minste verdi

        int min_pos = 0;
        int nMin_pos = 1;
        int tMin_pos = 2;

        if(x[1] < x[0]){
            nMin_pos = 0;
            min_pos = 1;
        }

        //Verdiene til minste og nest minste elemtent
        int min_val = x[min_pos];
        int nMin_val = x[nMin_pos];
        int tMin_val = x[tMin_pos];

        for(int i = 0; i < x.length; i++){
            if(x[i] < nMin_val){
                if(x[i] < min_val){
                    //Ny nest minst
                    nMin_pos = min_pos;
                    nMin_val = min_val;

                    //Ny minst
                    min_pos = i;
                    min_val = x[min_pos];
                } else {
                    //Ny nest minst
                    nMin_pos = i;
                    nMin_val = x[min_pos];
                }
            }
        }
        //////
        if(x[2] < x[1]){
            tMin_pos = 1;
            nMin_pos = 2;
        }
        for(int k = 2; k < x.length; k++){
            if(x[k] < tMin_val){
                if(x[k] < nMin_val){
                    //Ny tredje minst
                    tMin_pos = nMin_pos;
                    tMin_val = nMin_val;

                    //Ny nest minst
                    nMin_pos = k;
                    nMin_val = x[nMin_pos];
                } else {
                    //Ny tredje minst
                    tMin_pos = k;
                    tMin_val = x[nMin_pos];
                }
            }
        }

        return new int[]{min_pos,nMin_pos,tMin_pos};
    }
    //Oppgave 10 felles
    public static boolean inneholdt(String a, String b){
        if(b.contains(a)){
            return true;
        } else {
            return false;
        }
        /* Muligens riktig
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        Arrays.sort(charsA);
        Arrays.sort(charsB);
        return Arrays.equals(charsA,charsB);
        * */
    }

}
