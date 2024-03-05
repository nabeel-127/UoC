	import java.util.Scanner;
	
	class Travel
	{

	public static void main(String args[])
	{
		
		String[][] travellers = {	
								{"Mark","MAN"},   // Mark is in Manchester
								{"Adam","LDS"},	  // Adam is in Leeds
								{"Barney","WRX"}, //Barney is in Wrexham
								{"Madge","LDN"},  //Madge is in London
								{"Mary","POO"},	  //Mary is in Poole
								{"David","CDF"},  //David is in Cardiff	
								{"Michel","DOV"}, //Michel is in Dover	
								{"Sue","NCL"},	  //Mary is in Newcastle				
								};
		
		String destination = "BRS"; //destination is Bristol
		
		
		// schedule of OUTGOING trains each day
		// trains structure is: Origin, Destination, Departure Time, Arrival Time, Changes, Price
		String[][] trainsOut = {
							{"MAN","BRS","0700","1138","0","75"},
							{"MAN","BRS","1004","1456","1","20"},
							{"MAN","BRS","1206","1548","1","35"},
							{"LDS","BRS","0547","1138","1","105"},
							{"LDS","BRS","0838","1456","2","38"},
							{"LDS","BRS","1155","1442","1","40"},
							{"WRX","BRS","0547","1138","1","105"},
							{"WRX","BRS","0838","1456","2","38"},
							{"WRX","BRS","1155","1442","1","40"},
							{"LDN","BRS","0612","1056","2","175"},
							{"LDN","BRS","0734","1146","1","209"},
							{"LDN","BRS","0915","1455","2","95"},
							{"POO","BRS","0802","1022","1","86"},
							{"POO","BRS","1048","1234","0","55"},
							{"POO","BRS","1124","1309","1","55"},
							{"CDF","BRS","0637","0742","1","25"},
							{"CDF","BRS","0748","0908","0","45"},
							{"CDF","BRS","1029","1205","1","22"},
							{"DOV","BRS","0645","1052","2","56"},
							{"DOV","BRS","0834","1204","1","104"},
							{"DOV","BRS","1137","1453","2","85"},
							{"NCL","BRS","0542","0945","2","134"},
							{"NCL","BRS","0723","1202","3","175"},
							{"NCL","BRS","1116","1538","2","122"},
							};
		
		// schedule of RETURN trains each day
		// trains structure is: Origin, Destination, Departure Time, Arrival Time, Changes, Price
		String[][] trainsRtn = {
							{"BRS","MAN","1355","1801","1","40"},
							{"BRS","MAN","1437","1910","2","35"},
							{"BRS","MAN","1645","2033","0","89"},
							{"BRS","LDS","1404","1901","0","95"},
							{"BRS","LDS","1437","2112","3","50"},
							{"BRS","LDS","1507","2017","1","78"},
							{"BRS","WRX","1248","1609","1","110"},
							{"BRS","WRX","1339","1720","2","50"},
							{"BRS","WRX","1530","1957","1","165"},
							{"BRS","LDN","1121","1504","2","72"},
							{"BRS","LDN","1321","1706","2","90"},
							{"BRS","LDN","1540","1946","1","240"},
							{"BRS","POO","1307","1548","1","70"},
							{"BRS","POO","1332","1554","0","100"},
							{"BRS","POO","1407","1648","1","70"},
							{"BRS","CDF","1445","1539","0","25"},
							{"BRS","CDF","1514","1602","0","25"},
							{"BRS","CDF","1627","1748","1","40"},
							{"BRS","DOV","1317","1603","2","72"},
							{"BRS","DOV","1455","1804","1","145"},
							{"BRS","DOV","1633","1956","2","178"},
							{"BRS","NCL","1304","1728","1","55"},
							{"BRS","NCL","1452","1907","2","140"},
							{"BRS","NCL","1602","2149","3","85"},
							};
		
	Scanner input = new Scanner(System.in);
	

	// THE FOLLOWING LISTS ALL OUTBOUND AND RETURN TRAINS
	System.out.println("Array rows: "+travellers.length);
	System.out.println("Array columns: "+travellers[0].length);
	System.out.println();

	System.out.println("--- Travellers ---");
	showArray(travellers);
	System.out.println();

	System.out.println("*** OUTBOUND TRAINS ***");
	System.out.println("FRM TO  DEP ARR CHG £££");
	System.out.println("--- --- --- --- --- ---");
	showArray(trainsOut);
	System.out.println();

	System.out.println("*** RETURN TRAINS ***");
	System.out.println("FRM TO  DEP ARR CHG £££");
	System.out.println("--- --- --- --- --- ---");
	showArray(trainsRtn);
	System.out.println();


	// *** TESTING CODE ***
	// YOU MIGHT FIND THE BELOW HELPFUL AS AN EXAMPLE OF ACCESSING THE ARRAY OF INFORMATION
	// AND USING THE METHODS BELOW 
	System.out.println("What return train are you interested in (0 to "+(trainsRtn.length-1)+")");
	int myTrain = input.nextInt();

	double myDep=getDepTime(trainsRtn,myTrain);
	double myArr=getArrTime(trainsRtn,myTrain);
	int change=getChanges(trainsRtn,myTrain);
	int price=getPrice(trainsRtn,myTrain);
	System.out.println("My train is from "+trainsRtn[myTrain][0]+" to "+trainsRtn[myTrain][1]);
	System.out.println("My trains leaves at "+myDep);
	System.out.println("My trains arrives at "+myArr);
	System.out.println("My trains changes "+change);
	System.out.println("My trains costs "+price);
	// END OF TESTING CODE


	}
	
	
	
	
	// show the whole contents of an array
	public static void showArray(String [][] theArray) {

		for (int i=0; i<theArray.length;i++){
			for (int j=0; j<theArray[0].length; j++){
				System.out.print(theArray[i][j]+" ");
				}
				System.out.println();
		}

		}
		
		
		
		
		// return a train departure time as a double
	public static double getDepTime(String [][] theArray, int index) {

		double depTime=0;
		
		depTime=Double.parseDouble(theArray[index][2]);
		return depTime;
		
		}
		
		
		
		
		// return a train arrival time as a double
	public static double getArrTime(String [][] theArray, int index) {

		double arrTime=0;
		
		arrTime=Double.parseDouble(theArray[index][3]);
		return arrTime;
		
		}
		
		
		
		// return number of train changes as an int
	public static int getChanges(String [][] theArray, int index) {

		int changes=0;
		
		changes=Integer.parseInt(theArray[index][4]);
		return changes;
		
		}
		
		
		
		
		// return a train cost time as an int
	public static int getPrice(String [][] theArray, int index) {

		int price=0;
		
		price=Integer.parseInt(theArray[index][5]);
		return price;
		
		}
	

	
	}