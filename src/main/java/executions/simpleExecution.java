package executions;


import javafx.util.Pair;
import logger.BatchLogger;
import sma.Systeme;

import java.util.ArrayList;

public class simpleExecution {
    public static void main(String[] args){
        simpleExecution simpleExecution =new simpleExecution("./resultats/simple_execution.txt");
        try {
            simpleExecution.execute("nombre moyen d'objets similiaires proches selon le nombre d'agents et le nombre d'itérations");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    BatchLogger batchLogger;

    // nombre de test pris pour faire une moyenne
    private final int NB_MEAN=3;

    int m=50;
    int n=50;
    int nbObjetA=200;
    int nbObjetB=200;
    int nbIterations=10000;

    int nbAgents=64;

    public simpleExecution(String filePath) {
        batchLogger =new BatchLogger(filePath);
    }

    public void execute (String testName) throws Exception {
        batchLogger.writeLine(testName);

        batchLogger.writeLine(new String[]{"taille grille", m+"*"+n,"nb objet A", String.valueOf(nbObjetA),"nb objet B", String.valueOf(nbObjetB),"nb agents", String.valueOf(nbAgents)});
        batchLogger.writeLine(new String[]{"itération","nb moyen de voisins similaire","ration objet isolé"});
        ArrayList<String> line;


        Systeme systeme=new Systeme(nbAgents,nbObjetA,nbObjetB,m,n);
        System.out.println("état initial");
        systeme.printGrille();
        line=new ArrayList<>();
        line.add(String.valueOf(0));
        log_mesure_tri(line, systeme);

        for(int iteration =1;iteration<=nbIterations;++iteration){
            systeme.faireUneIteration();
            if(iteration%1000==0){
                System.out.println("iteration:" + iteration);
                systeme.printGrille();

                line=new ArrayList<>();
                line.add(String.valueOf(iteration));
                log_mesure_tri(line, systeme);
            }
        }
    }

    private void log_mesure_tri(ArrayList<String> line, Systeme systeme) {
        Pair<Double, Double> qualiteTri = systeme.mesurerTri();
        Double nombreMoyenDeVoisins=qualiteTri.getValue();
        line.add(String.valueOf(nombreMoyenDeVoisins));
        Double ratioObjetsIsole = qualiteTri.getKey();
        line.add(String.valueOf(ratioObjetsIsole));
        batchLogger.writeLine(line);


        System.out.println("nb moyen de voisin de même type:"+String.format( "%.2f", nombreMoyenDeVoisins ));
        System.out.println("ratio d'objets isolés:"+String.format( "%.2f", ratioObjetsIsole ));
        System.out.println("***************************");
    }
}
