package ricorsione.eccezioni;

public class EccezioneListaVuota extends RuntimeException {
    public String toString() {
        return "La lista non puo' essere vuota";
    }
}
