
import java.util.Scanner;

public class LinkedListWithStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] data = new int[10];
        int[] next = new int[10];
        boolean[] used = new boolean[10];
        int top = -1, choice;

        do {
            System.out.println("\n--- LINKED LIST WITH STACK ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: {
                    int slot = -1;
                    for (int i = 0; i < 10; i++) {
                        if (!used[i]) {
                            slot = i;
                            break;
                        }
                    }

                    if (slot == -1) {
                        System.out.println("Stack overflow!");
                        break;
                    }

                    System.out.print("Enter value: ");
                    data[slot] = sc.nextInt();
                    next[slot] = top;
                    used[slot] = true;
                    top = slot;
                    System.out.println("Pushed successfully.");
                    break;
                }

                case 2:
                    if (top == -1) {
                        System.out.println("Stack underflow!");
                    } else {
                        System.out.println("Popped: " + data[top]);
                        int oldTop = top;
                        top = next[top];
                        used[oldTop] = false;
                    }
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
                        int current = top;
                        while (current != -1) {
                            System.out.print(data[current] + " -> ");
                            current = next[current];
                        }
                        System.out.println("NULL");
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
