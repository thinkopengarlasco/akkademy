package MasterMindBase.DTO;



public class TentativiModel implements Comparable<TentativiModel>{
    String username;
    String codicebase;
    String codiceinserito;
    int n;
    int pn;
    boolean result;
    int punteggio;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setCodicebase(String codicebase) {
        this.codicebase = codicebase;
    }

    public String getCodicebase() {
        return codicebase;
    }

    public void setCodiceinserito(String codiceinserito) {
        this.codiceinserito = codiceinserito;
    }

    public String getCodiceinserito() {
        return codiceinserito;
    }

    public int getPn() {
        return pn;
    }

    public void setPn(int pn) {
        this.pn = pn;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public boolean isResult() {
        return result;
    }
    public int punteggio() {
        punteggio = pn+(n/2);
        return punteggio;
    }

    @Override
    public int compareTo(TentativiModel u) {
        int resu;
        resu = punteggio- u.punteggio();
        return resu;
    }
}
