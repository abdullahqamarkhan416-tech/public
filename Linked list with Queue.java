
import java.util.Scanner;

public class LinkedListWithQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] data = new int[10];
        int[] next = new int[10];
        boolean[] used = new boolean[10];
        int front = -1, rear = -1, size = 0, choice;

        do {
            System.out.println("\n--- LINKED LIST WITH QUEUE ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Size");
            System.out.println("6. isEmpty");
            System.out.println("7. Exit");
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
                        System.out.println("Queue overflow!");
                        break;
                    }

                    System.out.print("Enter token number: ");
                    data[slot] = sc.nextInt();
                    next[slot] = -1;
                    used[slot] = true;

                    if (front == -1) {
                        front = rear = slot;
                    } else {
                        next[rear] = slot;
                        rear = slot;
                    }

                    size++;
                    System.out.println("Token added.");
                    break;
                }

                case 2:
                    if (front == -1) {
                        System.out.println("Queue underflow!");
                    } else {
                        System.out.println("Dequeued: " + data[front]);
                        int oldFront = front;
                        front = next[front];
                        used[oldFront] = false;
                        size--;

                        if (front == -1)
                            rear = -1;
                    }
                    break;

                case 3:
                    if (front == -1)
                        System.out.println("Queue is empty.");
                    else
                        System.out.println("Front value: " + data[front]);
                    break;

                case 4:
                    if (front == -1) {
                        System.out.println("Queue is empty.");
                    } else {
                        int current = front;
                        while (current != -1) {
                            System.out.print(data[current] + " -> ");
                            current = next[current];
                        }
                        System.out.println("NULL");
                    }
                    break;

                case 5:
                    System.out.println("Queue size: " + size);
                    break;

                case 6:
                    System.out.println(front == -1
                            ? "Queue is empty." : "Queue is not empty.");
                    break;

                case 7:
                    System.out.println("Exit.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 7);

        sc.close();
    }
}
