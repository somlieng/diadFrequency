import java.io.File;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Graph {

	private int Vcnt, Ecnt; // number of vertices and edges 
	
	private boolean adj[][];
	private int weight[][];
	public Vertex points[];
	
	DiadFrequency freqTable;
	File file; //file of characters to be read
	
	/*
	 * Graph will be undirected because using the the order of the keys doesn't matter
	 * as long as it is the same two keys
	 */
	
	public Graph(int numVerticies, String effy)
		{
			freqTable = new DiadFrequency(effy);
			
			Vcnt = numVerticies;
			
			adj = new boolean [Vcnt][Vcnt];//are they connected?
			
			weight = new int [Vcnt][Vcnt];
			
			for(int i=0; i<freqTable.frequency.length; i++){
				for (int j = 0; j <freqTable.frequency[i].length; j++){
					adj[i][j] = freqTable.frequency[i][j].added;
					weight [i][j] = freqTable.frequency[i][j].count;
				}
				
				}
			
			points = new Vertex[Vcnt];
			for (int j = 0; j < Vcnt; j++) {
				points[j] = new Vertex(j);
			}
		 }
	
	static void show(Graph connect) {
		
		 for (int s = 0; s<connect.V() ; s++) 
		 {
			 System.out.print(s + ": ");
			 	AdjList A = connect.getAdjList(s) ; 
		for (int t = A.begin(); !A.end(); t = A.next()) 
			{
				System.out.print(t + " " ); 
			} 
		 		System.out.println();
		 }
		
	}
 
	public int V()
		{
			return Vcnt;
		} // return number of vertices
	
	public int E()
		{
			return Ecnt;
		} // return number of edges
	
	
	public void insert(Edge e)
		{
			
//				adj[e.v][e.w]=true;
//				adj[e.w][e.v]=true;
//				weight[e.v][e.w]=e.weight;
//				weight[e.w][e.v]=e.weight;
				Ecnt++;
			
		}
	
	public boolean edge(int node1, int node2)//are they connected?
		{
		
		return adj[node1][node2];
		
		}
	
	public boolean isEmpty(){
		return (Vcnt==0);
	}
	
	
	public AdjList getAdjList(int vertex)
		{
		 return new AdjArray(vertex);
		}
	
	
	interface AdjList {
		int begin();
		int next();
		boolean end();
	}
	
	
	
	private class AdjArray implements AdjList {
		private int v; // what vertex we are interested in
		private int i; // so we can keep track of where
		
		AdjArray(int vee )
			{
				v=vee;// save the value of the vertex passed in
				i=-1;// start the “i?counter at negative one
			}
		
		public int next() { 
			for (i++; i <= V(); i++) {
				if (edge(v, i))
					return i;
				}
					return -1;
			}
		
		 public int begin() {
			 i = -1;
			 return next();
		 }
		 
		 public boolean end() {
			 if (i <= V())
				 return false;
			 return true;
		}
		
	}
		
		public Vertex findMin(Vertex points[], int index){//finds the minimum vertex
			
			Vertex min;
			if(index == points.length-1 && points[index].known==false){
				return points[index];
			}
			min = findMin(points, index+1);
				if(min.dist<points[index].dist && points[index].known==false){
					return min;
				}else
					return points[index];
				
		}
		
		public boolean checkKnown(){
			for(int i = 1; i <= Vcnt; i++){
				if(points[i].known==false){
					return false;
				}
			}
			return true;
		}
		
		public void printPrev(Vertex t){
			if(t==null){
				return;
			}
			else{
				System.out.print(t.self+" ");
				printPrev(t.prev);
			}
		}

		/*void dijkstra (Vertex s) 
		{	
			PriorityQueue<Vertex>queue = new PriorityQueue<Vertex>(Vcnt+1);
			for(int i=1; i<=Vcnt;i++){
				points[i].dist = Integer.MAX_VALUE;
				points[i].known=false;
				queue.add(points[i]);
			}
				points[s.self].dist=0;	
				s.dist = 0;
				System.out.println("This "+points[s.self].dist+" & "+s.dist);
				
									while( checkKnown()!=true ) //do until all points are known = true
										{
										for (int i = 1; i < points.length; i++) {
											queue.poll();
											 
											points[i].known = true ;
											points[i].known = true;
											
											AdjList A = getAdjList(i);
											
											for (int t = A.begin(); !A.end(); t = A.next()){//each Vertex w adjacent to v 
												queue.remove(points[t]);
												if(!points[t].known) {
													int cost = weight[points[i].self][t];
													if (points[i].dist + cost < points[t].dist)//cvw = distance between v and w = weight
												{
													// update w
														points[t].dist = points[i].dist + cost ;
														points[t].prev = points[i] ;
														queue.add(points[t]);
														//v.dist;
														}
													}
												}
											}
										}
									
				
				System.out.println("Vertex\tWeight\tPath");
				for (int i = 1; i <= Vcnt; i++) {
				
					System.out.print((i) + "\t"+weight[i] + "\t ");
					//+ weight[i].toString() + "\t"
					printPrev(points[i]);
					//.prev
					System.out.println();
					
					}

			}*/
		}
