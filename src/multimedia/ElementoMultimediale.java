package multimedia;

public abstract class ElementoMultimediale {
    protected String titolo;

    protected ElementoMultimediale(String titolo) {
        this.titolo = titolo;
    }

    public String getTitolo() {
        return titolo;
    }

    @Override
    public String toString() {
        return "Titolo: " + titolo;
    }

}
