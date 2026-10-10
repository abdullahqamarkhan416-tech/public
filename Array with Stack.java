
import java.util.Scanner;

public class ArrayWithStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] data = new int[10];
        int top = -1, choice;

        do {
            System.out.println("\n--- ARRAY WITH STACK ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (top == data.length - 1) {
                        System.out.println("Overflow!");
                    } else {
                        System.out.print("Value: ");
                        data[++top] = sc.nextInt();
                    }
                    break;

                case 2:
                    if (top == -1)
                        System.out.println("Underflow!");
                    else
                        System.out.println("Removed: " + data[top--]);
                    break;

                case 3:
                    if (top == -1)
                        System.out.println("Stack is empty.");
                    else
                        System.out.println("Top value: " + data[top]);
                    break;

                case 4:
                    if (top == -1) {
                        System.out.println("Stack is empty.");
                    } else {
                        for (int i = top; i >= 0; i--)
                            System.out.print(data[i] + " ");
                        System.out.println();
                    }
                    break;

                case 5:
                    System.out.println("Exit.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}
