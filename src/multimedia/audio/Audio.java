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
            System.out.println("Volume abbassato :" + volume);
        } else {
            System.out.println("Il volume è al minimo");
        }

    }

   public void aumentaVolume () {
        if (volume < 10) {
            volume ++;
            System.out.println("Volume aumentato a:" + volume);
        } else {
            System.out.println("il volume è al massimo");
        }
    }

    @Override
    public void play() {
        for (int i = 0; i < durata; i++) {
            System.out.println(titolo + " " + "!".repeat(volume));
        }
    }
}
