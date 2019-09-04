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
        if(a){
            throw new IllegalStateException("");
        } else {
            for(int i = 1; i<a.length; i++){
                if(i != a[i]){
                    antallForskjellig++;
                }else if(i == a[i]){
                    antallForskjellig++;
                }
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
                }
            }
        }

    }

}
