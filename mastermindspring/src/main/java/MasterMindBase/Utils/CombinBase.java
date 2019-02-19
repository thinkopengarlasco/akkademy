package MasterMindBase.Utils;

public class CombinBase {
    int[] combinazione = new int[3];

    public int[] create(){
        System.out.println(" ");
        for(int i = 0; i<3; i++) {
            combinazione[i] = (int)(Math.random()*10);
            System.out.print(combinazione[i]+ " ");
        }
        return combinazione;
    }
}
