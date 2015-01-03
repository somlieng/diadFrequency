
import java.io.*;
import java.util.*;


public class DiadFrequency {
	
	File file; //file of characters to be read
	int totalChar=0; //total number of characters
	double startTime, endTime, elapsedTime;//variables used to measure the time of process
	double qwertytime,qwertystart,qwertyend;
	double dvoraktime,dvorakstart,dvorakend;
	
	int distrinctDiads;
	
	int touchleft,touchright,touchboth;
	int dvorakleft,dvorakright,dvorakboth;
	
//	private int Vcnt, Ecnt;
//	
//	private boolean adj[][];
//	private int weight[][];
//	public Vertex points[];
	
	public char lastChar; //temporary variable of the character right before the one being read
	
	ArrayList <String> tempDiad = new ArrayList <String>();
	//<Diad>
	
	Frequency [][] frequency;
	
	
	public int count;
	
	public DiadFrequency(String effy) {
		
		file = new File (effy);
		frequency = new Frequency [256][256];
		//make the table and fill in frequency as 0 and added as false
				for(int i=0; i<frequency.length; i++){
					for (int j = 0; j <frequency[i].length; j++){
						frequency[i][j]=new Frequency();
						frequency[i][j].count=0;
						frequency[i][j].added = false;
					}
				}

	}

	public void reader(String file) throws IOException{
		startTime = System.currentTimeMillis(); 
		
		BufferedReader read = new BufferedReader(new FileReader(file)); //reading a new file
		
		int value = read.read(); //ACSII value of the character being read
		
		System.out.println(value);
		
		try
		{	
				while(value!=-1){ //read for new line
						
						char current = (char)value;//converts int to character
								
						while(current !=65535 && current !=-1)
						{		totalChar++;
								value = read.read();
							//if(value >= 0){
								lastChar = current;
								current = (char)value;
		
								Diad Ben = new Diad (lastChar,current);
								addtoArray(Ben);
								qwerty(Ben);
								dvorak(Ben);
						//	}	
						}
					}	
				
		}catch(Exception e){
			e.printStackTrace();
		}
		
		read.close();
		
		sortArray(frequency);
		endTime = System.currentTimeMillis(); 
		elapsedTime = (endTime - startTime)/1000;
		System.out.println("Total number of Characters: "+totalChar);
		System.out.println("The program finished in : "+ elapsedTime + " seconds " ); 
		
		System.out.println("Handiness Test With Space Bar Designated to the Right Hand for QWERTY Keyboard");
		double sameHand = touchleft+touchright;
		
		System.out.println("One Handed Diads: "+ sameHand);
		
		//After calculating how many diads are typed with only one hand, you multiple it by 2 to get the number of characters
		//according to the guideline, it takes 1 minute to type 120 characters. which means you type 2 characters per second
		// 1 Diad * 2 characters = 2 characters
		// 120 characters / 1 min * (1 min / 60 seconds) = 2 characters / second
		// (2 characters) * (1 second / 2 characters)
		// # of seconds is equal to # of diads
		
		double sameHandTime= (sameHand*2)/2;
		
		System.out.println("Two Handed Diads: "+ touchboth);
		
		double bothHandTime = (touchboth *2)/4;
		
		System.out.println("The hypothetical time it takes to type this book with the QWERTY Keyboard is: "+ (sameHandTime+bothHandTime) +" seconds");
		
		System.out.println("\t Or "+ (sameHandTime+bothHandTime)/60 +" minutes");
		
		System.out.println("\t\t Or "+ ((sameHandTime+bothHandTime)/60)/60 +" hours");
		
		System.out.println("\t\t\t Or "+ (((sameHandTime+bothHandTime)/60)/60)/24 +" days");

		System.out.println("This is the time it took to calculate the hypothetical times with the QWERTY keyboard: "+qwertytime+" seconds");
		
		System.out.println("");
		
		
		double sameHanddvorak = dvorakleft+dvorakright;
		
		System.out.println("One Handed Diads: "+ sameHanddvorak);
		
		//After calculating how many diads are typed with only one hand, you multiple it by 2 to get the number of characters
		//according to the guideline, it takes 1 minute to type 120 characters. which means you type 2 characters per second
		// 1 Diad * 2 characters = 2 characters
		// 120 characters / 1 min * (1 min / 60 seconds) = 2 characters / second
		// (2 characters) * (1 second / 2 characters)
		// # of seconds is equal to # of diads
		
		double sameHandTimedvorak= (sameHanddvorak*2)/2;
		
		System.out.println("Two Handed Diads: "+ dvorakboth);
		
		double bothHandTimedvorak = (dvorakboth *2)/4;
		
		System.out.println("The hypothetical time it takes to type this book with the DVORAK Keyboard is: "+ (sameHandTimedvorak+bothHandTimedvorak) +" seconds");
		
		System.out.println("\t Or "+ (sameHandTimedvorak+bothHandTimedvorak)/60 +" minutes");
		
		System.out.println("\t\t Or "+ ((sameHandTimedvorak+bothHandTimedvorak)/60)/60 +" hours");
		
		System.out.println("\t\t\t Or "+ (((sameHandTimedvorak+bothHandTimedvorak)/60)/60)/24 +" days");

		System.out.println("This is the time it took to calculate the hypothetical times with the DVORAK keyboard: "+dvoraktime+" seconds");
		
		System.out.println("");
		
	}
	
