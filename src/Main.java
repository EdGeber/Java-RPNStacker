import java.util.Stack;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Main {
    public static void main(String[] args) {
        // System.out.println("Hello world!");
        Stack<Integer> S = new Stack<>();

        try {
            File file = new File(args[0]);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String thing = scanner.nextLine();
                int a, b;
                switch (thing) {
                    case "+" -> {
                        b = S.pop();
                        a = S.pop();
                        S.push(a + b);
                    }
                    case "-" -> {
                        b = S.pop();
                        a = S.pop();
                        S.push(a - b);
                    }
                    case "*" -> {
                        b = S.pop();
                        a = S.pop();
                        S.push(a * b);
                    }
                    case "/" -> {
                        b = S.pop();
                        a = S.pop();
                        S.push(a / b);
                    }
                    default -> S.push(Integer.parseInt(thing));
                }
            }
            scanner.close();
            int result = S.pop();
            System.out.println(result);
        } catch (FileNotFoundException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}