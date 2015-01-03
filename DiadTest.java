import java.io.IOException;


public class DiadTest {
	
	public static void main(String [] args) throws IOException{
		
		System.out.println("The title of this book is: Democracy In America, Volume 1 (of 2)");
		System.out.println("The author is: Alexis de Toqueville");
		DiadFrequency test = new DiadFrequency("democracy.txt");
		test.reader("democracy.txt");
		//test.show(test);
		
		System.out.println("The title of this book is: Les Miserables");
		System.out.println("The author is: Victor Hugo");
		DiadFrequency test2 = new DiadFrequency("lesMis.txt");
		test2.reader("lesMis.txt");
	}

}
