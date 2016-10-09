package __ArrayReferenceTest;

import java.util.Arrays;

/**
 * Created by Dawei on 10/5/2016.
 */
public class At {
    int[] value;

    public At(int v[]) {
        this.value = v;
    }

    public int[] getValue() {
        return value;
    }
    public static void main(String[] args) {
        int as[] = {1, 4, 5, 6};
        At at = new At(as);
        System.out.println(Arrays.toString(as));
        as[1] = 100;
        System.out.println(Arrays.toString(as));
    }
}
