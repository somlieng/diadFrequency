import java.util.ArrayList;

public class Vertex implements Comparable<Vertex>{
				
//				String name;
//				ArrayList<Edge> edges = new <Edge> ArrayList() ;
//				
//				
//				public Vertex(String character, ArrayList<Edge> connected){
//					name = character;
//					edges = connected;
//				}
//	
//				public int compareTo(Vertex A) {
//					
//					return this.name.compareTo(A.name);
//				}
	
				int dist;
				boolean known;
				int self;
				Vertex prev;
				
				
				public Vertex(int x){
					this.self=x; 
					this.prev=null;
				}
			
			
				public int compareTo(Vertex arg0) {
					return dist-arg0.dist;
				}
							
			}
