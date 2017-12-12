import java.util.Hashtable;

import graphCode.*;

public class tcss543 {

	public static void main(String[] args) throws Exception{
		//String fileName = "/home/anirudh/eclipse-workspace/TCSS543/src/graphGenerationCode/Bipartite/g1.txt";
		//String fileName = "/home/anirudh/eclipse-workspace/TCSS543/src/graphGenerationCode/Bipartite/g2.txt";
		
		//String fileName = "/home/anirudh/eclipse-workspace/TCSS543/src/graphGenerationCode/FixedDegree/20v-3out-4min-355max.txt";
		//String fileName = "/home/anirudh/eclipse-workspace/TCSS543/src/graphGenerationCode/FixedDegree/100v-5out-25min-200max.txt";
		
		//String fileName = "/home/anirudh/eclipse-workspace/TCSS543/src/graphGenerationCode/Mesh/smallMesh.txt";
		//String fileName = "/home/anirudh/eclipse-workspace/TCSS543/src/graphGenerationCode/Mesh/mediumMesh.txt";
		
		//String fileName = "/home/anirudh/eclipse-workspace/TCSS543/src/graphGenerationCode/Random/n10-m10-cmin5-cmax10-f30.txt";
		//String fileName = "/home/anirudh/eclipse-workspace/TCSS543/src/graphGenerationCode/Random/n100-m100-cmin10-cmax20-f949.txt";
	//	String fileName = "C:\\Users\\Radhika AS\\workspace\\TCSS543\\F1_n20_m16_cmin1_cmax5.txt";
		
		SimpleGraph G = new SimpleGraph();
        GraphInput.LoadSimpleGraph(G, args[0]);
 /*       
        ScalingFordFulkerson scalingFordFulkerson = new ScalingFordFulkerson();
        double maxFlowVal = scalingFordFulkerson.calculateMaxFlow(G);
        System.out.println("MaxFlow for scaling: " + maxFlowVal);
*/        
		SimpleGraph newGraph = new SimpleGraph();
		Hashtable h= GraphInput.LoadSimpleGraph(newGraph, args[0]);
		SimpleGraph secondGraph = new SimpleGraph();
		Hashtable hSecond = GraphInput.LoadSimpleGraph(secondGraph, args[0]);
		FordFulkerson ff = new FordFulkerson();
		int b = ff.fordFulker(newGraph, secondGraph, h, hSecond);		
		System.out.println("max flow for FordFulkerson " + b);
		
		SimpleGraph newGraph2 = new SimpleGraph();
		Hashtable hPre= GraphInput.LoadSimpleGraph(newGraph2, args[0]);
		PreFlowPush p= new PreFlowPush(hPre);
        int maxFlow = p.computeMaxFlow();
        System.out.printf("Flow for the graph using Preflow Push: %d\n", maxFlow);
		
		SimpleGraph newGraph1 = new SimpleGraph();
		Hashtable ht= GraphInput.LoadSimpleGraph(newGraph1, args[0]);
		FordFulkersonT fft = new FordFulkersonT();
		double bt = fft.calculateMaxFlow(newGraph1);		
		System.out.println("max flow for FordFulkersonT " + bt);
		
		SimpleGraph graph = new SimpleGraph();
		Hashtable vertexEdgeMap = GraphInput.LoadSimpleGraph(graph, args[0]);

		FordFulkersonScaling fordFulkersonScaling = new FordFulkersonScaling();
		System.out.println("\nMax flow for FordFulkerson Scaling algorithm: " + fordFulkersonScaling.calculateMaxFlow(graph, vertexEdgeMap));
		
//		  System.out.println("MaxFlow for scaling: " + maxFlowVal);
		
		System.out.println("max flow for FordFulkerson " + b);
		
//		System.out.printf("Flow for the graph using Preflow Push: %d\n", maxFlow);
		
	}
}
