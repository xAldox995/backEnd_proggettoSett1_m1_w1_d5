import multimedia.audio.Audio;

public class Main {
    public static void main(String[] args) {

        Audio a1 = new Audio("Numb",2.32,5);

        a1.play();
        a1.abbassaVolume();
        a1.play();
        a1.aumentaVolume();
        a1.play();
    }
}