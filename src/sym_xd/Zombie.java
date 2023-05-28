package sym_xd;

public class Zombie extends Entity{
    
    int infect_chance = (int)Math.floor(Math.random() * (100) + 1);;
    
    protected void ID(int a){
        this.ID = a;
    }
    @Override protected void infect(){
        pwr+=2;
    }
    
    
    @Override
    protected int Infect_chance(){
        return this.infect_chance;
    }
}
