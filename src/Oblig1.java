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

    public static int antallUlikeSortert(int[] a) {
        int antallForskjellig = 0;
        //Sjekker lengde på array
        if (a.length == 0) {
            return antallForskjellig;
        } else {
            boolean funnet = false;

            int test;

            antallForskjellig++;

            boolean sorter = false;

            //sjekker om array a er sortert
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    sorter = false; //Det er bevist array ikke er sortert.
                    throw new IllegalStateException("The array is not sorted and can therefore not be run");
                } else {
                    sorter = true;
                }
            }
            if (sorter) {
                for (int j = 0; j < a.length-1; j++) {
                    if (a[j] != a[j+1]) {
                        test = a[j+1];

                        //Må lage sjekk om j har kommet før
                        if(a[j] == test){
                            funnet = true;

                        }
                        if(!funnet){
                            antallForskjellig++;
                        }
                    }
                }
            }
            return antallForskjellig;
        }
    }
    //Slutt på oppgave 2


    //Start på oppgave 3
    public static int antallUlikeUsortert(int[] a){
        int antallForskjellig = 0;

        //Sjekker lengde på array
        if (a.length == 0) {
            return antallForskjellig;
        } else {
            boolean funnet;
            antallForskjellig++;

                for (int j = 1; j < a.length; j++) {
                        funnet = false;
                        //Må lage sjekk om j har kommet før
                        for(int i = 0; i < j; i++){
                            if(a[j] == a[i]){
                                funnet = true;
                            }
                        }
                        if(!funnet){
                            antallForskjellig++;
                        }
                    }
                }
        return antallForskjellig;
    }

    //Slutt på oppgave 3

    //Oppgave4
    public static void delsortering(int[] a){
        //oppretter noen hjelpevar for aloritmen vår
        int i=0; //partall
        int j= a.length-1; //oddetall
        int mid = 0;

        if (a.length == 0) { //hvis tom da returnerer den
            return;
        }

        while(i<j){ //looper gjennom
            while((i<=j) && a[i]%2!=0 && i<a.length){
                i++;
                mid++;
            }
            while((i<=j) && a[j]%2==0){
                j--;
            }
            if(i<j){
                int temp = a[i]; //bytter eller swapper par med odd slik at odd forekommer først.
                a[i] = a[j];
                a[j] = temp;
            }
        }
        Arrays.sort(a,0,mid); //bruker java mekanisme til å sortere
        Arrays.sort(a,mid,a.length);
    }

    //oppgave 5
    public static void rotasjon(char[] a){
        int d = 1;
        if(a.length<2){ // sjekker hvis er tom eller en verdi
            return;
        }
        if((d %= a.length)<0){
            d += a.length;
        }
        char[] copy = Arrays.copyOfRange(a,a.length-d,a.length);//lager hjelpetabell
        for(int i=a.length-1; i>=d; --i){
            a[i] = a[i-d];
        }
        System.arraycopy(copy,0,a,0,d); //kopieringen
    }

    //oppgave 6
    public static void rotasjon(char[] a, int k){
        while(k<0){
            if (a.length<2) { // sjekker hvis er tom eller en verdi
                return;
            }
            if ((k %= a.length)<0)
                k += a.length;

            char[] copy = Arrays.copyOfRange(a, 0, a.length-k);//lager hjelpetabell
            for (int i=0; i<k; ++i) {
                a[i] = a[i + a.length-k];
            }
            System.arraycopy(copy, 0, a, k, a.length-k); //kopieringen
        }
        if(k>=0){
            if (a.length < 2){ // sjekker hvis er tom eller en verdi
                return;
            }
            if ((k %= a.length) < 0) {
                k += a.length;
            }
            char[] copy = Arrays.copyOfRange(a, a.length - k, a.length);//lager hjelpetabell
            for (int i = a.length - 1; i >= k; --i) {
                a[i] = a[i - k];
            }
            System.arraycopy(copy, 0, a, 0, k); //kopieringen
        }
    }


    //Oppgave 7 i plenum
    public static String flett(String s, String t){
        //Finner lengden på korteste stringen
        int lengde = Math.min(s.length(), t.length());
        String ut = "";
        StringBuilder sb = new StringBuilder();

        for(int i =0; i< lengde; i++){
            sb.append(s.charAt(i)).append(t.charAt(i));
        }
        sb.append(s.substring(lengde)).append(t.substring(lengde));
        return sb.toString();
    }
    //Oppgave 7.b
    public static String flett(String... s){
       String ut = "";
       //Finner størte ord
        int max_lengde = 0;
        for(int k = 0; k<s.length; k++){
            if(s[k].length() > max_lengde){
                max_lengde = s[k].length();
            }
        }
        for(int j = 0; j<max_lengde; j++){
            for(int i =0; i<s.length; i++){
                if(s[i].length() <= j){
                    continue;
                }
                ut += s[i].charAt(j);
          }
        }return ut;

    }

    //Oppgave 8
    public static int[] indekssortering(int[] x) {

        //her opprettes hjelpelister
        int[] index_pos = new int[x.length];
        int[] y = x.clone();

        //her loopes det gjennom array y for å samle inn indexverdiene til elementene
        for (int i = 0; i < y.length; i++) {
            int min_value = y[i];
            int index = i;

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

    public static int[] tredjeMin(int[] x){
        if(x.length < 3){
            throw new java.util.NoSuchElementException("For kort array");
        }
        int[] temp_index;
        int[] temp = new int[3];
        System.arraycopy(x,0,temp,0,3);
        temp_index = Oblig1.indekssortering(temp);

        //Posisjonene til minste, nest og tredje minste verdi

        int min_pos = temp_index[0];
        int nMin_pos = temp_index[1];
        int tMin_pos = temp_index[2];


        //Verdiene til minste, nest og tredje minste elemtent
        int min_val = x[min_pos];
        int nMin_val = x[nMin_pos];
        int tMin_val = x[tMin_pos];

        if(x.length == 3){
            return temp_index;
        }

        for(int i = 3; i < x.length; i++){
            if (x[i] < min_val) {
                //Ny tredje minst
                tMin_pos = nMin_pos;
                tMin_val = nMin_val;

                //Ny nest minst
                nMin_pos = min_pos;
                nMin_val = min_val;

                //Ny minst
                min_pos = i;
                min_val = x[i];
            } else if(x[i] < nMin_val) {
                //Ny tredje minst
                tMin_pos = nMin_pos;
                tMin_val = nMin_val;

                //Ny nest minst
                nMin_pos = i;
                nMin_val = x[i];
            } else if(x[i] < tMin_val){
                tMin_pos = i;
                tMin_val = x[i];
            }
        }
        temp_index[0] = min_pos;
        temp_index[1] = nMin_pos;
        temp_index[2] = tMin_pos;
        return temp_index;
    }



    //Oppgave 10 felles
    public static boolean inneholdt(String a, String b){
      //  quickSort(a, 0, a.length());



        return false;
    }
    private static void quickSort(String[] a, int start, int slutt){
        int i = start;
        int j = slutt;

        String[] tempArray;
     //   tempArray = a


        //Sjekker bare strnger som er større eller lik 1 karakterer i
        if(j-i >= 1){
            String pivot = a[i];

            while(j>i){
                while(a[i].compareTo(pivot) <=0 && i < slutt && j > i){
                    i++;
                }

                while(a[j].compareTo(pivot) >= 0 && j > start && j >= i){
                    j--;
                }

                if(j > i){
                    byttString(a, i, j);
                }
            }
            byttString(a, start, j);
            quickSort(a, start, j-1);
            quickSort(a, j+1, slutt);
        }
    }
    public static void byttString(String[] a, int i, int j)
    {
        String temp = a[i]; a[i] = a[j]; a[j] = temp;
    }


}
