package sym_xd;

import java.util.ArrayList;
import java.util.Arrays;

public class Symul {
    
    protected int h;
    protected int z;
    protected int s_h;
    protected int s_z;
    protected int x;
    protected int y;
    
    Random variable = new Random();
    SuperHuman superhum = new SuperHuman();
    SuperZombie superzom = new SuperZombie();
    
    protected void Map(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    protected void Objects(int h, int z){
        this.h = h;
        this.z = z;
    }
    
    protected void Sym(){
        
        ArrayList<Entity> Objects = new ArrayList<>();
        
        String map[][] = new String [y][x];                                     
        for (String[] row : map)
        {
            Arrays.fill(row, " ");   
        }
        
        for (int i=0; i<x; i++){                                                
            System.out.print((i + 1) + " ");
            for (int j=0; j<y; j++){
                System.out.print("[" + map[i][j] + "] ");
            }
            System.out.println();
        }        
        System.out.print("   ");
        for (int i=0; i<y; i++){
            System.out.print((i+1) + "   ");
        }
        
        System.out.println();
        System.out.println();
               
        for (int i=0; i<h; i++) {                                               
            Human human = new Human();
            Point position_human = human;
            position_human.coordinates(1, 1);
            human.ID_class(0);
            human.ID((i+1));
            Objects.add(human);
        }
        
        for (int i=0; i<z; i++) {                                               
            Zombie zombie = new Zombie();
            Point position_zombie = zombie;
            position_zombie.coordinates((x), (y));
            zombie.ID_class(1);
            zombie.ID((i+1));
            Objects.add(zombie);
        }
        
        for (int i=0; i<(h+z); i++){
            if (Objects.get(i).ID_class == 0)
            {
                System.out.println("Obiekt human, ID klasy = " + Objects.get(i).ID_class);
            }
            if (Objects.get(i).ID_class == 1)
            {
                System.out.println("Obiekt zombie, ID klasy = " + Objects.get(i).ID_class);
            }
            System.out.println("Koordynaty obiektu - x: " + Objects.get(i).x_cord() + ", y: " + Objects.get(i).y_cord());
            System.out.println("ID obiektu - " + Objects.get(i).ID);
            System.out.println("Sila obiektu - " + Objects.get(i).pwr);
            System.out.println();

        }
        
        for (int t=0; t<4; t++)
        {
            
            for (String[] row : map)
            {
                Arrays.fill(row, " ");   
            }
            
            System.out.println("Tura " + (t+1));
            System.out.println();
            
            for (int i=0; i<(h+z+s_h+s_z); i++)
            {
                variable.los(x-1);
                int new_x = variable.random;
                
                variable.los(y-1);
                int new_y = variable.random;
                
                if (Objects.get(i).ID_class == 0 || Objects.get(i).ID_class == 2)
                {
                    variable.los(100);
                    int scavenge_chance = variable.random;
                    if (scavenge_chance > 75)
                    {
                        //Objects.get(i).
                        new_x = Objects.get(i).x_cord();
                        new_y = Objects.get(i).y_cord();
                        if (Objects.get(i).ID_class == 0)
                        {
                            map[new_x-1][new_y-1] = "h";
                        }
                        
                        if (Objects.get(i).ID_class == 2)
                        {
                            map[new_x-1][new_y-1] = "H";
                        }
                    }
                    else
                    {
                        Objects.get(i).coordinates(new_y, new_x);
                        
                        if (Objects.get(i).ID_class == 0)
                        {
                            map[new_x-1][new_y-1] = "h";
                        }
                        
                        if (Objects.get(i).ID_class == 2)
                        {
                            map[new_x-1][new_y-1] = "H";
                        }
                    }
                }
                
                Objects.get(i).coordinates(new_y, new_x);
                
                if (Objects.get(i).ID_class == 1)
                {
                    map[new_x-1][new_y-1] = "z";
                }

                if (Objects.get(i).ID_class == 3)
                {
                    map[new_x-1][new_y-1] = "Z";
                }
            }
            
            for (int i=0; i<(h+z+s_h+s_z); i++)
            {
                if (Objects.get(i).ID_class == 0)
                {
                    System.out.println("Obiekt human " + Objects.get(i).ID + ", koordynaty - x: " + Objects.get(i).x_cord() + ", y: " + Objects.get(i).y_cord());
                    //System.out.println("Ilosc zasobow - " + Objects.get(i).resources);
                    System.out.println("Sila obiektu - " + Objects.get(i).pwr);
                    System.out.println();
                }
                
                if (Objects.get(i).ID_class == 1)
                {
                    System.out.println("Obiekt zombie " + Objects.get(i).ID + ", koordynaty - x: " + Objects.get(i).x_cord() + ", y: " + Objects.get(i).y_cord());
                    System.out.println("Sila obiektu - " + Objects.get(i).pwr);
                    System.out.println();
                }
                
                if (Objects.get(i).ID_class == 2)
                {
                    System.out.println("Obiekt super human " + Objects.get(i).ID + ", koordynaty - x: " + Objects.get(i).x_cord() + ", y: " + Objects.get(i).y_cord());
                    System.out.println("Sila obiektu - " + Objects.get(i).pwr);
                    System.out.println();
                }
                
                if (Objects.get(i).ID_class == 3)
                {
                    System.out.println("Obiekt super zombie " + Objects.get(i).ID + ", koordynaty - x: " + Objects.get(i).x_cord() + ", y: " + Objects.get(i).y_cord());
                    System.out.println("Sila obiektu - " + Objects.get(i).pwr);
                    System.out.println();
                }
            }
            
            for (int i=0; i<(h+z+s_h+s_z); i++)                                 //system teamupowania
            {
                int pom = 0;
                for (int j=(i+1); j<(h+z+s_h+s_z); j++)
                {
                    if (Objects.get(i).x_cord() == Objects.get(j).x_cord())
                    {
                        if (Objects.get(i).x_cord() == Objects.get(j).x_cord())
                        {
                            if (Objects.get(i).ID_class == 0 || Objects.get(i).ID_class == 1)
                            {
                                if (Objects.get(i).ID_class == Objects.get(j).ID_class)
                                {
                                    if (Objects.get(i).ID_class == 0)
                                    {
                                        pom = 1;
                                        if (s_h != 0){
                                            for (int k=0; k<(s_h); k++)
                                            {
                                                pom = pom++;
                                            }
                                        }
                                    }
                                    else
                                    {
                                        if (Objects.get(i).ID_class == 1)
                                        {
                                            pom = 1;
                                            if (s_z != 0){
                                                for (int k=0; k<(s_z); k++)
                                                {
                                                    pom = pom++;
                                                }
                                            }
                                        }
                                    }
                                    
                                    if (Objects.get(i).ID_class == 0)
                                    {
                                        superhum.team_up(Objects.get(i).x_cord(), Objects.get(i).y_cord(), Objects.get(i).pwr, Objects.get(j).pwr, Objects.get(i).ID_class, pom);
                                        SuperHuman superhuman;
                                        superhuman = superhum.superh;
                                        Objects.set(i, superhuman);
                                        map[Objects.get(i).x_cord()][Objects.get(i).y_cord()] = "H";
                                        Objects.remove(j);
                                        h = h - 2;
                                        s_h = s_h +1;
                                        break;
                                    }
                                    else
                                    {
                                        superzom.team_up(Objects.get(i).x_cord(), Objects.get(i).y_cord(), Objects.get(i).pwr, Objects.get(j).pwr, Objects.get(i).ID_class, pom);
                                        SuperZombie superzombie;
                                        superzombie = superzom.superz;
                                        Objects.set(i, superzombie);
                                        map[Objects.get(i).x_cord()][Objects.get(i).y_cord()] = "Z";
                                        Objects.remove(j);
                                        z = z - 2;
                                        s_z = s_z +1;
                                        break;
                                    }
                                }   
                            }
                        }  
                    }
                }
            }
/*            
            for (int i=0; i<(h+z+s_h+s_z); i++)                                 //system walki
            {
                for (int j=(i+1); j<(h+z+s_h+s_z); j++)
                {
                    if (Objects.get(i).x_cord() == Objects.get(j).x_cord())
                    {
                        if (Objects.get(i).x_cord() == Objects.get(j).x_cord())
                        {
                            if (Objects.get(i).ID_class != Objects.get(j).ID_class)
                            {
                                //fight
                            }
                        }  
                    }
                }
            }
*/            
            for (int i=0; i<x; i++){                                                
            System.out.print((i + 1) + " ");
            for (int j=0; j<y; j++){
                System.out.print("[" + map[i][j] + "] ");
            }
            System.out.println();
            }        
            System.out.print("   ");
            for (int i=0; i<y; i++){
                System.out.print((i+1) + "   ");
            }
            
            System.out.println();
            System.out.println();
        }
                
    }
    
}
