package utec.ia.test;

import fr.uga.pddl4j.planners.statespace.GSP;

public class ObtenerPlanes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GSP gsp1 = new GSP();
		String argum1[] = {"..\\test_funcionamiento\\logistics.pddl", 
				           "..\\test_funcionamiento\\problem.pddl"};  // Por defecto tiene la estrategia de búsqueda ASTAR
		
		String argum2[] = {"..\\test_funcionamiento\\logistics.pddl", 
                           "..\\test_funcionamiento\\problem.pddl",
                           "-e","AJUSTED_SUM"}; //FAST_FORWARD    AJUSTED_SUM
		String argum3[] = {"..\\test_funcionamiento\\logistics.pddl", 
                           "..\\test_funcionamiento\\problem.pddl",
                          "-e","FAST_FORWARD",
                          "-s", "DEPTH_FIRST"}; //DEPTH_FIRST  ASTAR
		gsp1.main(argum3);

	}

}
