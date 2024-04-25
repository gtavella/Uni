package ricorsione;

import ricorsione.eccezioni.*;

import javax.swing.*;
import java.util.*;


/** INVARIANTI *****
 *  1) tutti i metodi ritornano sempre una nuova linked list
 *  2) tutti i metodi e operazioni con gli indici, vengono effettuate nel sequente modo:
 *     l'indice iniziale e' incluso, l'indice finale e' escluso (come da standard)
 */



public class LLRecursiveOperations {

    // ******COPIA (da e fino)********
    public static LinkedList<Integer> copia(LinkedList<Integer> LL) {
        if(LL.isEmpty()) throw new EccezioneListaVuota();
        return copiaDa(LL.listIterator());
    }

    private static LinkedList<Integer> copiaDa(ListIterator<Integer> it) {
           if(!it.hasNext()) return new LinkedList<>();
           LinkedList<Integer> LLhead  = new LinkedList<>();
           LLhead.add(it.next());  // aggiungo la testa, cioe' l'elemento attuale
           LinkedList<Integer> LLtail  = new LinkedList<>(copiaDa(it)); // la coda e' tutto quello che non e' la testa
           LinkedList<Integer> LL      = new LinkedList<>(); // finale
           LL.addAll(LLhead);
           LL.addAll(LLtail);
           return LL;
    }
    private static LinkedList<Integer> copiaDa(LinkedList<Integer> LL, int i) {
        return copiaDa(LL.listIterator(i));
    }

    public static LinkedList<Integer> copiaFino(LinkedList<Integer> LL, int i) {
        if(LL.isEmpty()) throw new EccezioneListaVuota();
        if(i>LL.size()) throw new EccezioneIndiceFuoriRange();
        LinkedList<Integer> LL_vuota = new LinkedList<>();
        return copiaFinoA(LL_vuota, LL.listIterator(), i);
    }
    private static LinkedList<Integer> copiaFinoA(LinkedList<Integer> LL, ListIterator<Integer> it, int i) {
        LL.add(it.next());
        if(i==1) return LL;
        return copiaFinoA(LL, it, i-1);
    }


    //********INVERTI********
    public static LinkedList<Integer> inverti(LinkedList<Integer> LL) {
        if(LL.isEmpty()) throw new EccezioneListaVuota();
        return invertiDa(LL.listIterator());
    }
    public static LinkedList<Integer> invertiDa(ListIterator<Integer> it) {
        if(!it.hasNext()) return new LinkedList<>();
        LinkedList<Integer> LLhead  = new LinkedList<>();
        LLhead.add(it.next());  // aggiungo la testa, cioe' l'elemento attuale
        LinkedList<Integer> LLtail  = new LinkedList<>(invertiDa(it)); // la coda e' tutto quello che non e' la testa
        LinkedList<Integer> ret     = new LinkedList<>();
        ret.addAll(LLtail);
        ret.addAll(LLhead);
        return ret;
    }


    //******SOMMA*****
    public static int somma(LinkedList<Integer> LL)  {
        if(LL.isEmpty()) throw new EccezioneListaVuota();
        return sommaDa(LL.listIterator());
    }
    private static int sommaDa(ListIterator<Integer> it) {
        if(!it.hasNext()) return 0;
        return it.next() + sommaDa(it);
    }


    //******MAX*****
    public static int max(LinkedList<Integer> LL) {
        if(LL.isEmpty()) throw new EccezioneListaVuota();
        return maxDa(LL.listIterator());
    }
    public static int maxDa(ListIterator<Integer> it) {
        if(!it.hasNext()) return Integer.MIN_VALUE;  // cioe' ogni massimo sara' sempre piu' grande del numero piu' piccolo
        int currMax = it.next();
        int tailMax = maxDa(it);
        if(currMax>tailMax) return currMax;
        return tailMax;
    }


    //******MIN*****
    public static int min(LinkedList<Integer> LL) {
        if(LL.isEmpty()) throw new EccezioneListaVuota();
        return minDa(LL.listIterator());
    }
    public static int minDa(ListIterator<Integer> it) {
        if(!it.hasNext()) return Integer.MAX_VALUE;  // cioe' ogni minimo sara' sempre piu' piccolo del numero piu' grande
        int currMin = it.next();
        int tailMin = minDa(it);
        if(currMin<tailMin) return currMin;
        return tailMin;
    }
    public static int minDa(LinkedList<Integer> LL, int i) {
        return minDa(LL.listIterator(i));
    }


    //******RIMUOVI********
    public static LinkedList<Integer> rimuovi(LinkedList<Integer> LL, int i) {
        if(LL.isEmpty()) throw new EccezioneListaVuota();
        if(i>LL.size()) throw new EccezioneIndiceFuoriRange();
        LinkedList<Integer> LL_sx   = LLRecursiveOperations.copiaFino(LL,i);
        LinkedList<Integer> LL_dx   = LLRecursiveOperations.copiaDa(LL,i+1);
        LinkedList<Integer> ret     = new LinkedList<>();
        ret.addAll(LL_sx);
        ret.addAll(LL_dx);
        return ret;
    }


    //******ORDINA****** YOU SHOULD IMPLEMENT SWAP ELEMENTS
//    public static LinkedList<Integer> ordina(LinkedList<Integer> LL) {
//        if(LL.isEmpty()) throw new EccezioneListaVuota();
//        LinkedList<Integer> ret = new LinkedList<>();
//        return ordinaDa(LL, ret, 0);
//    }
//    public static LinkedList<Integer> ordinaDa(LinkedList<Integer> LL, LinkedList<Integer> ret, int i) {
//        if(i>LL.size()) throw new EccezioneIndiceFuoriRange();
//        // aggiungi il minimo tra la testa e la coda
//        System.out.println(ret);
//        int currMin              = LLRecursiveOperations.minDa(LL,i);
//        LinkedList<Integer> tail = LLRecursiveOperations.rimuovi(LL,0);
//        int nextMin              = LLRecursiveOperations.min(tail);
//        if(currMin<nextMin) {
//            ret.add(currMin);
//        }
//        else {
//            ret.add(nextMin);
//        }
//        return ordinaDa(tail,ret,i+1);
//    }



}
