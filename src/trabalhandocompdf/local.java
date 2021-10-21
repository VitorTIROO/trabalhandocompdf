package trabalhandocompdf;

/**
 *
 * @author Vitor Ribeiro dos Santos
 */
public class Local {

    private Long codLocal;
    private String descricao;

    public Local() {
        codLocal = new Long(0);
    }
    
    public Local(Local local) {
        codLocal = local.getCodLocal();
        descricao = local.getDescricao();
    }

    public Local(Long codLocal, String descricao) {
        this.codLocal = codLocal;
        this.descricao = descricao;
    }

    public Long getCodLocal() {
        return codLocal;
    }

    public void setCodLocal(Long codLocal) {
        this.codLocal = codLocal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
