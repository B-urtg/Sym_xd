package sym_xd;

import java.util.Scanner;

public class Sym_xd {

    public static void main(String[] args) {
        
        Symul symulacja = new Symul();
        Scanner input = new Scanner(System.in);
        
        System.out.println("Podaj rozmiar mapy");
        int x = input.nextInt();
        int y = x;
        
        System.out.println("Podaj ilosc obiektow kolejno human i zombie: ");
        int h = 0, z = 0;
        
        boolean validInput = false;
        while (!validInput) {
            h = input.nextInt();
            z = input.nextInt();
            
            if (h + z <= x * y) {
                validInput = true;
            } else {
                System.out.println("Suma obiektów (human + zombie) musi być mniejsza lub równa iloczynowi x i y. Spróbuj ponownie.");
            }
        }
        
        System.out.println();
        
        symulacja.Map(x,y);                                                     //przypisanie wielkosci mapy   
        symulacja.Objects(h,z);                                                 //przypisanie ilosci obiektow
        symulacja.Sym();                                                       //stworzenie obiektow
    }
    
}
