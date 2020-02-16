package sma.environnement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sma.ObjetATrier;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GrilleTest {
    Grille grille;

    @BeforeEach
    void setUp() {
        grille=new Grille(3,3);
    }

    @Test
    void getVoisinage() {
        ArrayList<Case> voisinage = grille.getVoisinage(3, 3, 1);

        assert (voisinage.contains(grille.getCase(3,3)));
        assert (voisinage.contains(grille.getCase(2,3)));
        assert (voisinage.contains(grille.getCase(4,3)));
        assert (voisinage.contains(grille.getCase(3,2)));
        assert (voisinage.contains(grille.getCase(3,4)));

        assert (! voisinage.contains(grille.getCase(4,4)));
        assert (! voisinage.contains(grille.getCase(1,1)));
        assert (! voisinage.contains(grille.getCase(2,2)));
    }

    @Test
    @DisplayName("Je suis ton ami :)")
    void getCase() {
        Case caseBase=grille.getCase(1,1);
        assertEquals(caseBase.x,1);
        assertEquals(caseBase.y,1);

        Case caseModulo=grille.getCase(4,4);
        assertEquals(caseModulo.x,1);
        assertEquals(caseModulo.y,1);

        Case caseNegative=grille.getCase(0,1);
        assertEquals(3,caseNegative.x);
        assertEquals(1,caseNegative.y);
    }


    @Test
    void countNumberOfSameTypeObjectAround() {
        grille.getCase(2,2).objetSurCase=new ObjetATrier('A');
        grille.getCase(1,2).objetSurCase=new ObjetATrier('A');
        grille.getCase(3,2).objetSurCase=new ObjetATrier('B');

        try {
            assertEquals (1,grille.countNumberOfSameTypeObjectAround(grille.getCase(2,2)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}