package trabalhandocompdf;

/**
 *
 * @author Vitor Ribeiro dos Santos
 */
public class Tempo {

    private String tempoExtenso = "";
    private int tempoNumeros = 0;

    public Tempo() {
        tempoExtenso = "";
        tempoNumeros = 0;
    }
    
    public Tempo(String tempoExtenso, int tempoNumeros) {
        this.tempoExtenso = tempoExtenso;
        this.tempoNumeros = tempoNumeros;
    }

    public String getTempoExtenso() {
        return tempoExtenso;
    }

    public void setTempoExtenso(String tempoExtenso) {
        this.tempoExtenso = tempoExtenso;
    }

    public int getTempoNumeros() {
        return tempoNumeros;
    }

    public void setTempoNumeros(int tempoNumeros) {
        this.tempoNumeros = tempoNumeros;
    }    
}
