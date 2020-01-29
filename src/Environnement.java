import java.util.*;


class Environnement {
    private Grille grille;

    public Environnement(int m, int n) {
        this.grille=new Grille(n,m);
    }


    /**
     *  place les agents et instancie les objets à trier, chacun sur des cases differentes.
     * @param agents agents à placer
     * @param nA nombre d'objet A
     * @param nB nombre d'objet B
     */
    void initializePositionOfElements(List<Agent> agents, int nA, int nB) {
        ArrayList<Case> casesDisponibles=grille.getCases();
        Random random=new Random();
        for(Agent agent:agents){
            Case rdmCase=casesDisponibles.get(random.nextInt(casesDisponibles.size()));
            rdmCase.elementSurCase=agent;
            //TODO: sauvegarder x,y dans agent
            casesDisponibles.remove(rdmCase);
        }

        for(int i=0;i<nA;++i){
            Case rdmCase=casesDisponibles.get(random.nextInt(casesDisponibles.size()));
            rdmCase.elementSurCase=new ObjetATrier('A');
            casesDisponibles.remove(rdmCase);
        }
        for(int i=0;i<nB;++i){
            Case rdmCase=casesDisponibles.get(random.nextInt(casesDisponibles.size()));
            rdmCase.elementSurCase=new ObjetATrier('B');
            casesDisponibles.remove(rdmCase);
        }
    }




    synchronized void percevoir(Agent agent) {

    }



    synchronized private void printEnvironnement() {
//        System.out.println("*********************");
//        for (int i = 0; i < colonnes.size(); ++i) {
//            Stack<Agent> colonne = colonnes.get(i);
//            System.out.print("colonne " + (i + 1) + ": {");
//            for (Agent agentAtJ : colonne) {
//                System.out.print(agentAtJ.id + " ");
//            }
//            System.out.print("}\n");
//        }
//        System.out.println();
//        System.out.println();
    }

}
