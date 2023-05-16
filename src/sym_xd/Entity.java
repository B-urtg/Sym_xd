package sym_xd;

public class Entity implements Point{
    
    protected int x;
    protected int y;
    protected int pwr = (int)Math.floor(Math.random() * (10) + 1);
    protected int ID_class;
    protected int ID;   
    
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
    
    //cykpyk
}

