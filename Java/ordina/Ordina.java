package ordina;


import java.util.ArrayList;
import ordina.eccezioni.*;



public class Ordina {

    // ordina un ArrayList
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        addRandom(A,10,10);
        System.out.println("originale:   "+A);
        System.out.println("ordina:      "+ordina(A));
    }


    public static void addRandom(ArrayList<Integer> A, int limit, int amount) {
        int i = 0;
        while(i<amount) {
            int x = (int) (Math.random()*limit);
            A.add(x);
            i++;
        }
    }


    public static int min(ArrayList<Integer> A) {
        if(A.isEmpty()) throw new EccezioneListaVuota();
        if(A.size()==1) return A.getFirst();
        ArrayList<Integer> tail = sublist(A, 1, A.size());
        int currMin = A.getFirst();
        int nextMin = min(tail);
        if (currMin<nextMin) return currMin;
        return nextMin;
    }

    // get a sublist recursive
    public static ArrayList<Integer> sublist(ArrayList<Integer> A, int fromIndex, int toIndex) {
        if(fromIndex==toIndex) return new ArrayList<>();
        ArrayList<Integer> ret = new ArrayList<>();
        ret.add(A.get(fromIndex));
        ret.addAll(sublist(A, fromIndex+1, toIndex));
        return ret;
    }

    // get a sublist iterative
//    public static ArrayList<Integer> sublist(ArrayList<Integer> A, int fromIndex, int toIndex) {
//        ArrayList<Integer> ret = new ArrayList<>();
//        int i = fromIndex;
//        while(i<toIndex) {
//            ret.add(A.get(i));
//            i++;
//        }
//        return ret;
//    }


    public static ArrayList<Integer> ordina(ArrayList<Integer> A) {
        ArrayList<Integer> Acopy = new ArrayList<>(A);
        return ordinaDa(Acopy);
    }


    private static ArrayList<Integer> ordinaDa(ArrayList<Integer> A) {
        int i = 0;
        int size = A.size();
        while (i<size-1) {
            ArrayList<Integer> Aright = sublist(A, i, size);
            int smallest = min(Aright);
            int iSmallest = i+Aright.indexOf(smallest);
            if(i!=iSmallest) {
                swap(A,i,iSmallest);
            }
            i++;
        }
        return A;
    }


    private static void swap(ArrayList<Integer> A, int i, int j) {
        int a = A.get(i);
        int b = A.get(j);
        A.set(i,b);
        A.set(j,a);
    }

}
