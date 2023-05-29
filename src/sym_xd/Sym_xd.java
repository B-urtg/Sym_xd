package sym_xd;

import java.util.Scanner;

public class Sym_xd {

    public static void main(String[] args) {
        
        Symul symulacja = new Symul();
        Scanner input = new Scanner(System.in);
        

        System.out.println("Podaj rozmiar kwadratowej mapy X*X: ");
        int x = input.nextInt();
        
        System.out.println("Podaj ilosc obiektow kolejno human i zombie: ");
        int h = 0, z = 0;
        
        boolean validInput = false;
        while (!validInput) {
            h = input.nextInt();
            z = input.nextInt();
            
            if (h + z <= (x * x)) {
                validInput = true;
            } else {
                System.out.println("Suma obiektow (human + zombie) musi byc mniejsza lub równa liczbie pól na mapie. Sprobuj ponownie.");
            }
        }
        
        System.out.println();
        
        symulacja.Map(x,x);                                                     //przypisanie wielkosci mapy   
        symulacja.Objects(h,z);                                                 //przypisanie ilosci obiektow
        symulacja.Sym();                                                        //stworzenie obiektow
    }
    
}
