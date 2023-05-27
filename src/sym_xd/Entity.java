package sym_xd;

public class Entity implements Point{
    
    protected int x;
    protected int y;
    protected int pwr = (int)Math.floor(Math.random() * (100) + 1);
    protected int ID_class;
    protected int ID; 
    protected SuperHuman superh;
    protected SuperZombie superz;
    
    @Override
    public void coordinates(int a, int b){
        this.x = a;
        this.y = b;
    }
    
    protected int x_cord(){
        return this.x;

    }
    
    protected int y_cord(){
        return this.y;
    }
    
    protected void ID_class(int a){
        this.ID_class = a;
    }

    protected void team_up(int a, int b, int c, int d, int e, int f){
        if (e==0)
        {
            SuperHuman superhuman = new SuperHuman();
            Point position_superhuman = superhuman;
            position_superhuman.coordinates(a,b);
            superhuman.ID_class = 2;
            superhuman.pwr = c + d;
            superhuman.ID = f;
            this.superh = superhuman;
        }
        if (e==1)
        {
            SuperZombie superzombie = new SuperZombie();
            Point position_superzombie = superzombie;
            position_superzombie.coordinates(a,b);
            superzombie.ID_class = 3;
            superzombie.pwr = c + d;
            superzombie.ID = f;
            this.superz = superzombie;
        }
    }

}

