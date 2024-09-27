import multimedia.ElementoMultimediale;
import multimedia.Riprodicibile;
import multimedia.Visualizzazione;
import multimedia.audio.Audio;
import multimedia.immagine.Immagine;
import multimedia.video.Video;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ElementoMultimediale[] playList = new ElementoMultimediale[5];

        Scanner in = new Scanner(System.in);

        //Creazione della playlist

        for (int i = 0; i < 5; i++) {
            System.out.println("Crezione del Brano " + (i + 1));
            System.out.println("Scegli l'elemento da dichiarate (1=Audio, 2=Video, 3=Immagine)");
            int tipoElemento = Integer.parseInt(in.nextLine());

            System.out.println("Inserisci il titolo: ");
            String titolo = in.nextLine();

            switch (tipoElemento) {
                //Case per audio
                case 1:
                    System.out.println("Inserisci la durata: ");
                    double durataAudio = Double.parseDouble(in.nextLine());

                    System.out.println("Inserisci il volume (1-10)");
                    int volumeAudio = Integer.parseInt(in.nextLine());

                    playList[i] = new Audio(titolo, durataAudio, volumeAudio);
                    break;

                //Case per Video
                case 2:
                    System.out.println("Inserisci la durata: ");
                    double durataVideo = Double.parseDouble(in.nextLine());

                    System.out.println("Inserisci il volume (1-10)");
                    int volumeVideo = Integer.parseInt(in.nextLine());

                    System.out.println("Inserisci la luminosità (1-10)");
                    int luminositaVideo = Integer.parseInt(in.nextLine());

                    playList[i] = new Video(titolo, durataVideo, volumeVideo, luminositaVideo);
                    break;

                //Case per Immagine
                case 3:
                    System.out.println("Inserisci luminosita (1-10): ");
                    int luminositaImg = Integer.parseInt(in.nextLine());
                    playList[i] = new Immagine(titolo,luminositaImg);
                    break;

                default:
                    System.out.println("Tipo non valido. Riprovare");
                    i--;
                    break;
            }
        }
//Menu per la riproduzione
        int scelta;
        do {
            System.out.println("Quale elemento voui eseguire? (1-5, 0 se voui terminare): ");
            scelta = Integer.parseInt(in.nextLine());

            if (scelta > 0 && scelta <= 5){
                ElementoMultimediale e = playList[scelta - 1];

                if (e instanceof Riprodicibile){
                    ((Riprodicibile)e).play();
                } else if (e instanceof Visualizzazione) {
                    ((Visualizzazione)e).show();
                } else {
                    System.out.println("Elemento non eseguibile. ");
                }
            } else if (scelta != 0) {
                System.out.println("Scelta non Valida. Riprovare");
            }
        } while (scelta !=0 );

        in.close();
    }
}