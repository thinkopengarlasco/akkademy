package MasterMindBase;
import MasterMindBase.Utils.*;
import MasterMindBase.Utils.CheckerMasterMind;
import MasterMindBase.Utils.CombinBase;

public class CombinationService {
    int[] valinseriti;
    int[] combinazione;
    int pn = 0;
    int nu = 0;
    boolean result;
    String combi = "";
    String vali = "";
    String PN ="";
    String N = "";

    public CombinationService(int[] valinseriti) {
        this.valinseriti = valinseriti;
    }

    public void create() {
        CombinBase combinBase = new CombinBase();
        combinazione = combinBase.create();
    }

    public void check() {
        CheckerMasterMind Check = new CheckerMasterMind(combinazione, valinseriti);
        Check.docheck();
        pn = Check.getpn();
        nu = Check.getn();
        this.result = Check.result();
        if(result == true)
            System.out.println("hai vinto");
        else
            System.out.println("hai perso");
    }

    public String getCombinazione(){
        for(int i = 0; i<3; i++) {
            combi += Integer.toString(combinazione[i]);
        }
        return combi;
    }
    public String getValinseriti(){
        for(int i = 0; i<3; i++) {
            vali += Integer.toString(valinseriti[i]);
        }
        return vali;
    }
    public boolean getresult() {
        return result;
    }
    public String getPn() {
        PN = Integer.toString(pn);
        return PN;
    }
    public String getN() {
        N = Integer.toString(nu);
        return N;
    }
    public void azzeravalori() {
        combi = "";
        vali = "";
        PN = "";
        N ="";
    }
}
