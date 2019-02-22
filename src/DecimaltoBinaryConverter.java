import java.util.Scanner;

public class DecimaltoBinaryConverter {

    public DecimaltoBinaryConverter() {
        char hex[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};  //Stores Possible Hex Values
        int rem;
        String str2 = "";   //Stores converted int to Hex
        int binary[] = new int[40];     //Array that stores binary values
        int index = 0;
        boolean run = true;
        Scanner reader = new Scanner(System.in);
        while (run) {
            System.out.println("Please enter a number that you would like to convert?: ");
            int num = reader.nextInt();
            while(num<=0){
                System.out.println("The number you have entered is invalid. Please repick a number: ");
                num = reader.nextInt();
            }
            reader.nextLine();
            System.out.println("What would you like to convert your number to? Binary[b] or Hexadecimal[h]");
            String choice = reader.nextLine();
            while(!(choice.toUpperCase().equals("H"))||(choice.toUpperCase().equals("B"))){
                System.out.println("The choice you have selected is not an option. Please reselect one of the options. Binary[B} or Hexadecimal[H]");
                choice = reader.nextLine();
            }
            if (choice.toUpperCase().equals("H")) {
                System.out.println("You have selected to convert your number to Hexadecimal");
                while (num > 0) {
                    rem = num % 16;
                    str2 = hex[rem] + str2;
                    num = num / 16;
                }
                System.out.println("This is your converted number: " + str2);

            } else if (choice.toUpperCase().equals("B")) {
                while (num > 0) {
                    binary[index++] = num % 2;
                    num = num / 2;
                }
            }
            System.out.println();
            for (int i = index - 1; i >= 0; i--) {
                System.out.print(binary[i]);
            }
            System.out.println();
            System.out.println("Would you like to continue? Yes[Y], No[N]");
            String ans = reader.nextLine();
            while(!(ans.toUpperCase().equals("Y"))||ans.toUpperCase().equals("N")){
                System.out.println("The choice you have selected is invalid. Reselect your choice: ");
                ans = reader.nextLine();
            }
            if (ans.toUpperCase().equals("Y")) {
                run = true;
                rem = 0;
                str2 = "";
                index = 0;
                num = 0;
                choice = "";
            } else {
                System.out.println("You have terminated the program");
                run = false;
            }
        }
    }

    public static void main(String[] args) {
        DecimaltoBinaryConverter app = new DecimaltoBinaryConverter();
    }
}
