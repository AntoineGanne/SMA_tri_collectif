package sma.environnement;

import sma.ElementPhysique;

import java.util.ArrayList;
import java.util.Arrays;

public class Grille {
    private int n,m;

    public ArrayList<Case> getCases() {
        ArrayList<Case> cases = new ArrayList<Case>(m*n);
        for(int x=0;x<m;++x){
            cases.addAll(Arrays.asList(this.cases[x]).subList(0, n));
        }
        return cases;
    }

    private Case[][] cases;

    public Grille(int n, int m) {
        this.n = n;
        this.m = m;
        cases=new Case[m][n];
        for(int x=0;x<m;++x){
            for(int y=0;y<n;++y){
                cases[x][y]=new Case(x+1,y+1);
            }
        }
    }

    public ArrayList getVoisinage(int x, int y, int rayonPerception) {
        ArrayList<Case> neighbors = new ArrayList<Case>();

        for (int xx = -rayonPerception; xx <= rayonPerception; xx++) {
            for (int yy = -rayonPerception; yy <= rayonPerception; yy++) {
                int xModulo = x + xx % m;
                int yModulo = y + yy % n;
                neighbors.add(new Case(xModulo, yModulo));
            }
        }
        return neighbors;
    }

    public Case getCase(int x, int y){
        return cases[x][y];
    }


    public void print(){

        //TODO: gestion des agents
        System.out.println("grille:");
        for(int x=0;x<m;++x){
            for(int y=0;y<n;++y){
                ElementPhysique elmt = cases[x][y].objetSurCase;
                if (elmt == null) {
                    System.out.print(". ");
                } else {
                    System.out.print(elmt.getRepresentation() + " ");
                }
                System.out.print(" ");
            }
            System.out.println();
        }

        System.out.println();
    }


}
