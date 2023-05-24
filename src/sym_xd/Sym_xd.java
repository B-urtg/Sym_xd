package sym_xd;

import java.util.Scanner;

public class Sym_xd {

    public static void main(String[] args) {
        
        Symul symulacja = new Symul();
        Scanner input = new Scanner(System.in);
        
        System.out.println("Podaj rozmiar mapy koordynatami x, y: ");
        int x = 6/*input.nextInt()*/;
        int y = 6/*input.nextInt()*/;
        
        System.out.println("Podaj ilosc obiektow kolejno human i zombie: ");
        int h = 3/*input.nextInt()*/;
        int z = 3/*input.nextInt()*/;
        
        System.out.println();
        
        symulacja.Map(x,y);                                                     //przypisanie wielkosci mapy   
        symulacja.Objects(h,z);                                                 //przypisanie ilosci obiektow
        symulacja.Sym();                                                       //stworzenie obiektow
    }
    
}
