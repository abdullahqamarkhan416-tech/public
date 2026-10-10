
import java.util.Scanner;

public class QueueOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] queue = new int[10];
        int front = 0, rear = -1, size = 0;
        int choice;

        do {
            System.out.println("\n----- QUEUE MENU -----");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Size");
            System.out.println("5. isEmpty");
            System.out.println("6. isFull");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (size == queue.length) {
                        System.out.println("Queue overflow!");
                    } else {
                        System.out.print("Enter token number: ");
                        rear = (rear + 1) % queue.length;
                        queue[rear] = sc.nextInt();
                        size++;
                        System.out.println("Token added.");
                    }
                    break;

                case 2:
                    if (size == 0) {
                        System.out.println("Queue underflow!");
                    } else {
                        System.out.println("Served token: " + queue[front]);
                        front = (front + 1) % queue.length;
                        size--;
                    }
                    break;

                case 3:
                    if (size == 0) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println("Front to rear:");
                        for (int i = 0; i < size; i++)
                            System.out.print(
                                queue[(front + i) % queue.length] + " ");
                        System.out.println();
                    }
                    break;

                case 4:
                    System.out.println("Size: " + size);
                    break;

                case 5:
                    System.out.println(size == 0
                            ? "Queue is empty." : "Queue is not empty.");
                    break;

                case 6:
                    System.out.println(size == queue.length
                            ? "Queue is full." : "Queue is not full.");
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
