package MasterMindBase.Utils;

public class CheckerMasterMind implements Checker {
    int pn = 0;
    int n = 0;
    boolean b = true;
    boolean win = false;
    int[] numb;
    int[] val;
    public CheckerMasterMind(int[] numb, int[] val){
        this.numb = numb;
        this.val = val;
    }
    public void docheck(){
        for(int i = 0; i<3; i++) {
            for(int j = 0; j<3; j++) {
                if(j == i && val[j] == numb[i]) {
                    pn++;
                    b = false;
                } else if(j>0) {
                    if(b == true && val[j] == numb[i]) {
                        n++;
                        continue;
                    }
                }
            }
        }
    }
    public boolean result() {
        if(pn == 3)
        {
            win = true;
        }
        return win;
    }
    public int getpn() {
        return pn;
    }
    public int getn() {
        return n;
    }
}

