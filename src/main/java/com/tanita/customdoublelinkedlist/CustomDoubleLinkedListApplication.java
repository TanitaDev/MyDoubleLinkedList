package com.tanita.customdoublelinkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//вставка
//удаление
//контейнс
//итератор

@SpringBootApplication
public class CustomDoubleLinkedListApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomDoubleLinkedListApplication.class, args);

        CustomDoubleLinkedList doubleLinkedList = new CustomDoubleLinkedList();
        doubleLinkedList.add("1");
        doubleLinkedList.add("2");
        doubleLinkedList.add("3");
        System.out.println(doubleLinkedList);
        System.out.println(doubleLinkedList.contains("5"));
    }

}

@Data
class CustomDoubleLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public void add(String data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public boolean contains(String data) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}

class Node {
    String data;
    Node next;
    Node prev;

    Node(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data;
    }
}
