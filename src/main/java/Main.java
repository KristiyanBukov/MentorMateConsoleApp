import java.util.Scanner;

public class Main {

//     static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Because i wasn't completely sure what you mean by command line arguments ive made two implementations of the code.
        // This one below is working with cmd where you can give your files paths when you start the jar file in cmd.
        // To start it follow the steps:
        // Build run Maven clean -> install and jar will appear in target folder
        // Navigate true your cmd to this project folder -target- and start the jar file MentorMateConsoleApplication-1.0-SNAPSHOT-jar-with-dependencies.jar
        // Start it with this command (   java -jar MentorMateConsoleApplication-1.0-SNAPSHOT-jar-with-dependencies.jar  )
        // Give after the name 2 command line arguments with space between them and they should be with quotes
        // Example: "C:\\Users\\Aspire V\\Desktop\\New folder\\Data.json" "C:\\Users\\Aspire V\\Desktop\\New folder\\ReportDefinition.json"
        // Csv is in the target folder //

        String dataArgumentDirectory = args[0];
        String reportArgumentDirectory = args[1];

        DataManager.getPaths(dataArgumentDirectory, reportArgumentDirectory);


        // If you want to give files paths in the console of your IDEA uncomment this code below and the static scanner(import class).
        // Comment the other code
        // Give the paths strings without quotes
        // Example: C:\\Users\\Aspire V\\Desktop\\New folder\\Data.json C:\\Users\\Aspire V\\Desktop\\New folder\\ReportDefinition.json
        // Csv will be in main folder //

//            boolean quit = false;
//            int choice ;
//            while (!quit) {
//                System.out.println("Menu: \n Press 1 to set files paths \n Press 0 to quit " );
//                System.out.println("Enter your choice: ");
//                choice = scanner.nextInt();
//                scanner.nextLine();
//               switch (choice) {
//
//                   case 1:
//                       System.out.println("Please enter first path");
//                       String firstPath = scanner.nextLine();
//
//                       System.out.println("Please enter second path");
//                       String secondPath = scanner.nextLine();
//
//                       DataManager.getPaths(firstPath, secondPath);
//                       break;
//                   case 0:
//                       quit = true;
//                       break;
//                   default:
//                       System.out.println("Wrong option\n");
//
//               }
//            }


    }
}
