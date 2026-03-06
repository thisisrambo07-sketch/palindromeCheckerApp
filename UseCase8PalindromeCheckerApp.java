import java.util.*;

class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

public class UseCase8PalindromeCheckerApp {

    static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        Node head = null, temp = null;

        for(char ch : input.toCharArray()) {
            Node newNode = new Node(ch);

            if(head == null) {
                head = newNode;
                temp = head;
            } else {
                temp.next = newNode;
                temp = newNode;
            }
        }

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalf = reverse(slow);
        Node firstHalf = head;

        boolean isPalindrome = true;

        while(secondHalf != null) {
            if(firstHalf.data != secondHalf.data) {
                isPalindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        if(isPalindrome)
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");

        sc.close();
    }
}