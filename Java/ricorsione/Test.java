
package ricorsione;// qui utilizzo e testo se funzionano le classi


import java.util.LinkedList;


public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> LL = new LinkedList<>();
//        LL.add(-3);
//        LL.add(-2);
//        LL.add(-1);
        LL.add(0);
        LL.add(1);
        LL.add(2);
        LL.add(3);
        LL.add(4);
        LL.add(5);
        LL.add(6);
        LL.add(7);

        // operazioni
        LinkedList<Integer> LL_copia      = LLRecursiveOperations.copia(LL);
        LinkedList<Integer> LL_inverti    = LLRecursiveOperations.inverti(LL);
        int LL_somma                      = LLRecursiveOperations.somma(LL);
        int LL_max                        = LLRecursiveOperations.max(LL);
        int LL_min                        = LLRecursiveOperations.min(LL);
        LinkedList<Integer> LL_rimuovi    = LLRecursiveOperations.rimuovi(LL,7);
        LinkedList<Integer> LL_copiaFino  = LLRecursiveOperations.copiaFino(LL,8);
//        LinkedList<Integer> LL_ordina     = LLRecursiveOperations.ordina(LL);


        // stampa
        System.out.println("originale:    " + LL);
        System.out.println("copia:        " + LL_copia);
        System.out.println("inverti:      " + LL_inverti);
        System.out.println("somma:        " + LL_somma);
        System.out.println("max:          " + LL_max);
        System.out.println("min:          " + LL_min);
        System.out.println("rimuovi:      " + LL_rimuovi);
        System.out.println("copia fino:   " + LL_copiaFino);
//        System.out.println("ordina:       " + LL_ordina);



    }
}
