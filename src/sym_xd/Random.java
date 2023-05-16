package sym_xd;

public class Random {
    
    protected int random;
    
    protected void los(int r) {
        int a = 1;
        int b = r;
        this.random = (int)Math.floor(Math.random() * (b - a + 1) + a);
    }
    
}
