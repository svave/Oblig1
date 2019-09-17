import java.util.Arrays;

public class main_tester {
    public static void main(String[]args){
        //Test på opppgave 1
        int[] a = {3,2,4,6,8,1,5};
        System.out.println(Oblig1.ombyttinger(a)+Arrays.toString(a));
        System.out.println(Arrays.toString(a));

        //slutt på oppgave 1


        //Test på oppgave 2

        //Test på oppgave 3
        int[] b = {3,2,4,6,8,1,5,5,5,5};
        //System.out.println("Antall : "+Oblig1.antallUlikeUSortert(a));


        //oppgave 4
        int[] delsort = {6,10,9,4,1,3,8,5,2,7};
        Oblig1.delsortering(delsort);
        System.out.println("Delsortert array "+Arrays.toString(delsort));

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
    }
}
