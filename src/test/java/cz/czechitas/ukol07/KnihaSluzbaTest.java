package cz.czechitas.ukol07;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KnihaSluzbaTest {
    private KnihaSluzba knihaSluzba;

    @BeforeEach
    void setUp() {
        knihaSluzba = new KnihaSluzba();
    }

    @Test
    void testGetSeznamKnih() {
        assertEquals(14, knihaSluzba.getSeznamKnih().size());
    }

    @Test
    void testSeznamKnihAutora() {
        assertEquals(0, knihaSluzba.getSeznamKnihAutora("Karel Hynek Mácha").size());
        assertEquals(5, knihaSluzba.getSeznamKnihAutora("Karel Čapek").size());
    }

    @Test
    void testSeznamKnihRoku() {
        assertEquals(0, knihaSluzba.getSeznamKnihRoku(1999).size());
        assertEquals(2, knihaSluzba.getSeznamKnihRoku(1845).size());
        assertEquals(1, knihaSluzba.getSeznamKnihRoku(1855).size());
        assertEquals("Babička",
                knihaSluzba.getSeznamKnihRoku(1855).stream().map(Kniha::getNazev).toList().getFirst());
    }

}