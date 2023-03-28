package com.example.todo;

public class TodoQueue implements Methods{
    private static int front, rear, capacity;
    private static String[] queue;
    TodoQueue(int size) {
        front = rear = 0;
        capacity = size;
        queue = new String[capacity];
    }


    public boolean isEmpty(){
        return front == rear;
    }

    public boolean isFull(){
        return capacity == rear;
    }

    public void add(String item)  {

        if (isFull()){
            System.out.print("\nTask list is full\n");
        }

        else {
            queue[rear] = item;
            rear++;
        }
    }

    public void remove()  {

        if (isEmpty()) {
            System.out.print("\nThere is no task available\n");
        }

        else {
            if (rear - 1 >= 0) System.arraycopy(queue, 1, queue, 0, rear - 1);

            if (rear < capacity)
                queue[rear] = "";


            rear--;
        }
    }


    public void display()
    {
        int i;
        if (isEmpty()) {
            System.out.print("\nThere is no task available\n");
            return;
        }


        for (i = front; i < rear; i++) {
            System.out.printf(" %s ", queue[i]);
            System.out.println("");
        }
    }


    public void checkIndex(String string){
        int g=0;
        for(int i=0;i<capacity;i++) {
            if(string.equals(queue[i])) {
                g=1;
                System.out.println("Task found at index " +i);
                break;
            }
        }
        if(g==0)
            System.out.println("Task not found");
    }

    public void search(String s){
        int f=0;
        for(int i=0;i<capacity;i++) {
            if(s.equals(queue[i])) {
                f=1;
                System.out.println("Task present.");
                break;
            }
        }
        if(f==0)
            System.out.println("Task not found;");
    }

    public String front() {
        if (isEmpty()) {
            System.out.print("\nThere is no task available\n");
        }
        System.out.printf("\nFront Element of the queue: %s", queue[front]);
        return queue[front];
    }
}
