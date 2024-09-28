package multimedia.video;

import multimedia.ElementoMultimediale;
import multimedia.Riprodicibile;

public class Video extends ElementoMultimediale implements Riprodicibile {
    private double durata;
    private int volume;
    protected int luminosita;


    public Video(String titolo, double durata, int luminosita, int volume) {
        super(titolo);
        this.durata = durata;
        this.luminosita = luminosita;
        this.volume = volume;
    }

    public String toString() {
        return "Video - " + super.toString() + ", Durata: " + durata + " min, Volume: " + volume + ", Luminosità: " + luminosita;
    }

    public void abbassaVolume() {
        if (volume > 0) {
            volume--;
            System.out.println("Volume diminuito a " + volume);
        } else {
            System.out.println("Il volume è già al minimo.");
        }
    }

    public void aumentaVolume() {
        if (volume < 10) {
            volume++;
            System.out.println("Volume aumentato a " + volume);
        } else {
            System.out.println("Il volume è già al massimo.");
        }

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
    public void play() {
        for (int i = 0; i < durata; i++) {
            String output = titolo + " " + "!".repeat(volume) + " " + "*".repeat(luminosita);
            System.out.println("Minuto " + (i + 1) + ": " + output);
        }
        System.out.println("Riproduzione video terminata. Durata totale: " + durata + " minuti.");
    }
}
