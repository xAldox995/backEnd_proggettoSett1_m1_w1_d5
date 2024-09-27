package multimedia.audio;

import multimedia.ElementoMultimediale;
import multimedia.Riprodicibile;

public class Audio extends ElementoMultimediale implements Riprodicibile {
    protected double durata;
    protected int volume;

    public Audio(String titolo, double durata, int volume) {
        super(titolo);
        this.durata = durata;
        this.volume = volume;
    }

    public void abbassaVolume() {
        if (volume > 1) {
            volume--;
        }

    }

    public void aumentaVolume() {
        if (volume < 10) {
            volume++;
        }
    }

    @Override
    public void play() {
        for (int i = 0; i < durata; i++) {
            System.out.println("Minuto " + (i + 1) + ": " + titolo + " " + "!".repeat(volume));
        }
        System.out.println("Riproduzione audio terminata. Durata totale: " + durata + " minuti.");
    }
}
