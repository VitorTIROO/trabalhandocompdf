package trabalhandocompdf;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vitor Ribeiro dos Santos
 */
public class GadoDAO {

    private List<Gado> listaGados = null;

    public GadoDAO() {
        listaGados = new ArrayList();
    }

    public List<Gado> getListaGados() {
        return listaGados;
    }

    public void setListaGados(List<Gado> listaGados) {
        this.listaGados = listaGados;
    }

    public void limparLista() {
        listaGados.clear();
        listaGados = null;
    }

    public int size() {
        if (listaGados != null) {
            return listaGados.size();
        }
        return 0;
    }

    public Gado gadoPosX(int pos) {
        if (!listaGados.isEmpty()) {
            return listaGados.get(pos);
        }
        return null;
    }
}
