package it.corsojava.mastermind.models;

public class CombinationModel {

    private int id;
    private int[] pcCombination;
    private String timeStamp;

    public CombinationModel() {
        pcCombination  = new int[3];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getPcCombination() {
        return pcCombination;
    }

    public void setPcCombination(int[] pcCombination) {
        this.pcCombination = pcCombination;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

}
