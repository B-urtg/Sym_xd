package sym_xd;

public class Human extends Entity{
    
    private int resources;
    
    private void scavenge(){
      resources+=1;
      if(resources>=3){
          pwr+=1;
          resources-=3;
        }
      }
    
    public Human() {
        this.resources = 0;
    }
    
    protected void ID(int a){
        this.ID = a;
    }
}
