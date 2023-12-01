package utec.ia.problema5y6;

import java.util.Calendar;

import fr.uga.pddl4j.planners.statespace.FF;
import fr.uga.pddl4j.planners.statespace.GSP;

public class ObtenerPlanesProb5y6 {
	static void execProblema5_1_barman()  {
		String path = "..\\Problema5y6\\barman\\";
		String files_d1 = "domain.pddl";
		String files_p1[] = {"p435.2.pddl", "p536.2.pddl","p638.2.pddl","p739.2.pddl"}; 
		GSP gsp1 = new GSP();
		GSP gsp2 = new GSP();
		FF ff1 = new FF();
		
		for(int i = 0; i < files_p1.length; i++) {
			System.out.println("=============================================================================");
			System.out.println("Archivo de dominio  : "+ files_d1);
			System.out.println("Archivo de problema : "+ files_p1[i]);
			System.out.println("=============================================================================");
			System.out.println("búsqueda progresiva A* utilizando dos heurísticas de grafo de planeamiento");
			System.out.println("---------------------------Heuristica AJUSTED_SUM---------------------------");
			String argum1[] = {path + files_d1, 
					           path + files_p1[i],
	                           "-e","AJUSTED_SUM", //FAST_FORWARD    AJUSTED_SUM
	                           "-t","150"};  // en segundos
			gsp1.main(argum1);
			System.out.println("---------------------------Heuristica FAST_FORWARD---------------------------");
			String argum2[] = {path + files_d1, 
			                   path + files_p1[i],
	                          "-e","FAST_FORWARD",
	                          "-t","150"};  // en segundos
	                          //     "-s", "DEPTH_FIRST"}; //DEPTH_FIRST  ASTAR   Estrategia
			gsp2.main(argum2);
			
			System.out.println("---------------------------Heuristica FAST_FORWARD (FF)---------------------------");
			String argum3[] = {path + files_d1, 
			                   path + files_p1[i],
			                   "-t","150"};  // en segundos
			ff1.main(argum3);
		}
	}
	

	static void execProblema5_1_airport()  {
		String path = "..\\Problema5y6\\airport\\";
		String files_d1 = "domain.pddl";
		String files_p1[] = {"p01-airport1-p1.pddl", "p02-airport1-p1.pddl","p03-airport1-p2.pddl","p04-airport2-p1.pddl"}; 
		GSP gsp1 = new GSP();
		GSP gsp2 = new GSP();
		FF ff1 = new FF();
		
		for(int i = 0; i < files_p1.length; i++) {
			System.out.println("=============================================================================");
			System.out.println("Archivo de dominio  : "+ files_d1);
			System.out.println("Archivo de problema : "+ files_p1[i]);
			System.out.println("=============================================================================");
			System.out.println("búsqueda progresiva A* utilizando dos heurísticas de grafo de planeamiento");
			System.out.println("---------------------------Heuristica AJUSTED_SUM2---------------------------");
			String argum1[] = {path + files_d1, 
					           path + files_p1[i],
	                           "-e","AJUSTED_SUM2", //FAST_FORWARD    AJUSTED_SUM AJUSTED_SUM2 
	                           "-t","150"};  // en segundos
			gsp1.main(argum1);
			System.out.println("---------------------------Heuristica AJUSTED_SUM ---------------------------");
			String argum2[] = {path + files_d1, 
			                   path + files_p1[i],
	                          "-e","AJUSTED_SUM",  // AJUSTED_SUM2M MAX DEPTH_FIRST
	                          "-t","150"};  // en segundos
	                          //     "-s", "DEPTH_FIRST"}; //DEPTH_FIRST  ASTAR   Estrategia
			gsp2.main(argum2);
			
			System.out.println("---------------------------Heuristica FAST_FORWARD (FF)---------------------------");
			String argum3[] = {path + files_d1, 
			                   path + files_p1[i],
			                   //"-w","2.0",   // poniendo peso 
			                   "-t","150"};  // en segundos
			ff1.main(argum3);
		}
	}	

	public static void main(String[] args) {
		long t1, t2, dif;
		Calendar antes = Calendar.getInstance();
		t1 = antes.getTimeInMillis();

		//execProblema5_1_barman();  // barman 
		execProblema5_1_airport(); // airport
		
		Calendar despues = Calendar.getInstance();
		t2 = despues.getTimeInMillis();
		
		dif = t2 - t1;
		System.out.println("Tiempo total en segundos, caso objetivos originales para airport : " + (double)dif/1000);
	}

}
