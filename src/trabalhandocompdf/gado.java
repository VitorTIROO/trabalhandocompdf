package trabalhandocompdf;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Gado {

    private long brinco;
    private String manejo;
    private String dtNasc;
    private String raca;
    private String dtInclusao;
    private Tempo diasInclusao;
    private String dtEmbarque;
    private String dtPesagem = "";
    private String sexo;
    private float peso;
    private long nunota;
    private String gta;
    private Local local;

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Gado() {
        this.brinco = 0;
        this.manejo = "0";
        this.dtNasc = "";
        this.raca = "";
        this.dtInclusao = "";
        this.diasInclusao = new Tempo();
        this.peso = 0;
        this.gta = "0";
        this.nunota = 0;
    }

    public Gado(long brinco, String manejo, String dtNasc, String raca, String dtInclusao, Tempo diasInclusao, String dtEmbarque,
            String dtPesagem, String sexo, float peso, long nunota, String gta) {
        this.brinco = brinco;
        this.manejo = manejo;
        this.dtNasc = dtNasc;
        this.raca = raca;
        this.dtInclusao = dtInclusao;
        this.diasInclusao = diasInclusao;
        this.dtEmbarque = dtEmbarque;
        this.dtPesagem = dtPesagem;
        this.sexo = sexo;
        this.peso = peso;
        this.nunota = nunota;
        this.gta = gta;
    }

    public long getBrinco() {
        return brinco;
    }

    public void setBrinco(long brinco) {
        this.brinco = brinco;
    }

    public String getManejo() {

        try {
            String brinco = (getBrinco() + "").trim();
            manejo = brinco.substring(8, 14);
            return manejo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pegar o Manejo.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return "";
    }

    public void setManejo(String manejo) {
        this.manejo = manejo;
    }

    public String getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(String dtNasc) {
        this.dtNasc = dtNasc;
    }

    public void setDtNasc(Date dtNasc) {
        this.dtNasc = sdf.format(dtNasc);
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getDtInclusao() {
        return dtInclusao;
    }

    public void setDtInclusao(String dtInclusao) {
        this.dtInclusao = dtInclusao;
    }

    public void setDtInclusao(Date dtInclusao) {
        this.dtInclusao = sdf.format(dtInclusao);
    }

    public Tempo getDiasInclusao() {
        return diasInclusao;
    }

    public void setDiasInclusao(Tempo diasInclusao) {
        this.diasInclusao = diasInclusao;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setPeso(String peso) throws NumberFormatException {
        this.peso = Float.parseFloat(peso);
    }

    public long getNunota() {
        return nunota;
    }

    public void setNunota(long nunota) {
        this.nunota = nunota;
    }

    public String getGta() {
        return gta;
    }

    public void setGta(String gta) {
        this.gta = gta;
    }

    public String getDtEmbarque() {
        return dtEmbarque;
    }

    public void setDtEmbarque(String dtEmbarque) {
        this.dtEmbarque = dtEmbarque;
    }

    public void setDtEmbarque(Date dtEmbarque) {
        this.dtEmbarque = sdf.format(dtEmbarque);
    }

    public String getDtPesagem() {
        return dtPesagem;
    }

    public void setDtPesagem(String dtPesagem) {
        this.dtPesagem = dtPesagem;
    }

    public void setDtPesagem(Date dtPesagem) {
        this.dtPesagem = sdf.format(dtPesagem);
    }

    public Local getLocal() {
        if (local == null) {
            local = new Local();
        }
        return local;
    }

    public void setLocal(Local local) {
        if (local == null) {
            this.local = new Local();
        } else {
            this.local = local;
        }

    }

}
