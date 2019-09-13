import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DelSortTest {

    @org.junit.jupiter.api.Test
    void delsortering(){
        int[] a = {6,10,9,4,1,3,8,5,1,7};
        Oblig1.delsortering(a);
        System.out.println(Arrays.toString(a));
    }
}