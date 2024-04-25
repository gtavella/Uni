
package ordina.eccezioni;

public class EccezioneIndiceFuoriRange extends RuntimeException {
    public String toString() {
        return "L'indice non esiste";
    }
}
