import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;


public class Frequency<Frequency> implements Comparable<Frequency>{
	
	public int count;
	//<Frequency>
	public boolean added;
	Collection<?> frequency;
	
	public Frequency(){
		count = 0;
		added = false;
	}
	
	public String toString(){
		
		return count+"";
	}
/*int compareTo(Data other) {
    return Integer.valueOf(priority).compareTo(other.priority);
  }*/

	public int compare(Frequency A, Frequency B) {
		int freqA = Collections.frequency(frequency, A);
		int freqB = Collections.frequency(frequency, B);
		
		if (freqA < freqB) return 1;
		if (freqB < freqA) return -1;
		return 0;
		
	}

	public int compareTo(Frequency A) {
		int freqA = Collections.frequency(frequency, A);
		
		if (freqA < this.count) return 1;
		if (this.count < freqA) return -1;
		return 0;
}
	
	


}
