public class EmployeeManagementSystem //Main class to create objects and invoking the appropriate methods...
{
  public static void main(String[] args) //main method
{

  String input = Menu(); //calling the Menu method and storing the returned value in a variable named 'input'
 switch(input) //Switch case conditions
 {
  case "1":
  createEmployee empcreate = new createEmployee(); //Object creation for createEmployee class
    break;
  case "2":
  getEmployee empget = new getEmployee(); //Object creation for getEmployee class
    break;
  case "3":
      System.out.println("Quit"); //Quit from the MENU
      Runtime.getRuntime().exit(0); // Alternative to System.exit()
    break;
  default:
     System.out.println("Please enter a valid option [ 1-3 ]:");
//     String input = Menu();
  }
}
public static void clearScreen() //User Defined method to clear the Screen...
{
      System.out.print("\033[H\033[2J");
      System.out.flush();
}
public static String Menu() //Menu method to display the MENU in the Output Screen...
 {
    //clearScreen(); //calling clearScreen method to clear the screen...
    System.out.println("----------------------------------------------------------"); //MENU
    System.out.println("Welcome to Employee Management System");
    System.out.println("----------------------------------------------------------");
    System.out.println("1. Create Employee Record");
    System.out.println("2. Display Employee record by ID");
    System.out.println("3. Quit");
    System.out.println("-------------------------------------------------------------");
    String input = System.console().readLine(); //Taking an Input from the MENU
    return input; //Returning the input value to the called method
    }
}
