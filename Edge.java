
public class Edge {
			
//			Vertex w;
//			int weight;
//
//			public Edge(Vertex v, int wey){
//				w=v;
//				weight = wey;
//			}
	
			int v, w; // and edge from v to w
			int weight;
		
			public Edge(int vee, int wee,int wey){
				v=vee;
				w=wee;
				weight = wey;
			}
		
			public int getWeight() {
				return weight;
			}
		
			public void setWeight(int weight) {
				this.weight = weight;
			}
	
	}