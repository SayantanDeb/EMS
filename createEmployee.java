import java.io.*; //importing the required package......
public class createEmployee //class createEmployee...
{

int MaximumLimit = 5; //initializing the Maximum limit of Employees as '5'

public createEmployee() //defining createEmployee constructor...
  {
    CheckLimit(); //calling CheckLimit method ...
//-----------------Input Employee Name-----------------
    System.out.print("Enter Employee Name : "); //Taking input of the Employee details...
    String EmployeeName =  System.console().readLine();
    boolean EmployeeNameIsValid = isString(EmployeeName);
    while ( EmployeeNameIsValid == false )
    {
    System.out.println("Employee Name Must Not Contain Any Number or Special Characters");
    System.out.print("Enter Employee Name Again : ");//Taking input of the Employee details...
    EmployeeName =  System.console().readLine();
    EmployeeNameIsValid = isString(EmployeeName);
    }
//-----------------Input Employee City-----------------
    System.out.print("Enter Employee Location : ");
    String EmployeeLocation =  System.console().readLine();
    boolean EmployeeLocationIsValid = isString(EmployeeLocation);

    while ( EmployeeLocationIsValid == false )
    {
    System.out.println("Employee Location Must Not Contain Any Number or Special Characters");
    System.out.print("Enter Employee Location Again : ");
    EmployeeLocation =  System.console().readLine();
    EmployeeLocationIsValid = isString(EmployeeLocation);
    }

    System.out.print("Enter Employee Mobile Number : ");
    String EmployeeMobileNo =  System.console().readLine();


    createRecord(EmployeeName,EmployeeLocation,EmployeeMobileNo); //Creating the employee record...

  }

public void CheckLimit() //defining the employee limit method...
{
  try //try block...
       {

         FileReader fr = new FileReader(".//database//EmployeeData.txt"); //Reading the file from the given location...
         BufferedReader br = new BufferedReader(fr); //storing the content of the file in BufferedReader...
         String Content; //Content is a variable taken to read every line from the file and store it...
         int line = 0; // initializing a varibale line as zero...
         while ((Content = br.readLine()) != null) //Reading the complete file while line is there...
         {
           line = line + 1; //incrementing the variable line...
         }
         br.close(); //closing the BufferedReader
         fr.close(); //closing the fr Object

         if (line >= MaximumLimit) //Checking the Limit...
         {
           System.out.print("Cannot add more employees right now");
           Runtime.getRuntime().exit(1);  // Alternative to System.exit()
         }
       }
       catch(FileNotFoundException fnfe ) //catch block...
       {
         System.out.println("No Existing Data Found..Please Continue");
       }
       catch(Exception ie) //catch block...
         {
           ie.printStackTrace();
         }
}
//-------------------------------------------------------------
private void createRecord(String EmployeeName,String EmployeeLocation,String EmployeeMobileNo) //defining the createRecord method...
{
  String EmployeeCode = EmployeeName.substring(0,2)+EmployeeLocation.substring(0,3)+EmployeeMobileNo.substring(EmployeeMobileNo.length()-4); //Generating the employee code
  try //try block...
       {
         PrintWriter pw = new PrintWriter(new FileOutputStream(new File(".//database//EmployeeData.txt"),true)); //writing the employee details into the text file
         pw.println(EmployeeCode+", "+EmployeeName+", "+EmployeeLocation+", "+EmployeeMobileNo); //printing the employee details seperated by comma...
         pw.close(); //closing the pw object...
         System.out.println("New Employee generated with ID : "+EmployeeCode); //New Employee generated...
       }
  catch(Exception ie) //catch block...
    {
       ie.printStackTrace();
     }
  }
//-------------------------------------------------------------
public static boolean isString(String str)
    {
        return ((str != null) && (!str.equals("")) && (str.matches("^[a-zA-Z]*$")));
    }
}
