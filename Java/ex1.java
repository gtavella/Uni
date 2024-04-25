import java.util.Arrays;

public class pratica2 {
    // reverse an array
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6,7,8,9};
        int l = A.length;
        int l_half=l/2;
        System.out.println(Arrays.toString(A));
        for(int i=0; i<l_half; i++) {
            int t=A[i];
            A[i]=A[l-i-1];
            A[l-i-1]=t;
        }
        System.out.println(Arrays.toString(A));
    }
}
