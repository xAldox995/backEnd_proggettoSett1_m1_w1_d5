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
            int tipoElemento = leggiIntero(in, "Scegli l'elemento (1=Audio, 2=Video, 3=Immagine): ", 1, 3);

            System.out.println("Inserisci il titolo: ");
            String titolo = in.nextLine();

            switch (tipoElemento) {
                //Case per audio
                case 1:
                    double durataAudio = leggiDouble(in, "Inserisci la durata in minuti (valore positivo): ");
                    int volumeAudio = leggiIntero(in, "Inserisci il volume (1-10): ", 1, 10);
                    playList[i] = new Audio(titolo, durataAudio, volumeAudio);
                    break;

                //Case per Video
                case 2:
                    double durataVideo = leggiDouble(in, "Inserisci la durata in minuti (valore positivo): ");
                    int volumeVideo = leggiIntero(in, "Inserisci il volume (1-10): ", 1, 10);
                    int luminositaVideo = leggiIntero(in, "Inserisci la luminosità (1-10): ", 1, 10);
                    playList[i] = new Video(titolo, durataVideo, volumeVideo, luminositaVideo);
                    break;

                //Case per Immagine
                case 3:
                    int luminositaImg = leggiIntero(in, "Inserisci la luminosità (1-10): ", 1, 10);
                    playList[i] = new Immagine(titolo, luminositaImg);
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
            System.out.println("\nMenu Principale:");
            System.out.println("1. Esegui un elemento");
            System.out.println("2. Modifica un elemento");
            System.out.println("0. Termina il programma");
            scelta = leggiIntero(in, "Scegli un'opzione: ", 0, 2);

            switch (scelta) {
                case 1:
                    eseguiElemento(in, playList);
                    break;
                case 2:
                    modificaElemento(in, playList);
                    break;
                case 0:
                    System.out.println("Programma terminato.");
                    break;
                default:
                    System.out.println("Scelta non valida. Riprovare.");
            }
        } while (scelta != 0);

        in.close();
    }

    private static void stampaListaElementi(ElementoMultimediale[] playList) {
        System.out.println("\nLista degli Elementi:");
        for (int i = 0; i < playList.length; i++) {
            ElementoMultimediale e = playList[i];
            System.out.println((i + 1) + ". " + e.toString());
        }
    }

    //Metodo che mi serve per idententificare se il dato del Vol e Lum rispetta tutti i criteri
    // NON DEVE ESSSERE NEGATIVO E NON DEVE ESSERE DEVIMALE
    private static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //Metodo che mi serve per idententificare se il dato della durata rispetta tutti i criteri
    // NON DEVE ESSSERE NEGATIVO E DEVE ESSERE DEVIMALE

    private static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //METODO PER CONTROLLARE SE IL VOLUME RIENTRA NEL RANGE 1-10 COL RELATIVO MESSAGGIO DI ERRORE

    private static int leggiIntero(Scanner sc, String text, int min, int max) {
        int value = 0;
        boolean validita = false;
        while (!validita) {
            System.out.println(text);
            String input = sc.nextLine();
            if (isInteger(input)) {
                value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    validita = true;
                } else {
                    System.out.println("Il valore deve essere tra " + min + " e " + max);
                }
            } else {
                System.out.println("Input non valido. Inserisci un numero intero");
            }
        }
        return value;
    }

    //METODO PER CONTROLLARE SE LA DURATA SIA UN DOUBLE OL RELATIVO MESSAGGIO DI ERRORE

    public static double leggiDouble(Scanner sc, String txt) {
        double value = 0;
        boolean validita = false;
        while (!validita) {
            System.out.println(txt);
            String input = sc.nextLine();
            if (isDouble(input)) {
                value = Double.parseDouble(input);
                if (value > 0) {
                    validita = true;
                } else {
                    System.out.println("Il valore deve essere positivo");
                }
            } else {
                System.out.println("Input non valido. Inserisci numero decimale");
            }
        }
        return value;
    }

    private static void eseguiElemento(Scanner in, ElementoMultimediale[] playList) {
        stampaListaElementi(playList);
        int indice = leggiIntero(in, "Quale elemento vuoi eseguire? (1-5): ", 1, 5);
        ElementoMultimediale e = playList[indice - 1];

        if (e instanceof Riprodicibile) {
            ((Riprodicibile) e).play();
        } else if (e instanceof Visualizzazione) {
            ((Visualizzazione) e).show();
        } else {
            System.out.println("Elemento non eseguibile.");
        }
    }

    // Metodo per modificare un elemento
    private static void modificaElemento(Scanner in, ElementoMultimediale[] playList) {
        stampaListaElementi(playList);
        int indice = leggiIntero(in, "Quale elemento vuoi modificare? (1-5): ", 1, 5);
        ElementoMultimediale e = playList[indice - 1];

        if (e instanceof Audio) {
            Audio audio = (Audio) e;
            modificaAudio(in, audio);
        } else if (e instanceof Video) {
            Video video = (Video) e;
            modificaVideo(in, video);
        } else if (e instanceof Immagine) {
            Immagine img = (Immagine) e;
            modificaImmagine(in, img);
        } else {
            System.out.println("Elemento non modificabile.");
        }
    }

    // Metodo per modificare un audio
    private static void modificaAudio(Scanner in, Audio audio) {
        int scelta;
        do {
            System.out.println("\nModifica Audio:");
            System.out.println("1. Alza volume");
            System.out.println("2. Abbassa volume");
            System.out.println("0. Torna al menu principale");
            scelta = leggiIntero(in, "Scegli un'opzione: ", 0, 2);

            switch (scelta) {
                case 1:
                    audio.aumentaVolume();
                    break;
                case 2:
                    audio.abbassaVolume();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Scelta non valida. Riprovare.");
            }
        } while (scelta != 0);
    }

    // Metodo per modificare un video
    private static void modificaVideo(Scanner in, Video video) {
        int scelta;
        do {
            System.out.println("\nModifica Video:");
            System.out.println("1. Alza volume");
            System.out.println("2. Abbassa volume");
            System.out.println("3. Aumenta luminosità");
            System.out.println("4. Diminuisci luminosità");
            System.out.println("0. Torna al menu principale");
            scelta = leggiIntero(in, "Scegli un'opzione: ", 0, 4);

            switch (scelta) {
                case 1:
                    video.aumentaVolume();
                    break;
                case 2:
                    video.aumentaVolume();
                    break;
                case 3:
                    video.alzaLuminosita();
                    break;
                case 4:
                    video.abbassaLuminosita();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Scelta non valida. Riprovare.");
            }
        } while (scelta != 0);
    }

    // Metodo per modificare un'immagine
    private static void modificaImmagine(Scanner in, Immagine img) {
        int scelta;
        do {
            System.out.println("\nModifica Immagine:");
            System.out.println("1. Aumenta luminosità");
            System.out.println("2. Diminuisci luminosità");
            System.out.println("0. Torna al menu principale");
            scelta = leggiIntero(in, "Scegli un'opzione: ", 0, 2);

            switch (scelta) {
                case 1:
                    img.alzaLuminosita();
                    break;
                case 2:
                    img.abbassaLuminosita();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Scelta non valida. Riprovare.");
            }
        } while (scelta != 0);
    }
}