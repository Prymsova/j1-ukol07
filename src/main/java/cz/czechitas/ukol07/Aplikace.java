package cz.czechitas.ukol07;

import java.io.IOException;
import java.util.List;

/**
 * Spouštěcí třída aplikace
 */
public class Aplikace {
    public static void main(String[] args) {
        new Aplikace().run();
    }

    public void run() {
        KnihaSluzba knihaSluzba = new KnihaSluzba();

        final int pocetKnih = knihaSluzba.getSeznamKnih().size();
        System.out.println("počet knih: " + pocetKnih);

        final List<Kniha> knihyCapek = knihaSluzba.getSeznamKnihAutora("Karel Čapek");
        System.out.println("knihy od Čapka:");
        for( Kniha kniha : knihyCapek) {
            System.out.println(kniha.getNazev());
        }

        final List<Kniha> knihyRoku = knihaSluzba.getSeznamKnihRoku(1845);
        System.out.println("knihy z roku 1845: ");
        for( Kniha kniha : knihyRoku ) {
            System.out.println(kniha.getAutor() + ": " + kniha.getNazev());
        }


    }
}
