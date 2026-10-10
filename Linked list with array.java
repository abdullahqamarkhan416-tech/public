
import java.util.Scanner;

public class LinkedListWithArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] data = new int[10];
        int[] next = new int[10];
        boolean[] used = new boolean[10];
        int head = -1, choice;

        do {
            System.out.println("\n--- LINKED LIST WITH ARRAY ---");
            System.out.println("1. Insert at end");
            System.out.println("2. Delete by value");
            System.out.println("3. Display");
            System.out.println("4. Search");
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
                        System.out.println("List is full!");
                        break;
                    }

                    System.out.print("Enter value: ");
                    data[slot] = sc.nextInt();
                    next[slot] = -1;
                    used[slot] = true;

                    if (head == -1) {
                        head = slot;
                    } else {
                        int current = head;
                        while (next[current] != -1)
                            current = next[current];
                        next[current] = slot;
                    }
                    System.out.println("Inserted.");
                    break;
                }

                case 2: {
                    System.out.print("Enter value to delete: ");
                    int value = sc.nextInt();
                    int current = head, previous = -1;

                    while (current != -1 && data[current] != value) {
                        previous = current;
                        current = next[current];
                    }

                    if (current == -1) {
                        System.out.println("Value not found.");
                    } else {
                        if (previous == -1)
                            head = next[current];
                        else
                            next[previous] = next[current];

                        used[current] = false;
                        System.out.println("Deleted: " + value);
                    }
                    break;
                }

                case 3: {
                    int current = head;
                    if (current == -1)
                        System.out.println("List is empty.");
                    else {
                        while (current != -1) {
                            System.out.print(data[current] + " -> ");
                            current = next[current];
                        }
                        System.out.println("NULL");
                    }
                    break;
                }

                case 4: {
                    System.out.print("Enter value to search: ");
                    int value = sc.nextInt();
                    int current = head, position = 0;

                    while (current != -1 && data[current] != value) {
                        current = next[current];
                        position++;
                    }

                    if (current == -1)
                        System.out.println("Value not found.");
                    else
                        System.out.println("Found at position " + position);
                    break;
                }

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
