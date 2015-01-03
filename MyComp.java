import java.util.*;


public class MyComp implements Comparable {
	
	public char first,second;
	public int occurence;
	
	public MyComp(char one, char two, int freq){
		first = one;
		second = two;
		occurence = freq;
	}

	public int compareTo(Object A) {
		MyComp letter = (MyComp)A;
		
		if(this.occurence < letter.occurence){ return -1;}
		if(this.occurence > letter.occurence){ return 1;}
		else
		return 0;
	}
	
	public String toString(){
		return first+","+second+": "+occurence;
	}

}
