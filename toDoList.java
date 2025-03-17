// package ToDoListApp;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class toDoList {

    private static void saveTasksToFile(ArrayList<String> tasks) {
        try (PrintWriter writer = new PrintWriter("tasks.txt")) {
            for (String task : tasks) {
                writer.println(task);
            }
        } catch (IOException e) {
            System.out.println("error saving tasks to file : " + e.getMessage());
        }
    }

    private static void loadTasksFromFile(ArrayList<String> tasks) {
        try (BufferedReader reader = new BufferedReader(new FileReader("tasks.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                tasks.add(line);
            }
        } catch (IOException e) {
            System.out.println("error loading tasks from file : " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        ArrayList<String> tasks = new ArrayList<>();
        loadTasksFromFile(tasks);
        Scanner t = new Scanner(System.in);

        if (args.length == 0) {
            System.out.println("\nUsage:");
            System.out.println("  todo add \"task description\"");
            System.out.println("  todo display");
            System.out.println("  todo mark <task_number>");
            System.out.println("  todo remove <task_number>");
            System.out.println("  todo clear");
            System.exit(0);
        }
        String command = args[0];
        // handle user choice
        switch (command) {
            case "add":
                // ADD TASK
                if (args.length < 2) {
                    System.out.println("please provide task description!");
                    System.exit(1); // exit with error.
                }

                String task = args[1];
                tasks.add(task);
                saveTasksToFile(tasks);
                System.out.println("task added successfully!");
                break;

            case "display":
                // display
                System.out.println("your tasks:");
                if (tasks.isEmpty()) {
                    System.out.println("no tasks");
                } else {
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + "." + tasks.get(i));
                    }
                }
                break;

            case "mark":
                if (args.length < 2) {
                    System.out.println("please provide task number!");
                    System.exit(1);
                }
                // mark
                try {
                    int index = Integer.parseInt(args[1]) - 1;
                    if (index >= 0 && index < tasks.size()) {
                        tasks.set(index, tasks.get(index) + " (completed)");
                        saveTasksToFile(tasks);
                        System.out.println("Task marked as completed.");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format.");
                }
                break;

            case "remove":
                if (args.length < 2) {
                    System.out.println("Error: Please provide a task number.");
                    System.exit(1);
                }
                try {
                    int index = Integer.parseInt(args[1]) - 1;
                    if (index >= 0 && index < tasks.size()) {
                        System.out.println("Removed task: " + tasks.remove(index));
                        saveTasksToFile(tasks);
                    } else {
                        System.out.println("Invalid task number.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format.");
                }
                break;

            case "clear":
                tasks.clear();
                saveTasksToFile(tasks);
                System.out.println("all tasks clear");
                break;

            default:
                System.out.println("Invalid choice please try again : " + command);
        }
        t.close();
    }
}
