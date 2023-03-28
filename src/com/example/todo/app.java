package com.example.todo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class app {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int choice,count = 0;
        String task;
        Menu m =new Menu();
        todo t;
        TodoQueue tq=new TodoQueue(6);
        while (true){
            assert false;
            m.menu();
            try {
                choice = scan.nextInt();
            } catch (InputMismatchException e) {
                throw new RuntimeException(e);
            }
            switch (choice) {
                case 1 -> {
                    scan.nextLine();
                    System.out.println("Enter task name: ");
                    try{
                    task=scan.nextLine();
                    } catch (InputMismatchException e) {
                        throw new RuntimeException(e);
                    }
                    t=new todo(task);
                    tq.add(t.getName());
                    count++;
                }
                case 2 -> {
                    tq.remove();
                    count--;
                }
                case 3 -> System.out.println("Your to do list has : "+count+  "  tasks");
                case 4 -> {
                    scan.nextLine();
                    System.out.println("Enter task to search for: ");
                    try{
                        task=scan.nextLine();
                    } catch (InputMismatchException e) {
                        throw new RuntimeException(e);
                    }
                    tq.search(task);
                }
                case 5 -> {
                    scan.nextLine();
                    System.out.println("Enter task to check: ");
                    try{
                        task=scan.nextLine();
                    } catch (InputMismatchException e) {
                        throw new RuntimeException(e);
                    }
                    tq.checkIndex(task);
                }
                case 6 -> tq.display();
                case 7 -> System.exit(0);
                default -> System.out.println("Enter the correct choice.");
            }
        }

    }
}
