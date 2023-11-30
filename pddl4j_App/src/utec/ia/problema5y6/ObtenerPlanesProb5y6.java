package utec.ia.problema5y6;

import fr.uga.pddl4j.planners.statespace.FF;
import fr.uga.pddl4j.planners.statespace.GSP;

public class ObtenerPlanesProb5y6 {
	static void execProblema5_1_barman()  {
		GSP gsp1 = new GSP();
		String argum1[] = {"..\\Problema5y6\\barman\\domain.pddl", 
				           "..\\Problema5y6\\barman\\p435.2.pddl"};  // Por defecto tiene la estrategia de búsqueda ASTAR
		                                                             // Pero se cuelga
		
		// Falla con ASTAR, Heuristica AJUSTE_SUM
		String argum2[] = {"..\\Problema5y6\\barman\\domain.pddl", 
				           "..\\Problema5y6\\barman\\p435.2.pddl",
                           "-e","AJUSTED_SUM", //FAST_FORWARD    AJUSTED_SUM
                           "-t","30"};  // en segundos
		
		// Falla con ASTAR, Heuristica FAST_FORWARD
		String argum3[] = {"..\\Problema5y6\\barman\\domain.pddl", 
				           "..\\Problema5y6\\barman\\p435.2.pddl",
                          "-e","FAST_FORWARD",
                          "-t","30"};  // en segundos
                          //     "-s", "DEPTH_FIRST"}; //DEPTH_FIRST  ASTAR   Estrategia
		gsp1.main(argum2);
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		execProblema5_1_barman();  
	}

}
