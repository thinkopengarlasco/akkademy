package it.DTO;


import it.services.utils.ToComparator;

public class TentativoDTO implements Comparable<TentativoDTO>, ToComparator {
    private int IDComb;
    private String user;
    private int posEsatta;
    private int numEsatto;
    private String soluzione;
    private String input;
    private int nTentativi;

    public void setIDComb(int IDComb) {
        this.IDComb = IDComb;
    }

    public int getIDComb() {
        return IDComb;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getPosEsatta() {
        return posEsatta;
    }

    public void setPosEsatta(int posEsatta) {
        this.posEsatta = posEsatta;
    }

    public int getNumEsatto() {
        return numEsatto;
    }

    public void setNumEsatto(int numEsatto) {
        this.numEsatto = numEsatto;
    }

    public String getSoluzione() {
        return soluzione;
    }

    public void setSoluzione(String soluzione) {
        this.soluzione = soluzione;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public int getnTentativi() {
        return nTentativi;
    }

    public void setnTentativi(int nTentativi) {
        this.nTentativi = nTentativi;
    }

    @Override
    public int getID() {
        return this.IDComb;
    }

    @Override
    public int compareTo(TentativoDTO dto) {
        return this.nTentativi - nTentativi;
    }

    @Override
    public String toString() {
        return "TentativoDTO{" +
                "IDComb=" + IDComb +
                ", user='" + user + '\'' +
                ", posEsatta=" + posEsatta +
                ", numEsatto=" + numEsatto +
                ", soluzione='" + soluzione + '\'' +
                ", input='" + input + '\'' +
                ", nTentativi=" + nTentativi +
                '}';
    }
}
