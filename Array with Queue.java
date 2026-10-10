
import java.util.Scanner;

public class ArrayWithQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] data = new int[10];
        int front = 0, rear = -1, size = 0, choice;

        do {
            System.out.println("\n--- ARRAY WITH QUEUE ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (size == data.length) {
                        System.out.println("Queue overflow!");
                    } else {
                        System.out.print("Value: ");
                        rear = (rear + 1) % data.length;
                        data[rear] = sc.nextInt();
                        size++;
                    }
                    break;

                case 2:
                    if (size == 0) {
                        System.out.println("Queue underflow!");
                    } else {
                        System.out.println("Removed: " + data[front]);
                        front = (front + 1) % data.length;
                        size--;
                    }
                    break;

                case 3:
                    if (size == 0)
                        System.out.println("Queue is empty.");
                    else
                        System.out.println("Front value: " + data[front]);
                    break;

                case 4:
                    if (size == 0) {
                        System.out.println("Queue is empty.");
                    } else {
                        for (int i = 0; i < size; i++)
                            System.out.print(
                                data[(front + i) % data.length] + " ");
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
