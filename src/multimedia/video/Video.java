package multimedia.video;

import multimedia.audio.Audio;

public class Video extends Audio  {
    protected int luminosita;

    public Video(String titolo, double durata, int volume, int luminosita) {
        super(titolo, durata, volume);
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
    public void play() {
        for (int i = 0; i < durata; i++) {
            String output = titolo + " " + "!".repeat(volume) + " " + "*".repeat(luminosita);
            System.out.println("Minuto " + (i + 1) + ": " + output);
        }
        System.out.println("Riproduzione video terminata. Durata totale: " + durata + " minuti.");
    }
}
