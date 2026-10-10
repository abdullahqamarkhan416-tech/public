
import java.util.Scanner;

public class StackOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] stack = new int[10];
        int top = -1;
        int choice;

        do {
            System.out.println("\n----- STACK MENU -----");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Size");
            System.out.println("5. isEmpty");
            System.out.println("6. isFull");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (top == stack.length - 1) {
                        System.out.println("Stack overflow!");
                    } else {
                        System.out.print("Enter value: ");
                        stack[++top] = sc.nextInt();
                        System.out.println("Value pushed.");
                    }
                    break;

                case 2:
                    if (top == -1) {
                        System.out.println("Stack underflow!");
                    } else {
                        System.out.println("Popped: " + stack[top--]);
                    }
                    break;

                case 3:
                    if (top == -1) {
                        System.out.println("Stack is empty.");
                    } else {
                        System.out.println("Top to bottom:");
                        for (int i = top; i >= 0; i--)
                            System.out.println(stack[i]);
                    }
                    break;

                case 4:
                    System.out.println("Size: " + (top + 1));
                    break;

                case 5:
                    System.out.println(top == -1
                            ? "Stack is empty." : "Stack is not empty.");
                    break;

                case 6:
                    System.out.println(top == stack.length - 1
                            ? "Stack is full." : "Stack is not full.");
                    break;

                case 7:
                    System.out.println("Program ended.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 7);

        sc.close();
    }
}
