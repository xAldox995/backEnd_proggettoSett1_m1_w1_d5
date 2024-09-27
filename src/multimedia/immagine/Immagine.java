package multimedia.immagine;

import multimedia.ElementoMultimediale;
import multimedia.Visualizzazione;

public class Immagine extends ElementoMultimediale implements Visualizzazione {
    protected int luminosita;

    public Immagine(String titolo, int luminosita) {
        super(titolo);
        this.luminosita = luminosita;
    }

    public String toString() {
        return "Immagine - " + super.toString() + ", Luminosità: " + luminosita;
    }

    public void abbassaLuminosita() {
        if (luminosita > 0) {
            luminosita--;
            System.out.println("Luminosità diminuita a " + luminosita);
        } else {
            System.out.println("La luminosità è già al minimo.");
        }
    }


    public void alzaLuminosita() {
        if (luminosita < 10) {
            luminosita++;
            System.out.println("Luminosità aumentata a " + luminosita);
        } else {
            System.out.println("La luminosità è già al massimo.");
        }
    }


    @Override
    public void show() {
        String output = titolo + " " + "*".repeat(luminosita);
        System.out.println(output);
    }
}
