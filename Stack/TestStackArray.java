import java.util.Scanner;

public class TestStackArray{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      StackArray sa;
      
      System.out.print("Enter stack size: ");
      sa = new StackArray(scan.nextInt());
      scan.nextLine(); //eats whitespace from scanning int
      
      String choice = "";
      do {
         menu();
         choice = scan.nextLine();
      
         switch(choice) {
            case "1":
               System.out.print("Enter an item: ");
               if(sa.push(scan.nextLine()))
                  System.out.println("Successfully pushed an item.");
               else
                  System.out.println("Sorry, stack is full.");
            
               break;
            case "2":
               if(sa.pop())
                  System.out.println("Successfully popped an item");
               else
                  System.out.println("Cannot pop. Stack is empty");
               break;
            case "3":
               if(sa.peek() == null)
                  System.out.println("Cannot peek. Stack is empty");
               else
                  System.out.println(sa.peek());
               break;
            case "4":
               sa.display();
               break;
            case "x":
               System.out.println("Exiting program...");
               break;
            default:
               System.out.println("Invalid choice. Please try again.");
               break;
         }
      } while (!choice.equals("x"));
   }
   
   static void menu(){
      System.out.println("\n---Stack Array Menu---");
      System.out.println("[1] Push an item");
      System.out.println("[2] Pop");
      System.out.println("[3] Peek");
      System.out.println("[4] Display Stack");
      System.out.println("[x] Exit program");
      System.out.print("\nSelect a choice: ");
   }
}