	public void addtoArray(Diad Tom)
		{
		int first = (int)Tom.first;
		int second = (int)Tom.second;
		
		if(frequency[first][second].added == false)
			{
				frequency[first][second].added = true;
				frequency[first][second].count++;
			}
			else
			{
				frequency[first][second].count++;
			}
		
		}
	
	public void sortArray (Frequency [][] Anna){
		
		ArrayList<MyComp>store = new <MyComp>ArrayList();
		
		
		for (int i = 0; i < Anna.length; i++)
		 {for (int j=0; j<Anna[i].length; j++)
		 {	if(Anna[i][j].count!=0){
			 		char letterA = (char) i;
			 		char letterB = (char) j;
			 		Diad Ben = new Diad (letterA,letterB);
			 		MyComp Chuck = new MyComp (letterA, letterB, Anna[i][j].count);
			 		store.add(Chuck);
			 		
		 		}
		 	}
		 }
		
		Collections.sort(store, Collections.reverseOrder());
		
		System.out.println("Top 10 Most Common Diads: ");
		
		for(int i =0;i<10;i++){
			System.out.println(" "+store.get(i));
		}
		
		distrinctDiads = store.size();
		
		System.out.println("Number of Distinct Diads: "+distrinctDiads);

	}
	
	
	public String qwertyLeft (){
		String qleft = ("~`1!2@3#4$5%qQwWeErRtTaAsSdDfFgGzZxXcCvVbB");
		return qleft;
	}
	
	public String qwertyRight(){
		String qright = " 6^7&8*9(0)-_=+yYuUiIoOpP[{]}\\|hHjJkKlL;:nNmM,<.>/?\"\'";
		return qright;
	} //spacebar is placed on the Right hand
	
	public String dvorakLeft(){
		String dvorakLeft= "~`!1@23#$4%5\'\"<,>.pPyYaAoOeEuUiI:;qQjJkKxX";
		return dvorakLeft;
	}
	
	public String dvorakRight(){
		String dvorakRight = " ^6&7*8(9)0{}[]FfgGcCrRlL?/=+\\|dDhHtTnNsS-_bBmMwWvVzZ";
		return dvorakRight;
	} //spacebar is placed on the Right hand
	
	public void qwerty(Diad Tom)
	{
		qwertystart = System.currentTimeMillis(); 
	String first = String.valueOf(Tom.first);
	String second = String.valueOf(Tom.second);
	
	if(qwertyLeft().contains(first)&&qwertyLeft().contains(second)){
		touchleft++;
	}
	else if(qwertyRight().contains(first)&&qwertyRight().contains(second)){
		touchright++;
	}else touchboth++;
	
	qwertyend = System.currentTimeMillis(); 
	qwertytime = (qwertyend-qwertystart)/1000;
	
	}
	
	public void dvorak(Diad Tom)
	{
		dvorakstart = System.currentTimeMillis(); 
	String first = String.valueOf(Tom.first);
	String second = String.valueOf(Tom.second);
	
	if(dvorakLeft().contains(first)&&dvorakLeft().contains(second)){
		dvorakleft++;
	}
	else if(dvorakRight().contains(first)&&dvorakRight().contains(second)){
		dvorakright++;
	}else dvorakboth++;
	
	dvorakend = System.currentTimeMillis(); 
	dvoraktime = (dvorakend-dvorakstart)/1000;
	
	}
	
	public boolean edge(int node1, int node2)//are they connected?
	{
	
	return frequency[node1][node2].added;
	
	}
	
	public boolean isEmpty(){
		return (totalChar==0);
	}
	
	public int V()
		{
			return 256;
		} // return number of vertices/keys

	public int E()
		{
			return distrinctDiads;
		} // return number of edges
	
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
	
		static void show(DiadFrequency connect) {
			
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
		
}
