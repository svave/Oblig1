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

        //Test på Oppgave 8
        int[] x = {6,10,16,11,7,12,3,9,8,5};
        int[] index = Oblig1.indekssortering(x);
        System.out.println("Array x : " + Arrays.toString(x));
        System.out.println("Array med indekssortering : " + Arrays.toString(index));
        for(int i = 0; i < x.length; i++){
            System.out.println(x[index[i]] + " ");
        }

        //Oppgave 9

        System.out.println("Array med de tre minste indexene : " + Arrays.toString(Oblig1.tredjeMinst(x)));

        int[] test = {12,32,4,15,2,34,56};
        System.out.println("TEST : " + Arrays.toString(Oblig1.test(test)));
    }
}
