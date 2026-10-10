
import java.util.Scanner;

public class ArrayOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        int size = 0;
        int choice;

        do {
            System.out.println("\n----- ARRAY MENU -----");
            System.out.println("1. Add value");
            System.out.println("2. Insert at index");
            System.out.println("3. Fill array");
            System.out.println("4. Delete last element");
            System.out.println("5. Delete by index");
            System.out.println("6. Display");
            System.out.println("7. Search value");
            System.out.println("8. Get value at index");
            System.out.println("9. Replace/Update");
            System.out.println("10. Size");
            System.out.println("11. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            int value, index;

            switch (choice) {
                case 1:
                    if (size == arr.length) {
                        System.out.println("Array is full!");
                    } else {
                        System.out.print("Enter book ID: ");
                        arr[size++] = sc.nextInt();
                        System.out.println("Value added.");
                    }
                    break;

                case 2:
                    if (size == arr.length) {
                        System.out.println("Array is full!");
                        break;
                    }
                    System.out.print("Enter index (0 to " + size + "): ");
                    index = sc.nextInt();

                    if (index < 0 || index > size) {
                        System.out.println("Invalid index!");
                        break;
                    }
                    System.out.print("Enter value: ");
                    value = sc.nextInt();

                    for (int i = size; i > index; i--)
                        arr[i] = arr[i - 1];

                    arr[index] = value;
                    size++;
                    System.out.println("Value inserted.");
                    break;

                case 3:
                    while (size < arr.length) {
                        System.out.print("Enter value (or -1 to stop): ");
                        value = sc.nextInt();
                        if (value == -1) break;
                        arr[size++] = value;
                    }
                    System.out.println("Fill operation completed.");
                    break;

                case 4:
                    if (size == 0) {
                        System.out.println("Array is empty!");
                    } else {
                        System.out.println("Deleted: " + arr[--size]);
                    }
                    break;

                case 5:
                    if (size == 0) {
                        System.out.println("Array is empty!");
                        break;
                    }
                    System.out.print("Enter index to delete: ");
                    index = sc.nextInt();

                    if (index < 0 || index >= size) {
                        System.out.println("Invalid index!");
                        break;
                    }

                    value = arr[index];
                    for (int i = index; i < size - 1; i++)
                        arr[i] = arr[i + 1];

                    size--;
                    System.out.println("Deleted value: " + value);
                    break;

                case 6:
                    if (size == 0) {
                        System.out.println("Array is empty.");
                    } else {
                        System.out.print("Book IDs: ");
                        for (int i = 0; i < size; i++)
                            System.out.print(arr[i] + " ");
                        System.out.println();
                    }
                    break;

                case 7:
                    System.out.print("Enter value to search: ");
                    value = sc.nextInt();
                    boolean found = false;

                    for (int i = 0; i < size; i++) {
                        if (arr[i] == value) {
                            System.out.println("Found at index " + i);
                            found = true;
                        }
                    }
                    if (!found) System.out.println("Value not found.");
                    break;

                case 8:
                    System.out.print("Enter index: ");
                    index = sc.nextInt();

                    if (index >= 0 && index < size)
                        System.out.println("Value: " + arr[index]);
                    else
                        System.out.println("Invalid index!");
                    break;

                case 9:
                    System.out.print("Enter index: ");
                    index = sc.nextInt();

                    if (index < 0 || index >= size) {
                        System.out.println("Invalid index!");
                    } else {
                        System.out.print("Enter new value: ");
                        arr[index] = sc.nextInt();
                        System.out.println("Value updated.");
                    }
                    break;

                case 10:
                    System.out.println("Current size: " + size);
                    break;

                case 11:
                    System.out.println("Program ended.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 11);

        sc.close();
    }
}
