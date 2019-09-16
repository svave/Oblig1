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
        sortertKontroll(a);
        if(!(sortertKontroll(a))){
            throw new IllegalStateException("The array is not sorted and can therefore not be run");
        } else if(a.length == 0){
            return 0;
        }else if(a.length == 1){
            antallForskjellig++;
            return antallForskjellig;
        }
        else {
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
    public static boolean sortertKontroll(int[] a){
        int lengde = a.length;
            for(int i = lengde; i>1; i--){
                int max_tall = maks(a);
                if(!(max_tall == i-1)){
                    bytt(a, max_tall, i-1);
                    return true;
                }
            }
        return false;
    }
    //Slutt på oppgave 2


    //Start på oppgave 3
    public static int antallUlikeUsortert(int[] a){
        int antallForskjellig =0;
        if(a.length == 0){
            return 0;
        }else if(a.length == 1){
            antallForskjellig++;
            return antallForskjellig;
        }
        else {
            for(int i = 1; i<a.length; i++){
                for(int j = 0; j<i; j++){
                    if(a[i] == a[j]){
                        break;
                    }
                    if(i == j){
                        antallForskjellig++;
                    }
                }
            }
        }
        return antallForskjellig;
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
