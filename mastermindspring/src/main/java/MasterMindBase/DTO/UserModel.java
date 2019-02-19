package MasterMindBase.DTO;

public class UserModel implements Comparable<UserModel>{
    int id;
    String nome;
    int pn;
    int n;
    int punteggio;

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public int punteggio() {
        punteggio = pn+(n/2);
        return punteggio;
    }

    @Override
    public int compareTo(UserModel u) {
        int resu;
        resu = punteggio- u.punteggio();
        return resu;
    }
}
