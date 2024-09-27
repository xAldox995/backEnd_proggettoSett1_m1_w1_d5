package multimedia.immagine;

import multimedia.ElementoMultimediale;
import multimedia.Visualizzazione;

public class Immagine extends ElementoMultimediale implements Visualizzazione {
    protected int luminosita;

    public Immagine(String titolo, int luminosita) {
        super(titolo);
        this.luminosita = luminosita;
    }

    void abbassaLuminosita () {
        if (luminosita > 1) {
            luminosita--;
        }
    }

    void alzaLuminosita() {
        if (luminosita < 10) {
            luminosita++;
        }
    }

    @Override
    public void show() {
        String output = titolo + " " + "*".repeat(luminosita);
        System.out.println(output);
    }
}
