import java.util.Comparator;


public class Diad implements Comparable<Diad>{
	
	public char first, second; // for first and second characters in the diad
	public int a,b; // equate the characters to ASCII values
	public Integer x,y; // equate the characters to an Integer value
	public Integer frequency; 
	
	public Diad(char one, char two){
		if(one > 256 || two > 256){
			System.out.println("PROBLEM:: "+one+" "+two);
			System.out.println("PROBLEM:: "+(int)one+" "+(int)two);
		}
		first = one;
		second = two;
		a = one;
		b = two;
		x = a;
		y = b;
		frequency = 0;
	}
	
	public int compareTo(Diad compy){
		Integer c1 = this.x.compareTo(compy.x);
		Integer c2 = this.y.compareTo(compy.y);
		
		if (c1==0)
		{
			return c2;
		}
			else return c1;
		
	}
	
	
	
	public String toString()
		{
//			if (second == 13){
//				//return String.format("%s, diad has a frequncy of %s", first, frequency);
//				return String.format("%s, ", first);
//			}
			//return String.format("%s,%s diad has a frequency of %s", first, second, frequency); 
				return String.format("%s,%s", first,second);
		}

	
	public int compare(Diad A, Diad B) {
		return A.compareTo(B);
	}

}
