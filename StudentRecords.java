/* Paste in Command Terminal/PowerShell
  javac StudentRecords.java
  java Driver
 
*/
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.util.*;
import java.text.ParseException;
import java.time.Period;


class StudentRecords extends Driver
{


static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
Random rand = new Random(); 



 public void addRecords() throws IOException
 {
 // Create or Modify a file for Database
 PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("database.txt",true)));
 String name, Class, fname, mname, address;
 long telephoneNo , regno;
 String s;
 boolean addMore = false;
 
 do
 {
  System.out.print("\nEnter name      : ");
  name = br.readLine();

  System.out.print("Father's Name   : ");
  fname = br.readLine();

  System.out.print("Mother's Name   : ");
  mname = br.readLine();

  System.out.print("Address         : ");
  address = br.readLine();
  
  CalculateAgeJava obj3=new CalculateAgeJava();
  
  regno=rand.nextInt(10000000);
  System.out.print("Registration NO.: "+regno+"\n");
  
  
  System.out.print("Class           : ");
  Class = br.readLine();
  
  System.out.println("\n      -------    Enroll In Courses    ---------        \n");
  StudentRecords.enrollCourse();
  
  System.out.print("Telephone No.   : ");
  telephoneNo = Long.parseLong(br.readLine());
  
  
  // Print to File
  pw.println(name);
  pw.println(fname);
  pw.println(mname);
  pw.println(address);
  pw.println(Class);
  
  
  pw.println(telephoneNo);
  
  System.out.print("\nRecords added successfully !\n\nDo you want to add more records ? (y/n) : ");
  s = br.readLine();
  if(s.equalsIgnoreCase("y"))
  {
   addMore = true;
   System.out.println();
  }
  else
   addMore = false;
 }
 while(addMore);
 pw.close();
 showMenu();
 }
 
 
 static void enrollCourse()
{
	System.out.println("Mandatory Subjects are:\n"+"1. MATHEMATICS MTH101 - $85 \n "+"2. JAVA PROGRAMMING INT310 -$100 \n "+"3. ENGLISH PEL401 -$65 \n");
	System.out.println("Choose Open Elective from below bunches:\n");
	float amount;   

         int op;
		 Scanner in=new Scanner(System.in);
		System.out.println("Press 1 : PHYSICS - $450 :~\n"+" #ADVANCED PHYSICS PHY320 - $250  #QUANTUM PHYSICS PHY324 - $200");
		System.out.println("Press 2 : CHEMISTRY - $350 :~\n"+" #THERMODYANAMICS CHE270 - $150  #NUCLEAR CHEMISTRY CHE215 - $200");
		System.out.println("Press 3 : MACHINE LEARNING - $650 :~\n"+" #BASIC ML ML456 - $250  #KERAS & TENSORFLOW ML463 - $400");
		op=in.nextInt();
		switch(op)
	{
		case 1:
		{   
		    System.out.println("You have chosen PHYSICS\n");
			amount=85+100+65+450;
			System.out.println("Total Amount  =$ "+amount+" = "+"INR "+(amount*76.44));
			break;
		}
		case 2:
		{   
		    System.out.println("You have chosen CHEMISTRY\n");
		
	         amount=85+100+65+350;
			System.out.println("Total Amount  =$ "+amount+" = "+"INR "+(amount*76.44));
			break;
		}
		case 3:
		{    
		System.out.println("You have chosen MACHINE LEARNING\n");
			amount=85+100+65+650;
			System.out.println("Total Amount  =$ "+amount+" = "+"INR "+(amount*76.44));
			break;
		}
		default:
		{
			System.out.println("You have not chosen a valid no.Hence, Only enrolling in mandatory courses");
			amount=85+100+65;
			System.out.println("Total Amount  =$ "+amount+" = "+"INR "+(amount*76.44));
		}
		
		
	}

	}	




 public void readRecords() throws IOException
 {
 try
 {
  // Open the file
  BufferedReader file = new BufferedReader(new
  FileReader("database.txt"));
  String name;
  int i=1;
  // Read records from the file
  while((name = file.readLine()) != null)
  {
   System.out.println("_______________________________________________");
   System.out.println("S.No. : "+(i++));
   
   System.out.println("\nName          : "+name);
   System.out.println("Father's Name : "+file.readLine());
   System.out.println("Mother's Name : "+file.readLine());
   System.out.println("Address       : "+file.readLine());
   System.out.println("Class         : "+file.readLine());
   System.out.println("Tel. No.      : "+Long.parseLong(file.readLine()));
   System.out.println();
  }
  file.close();
  showMenu();
 }
 catch(FileNotFoundException e)
 {
  System.out.println("\nERROR : File not Found !!!");
 }
 }
 public void clear() throws IOException
 {
 // Create a blank file
 PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("database.txt")));
 pw.close();
 System.out.println("\nAll Records cleared successfully !");
 for(int i=0;i<999999999;i++); // Wait for some time
 showMenu();
 }
 public void showMenu() throws IOException
 {
 System.out.print("\n1 : Add Records\n2 : Display Records\n3 : Clear All Records\n4 : Exit\n\nYour Choice : ");
 int choice = Integer.parseInt(br.readLine());
 switch(choice)
 {
  case 1:
   addRecords();
   break;
  case 2:
   readRecords();
   break;
  case 3:
   clear();
   break;
  case 4:
   System.out.println("\t\t\t\tThanks for using Student Management System\n");
   DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
   LocalDateTime now1 = LocalDateTime.now();
   System.out.println("\nLast Updated     "+dtf1.format(now1)+"\n\n\n\n");
   System.exit(0); 
   break;
  default:
   System.out.println("\nInvalid Choice !");
   break;
 }
 }
 
 class Inner
 {
	 void begin()
	 {    
	     System.out.println("__________________________________________________________________________");
		 System.out.println("Please Wait");
		 try {Thread.sleep(2000);}
		 catch(InterruptedException ex) {}
		 
		 System.out.print("Loading");
		 for(int k=0;k<5;k++)
		 
	{
		 try {Thread.sleep(2000);}
		 catch(InterruptedException ex) {}
		 
		 System.out.print(". ");
	 }
		 System.out.println("\n\n\n\n"+"\t\t\t\t*****Welcome To Student Management System*****\n");
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
         LocalDateTime now = LocalDateTime.now();
		 System.out.println(dtf.format(now));
	 }
 }
 
}




class Driver 
{
 public static void main(String args[]) throws IOException
 {
	
 StudentRecords call = new StudentRecords();
 StudentRecords.Inner obj=call.new Inner();
 obj.begin();
 call.showMenu();
 }
 
 
 public class CalculateAgeJava 
{
 
    CalculateAgeJava()
	{   
	    int age;
        System.out.print("Please enter date of birth in YYYY-MM-DD: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        
 
        LocalDate dob = LocalDate.parse(input);
        System.out.println("Age is          : " + getAge(dob));
		age=getAge(dob);
		
    }
 
    // Returns age given the date of birth
    public int getAge(LocalDate dob) {
        LocalDate curDate = LocalDate.now();
        return Period.between(dob, curDate).getYears();
    }
	
	
	
 
}
 
 

}
