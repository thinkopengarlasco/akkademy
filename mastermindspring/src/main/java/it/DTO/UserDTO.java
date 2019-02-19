package it.DTO;


import it.services.utils.ToComparator;

public class UserDTO implements Comparable<UserDTO>, ToComparator {

    private int ID;
    private String nome;
    private int punteggio;

    public UserDTO() {

    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public int compareTo(UserDTO dto) {
        //return Integer.parseInt(String.valueOf(this.punteggio))-Integer.parseInt(String.valueOf(dto.punteggio));
        return dto.punteggio - this.punteggio;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "ID=" + ID +
                ", nome='" + nome + '\'' +
                ", punteggio=" + punteggio +
                '}';
    }
}
