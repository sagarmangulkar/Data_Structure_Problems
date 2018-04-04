import java.util.ArrayList;
import java.util.List;

public class Methods {

    public static void TestReverseLinkedListUsingArray(){
        NumberAndPointer head = PrepareHardcodedInputLinkedList(1, 10);
        DisplayList(head);
        NumberAndPointer reversedHead = ReverseLinkedListElementsUsingArray(head);
        DisplayList(reversedHead);
    }

    public static void TestReverseLinkedListUsingPrevious(){
        NumberAndPointer head = PrepareHardcodedInputLinkedList(1, 10);
        DisplayList(head);
        NumberAndPointer reversedHead = ReverseLinkedListElementsWithPrevious(head);
        DisplayList(reversedHead);
    }

    public static void TestReverseLinkedListUsingRecursion(){
        NumberAndPointer head = PrepareHardcodedInputLinkedList(1, 10);
        DisplayList(head);
        NumberAndPointer reversedHead = ReverseLinkedListElementsWithRecursion(head);
        DisplayList(reversedHead);
    }

    private static NumberAndPointer ReverseLinkedListElementsWithRecursion(NumberAndPointer head) {
        if (head == null || head.getNext() == null){
            return head;
        }
        NumberAndPointer reversedHead = ReverseLinkedListElementsWithRecursion(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return reversedHead;
    }

    private static NumberAndPointer ReverseLinkedListElementsWithPrevious(NumberAndPointer head) {
        NumberAndPointer curr = head, prev = null, temp;
        while (curr != null){
            temp = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    private static NumberAndPointer ReverseLinkedListElementsUsingArray(NumberAndPointer head) {
        List<NumberAndPointer> listOfNumbers = GetArray(head);
        NumberAndPointer reverseHead = GetLinkedList(listOfNumbers);
        return reverseHead;
    }

    private static NumberAndPointer GetLinkedList(List<NumberAndPointer> listOfNumbers) {
        NumberAndPointer reverseHead = listOfNumbers.get(listOfNumbers.size()-1);
        NumberAndPointer temp = reverseHead;
        for (int i = listOfNumbers.size()-2; i >= 0; i--) {
            temp.setNext(listOfNumbers.get(i));
            temp = listOfNumbers.get(i);
        }
        temp.setNext(null);
        return reverseHead;
    }

    private static List<NumberAndPointer> GetArray(NumberAndPointer head) {
        List<NumberAndPointer> listOfNumbers = new ArrayList();
        int j = 0;
        while (head != null){
            listOfNumbers.add(j, head);
            head = head.getNext();
            j++;
        }
        return listOfNumbers;
    }

    private static void DisplayList(NumberAndPointer head) {
        String result = "";
        while (head != null){
            result = result.concat(head.getNumber() + "->");
            head = head.getNext();
        }
        System.out.println(result.substring(0, result.length()-2));
    }

    private static NumberAndPointer PrepareHardcodedInputLinkedList(int start, int end) {
        NumberAndPointer head = new NumberAndPointer(start,null);
        NumberAndPointer temp = head;
        for (int i = start; i < end; i++) {
            NumberAndPointer numberAndPointer = new NumberAndPointer(i+1, null);
            temp.setNext(numberAndPointer);
            temp = numberAndPointer;
        }
        return head;
    }

    public static void TestDeleteNodeWithoutTraversing() {
        NumberAndPointer head = PrepareHardcodedInputLinkedList(1, 5);
        DisplayList(head);
        NumberAndPointer nodeToBeDeleted = head.getNext().getNext();    //nodeToBeDeleted = 3
        DeleteNode(nodeToBeDeleted);
        DisplayList(head);
    }

    private static void DeleteNode(NumberAndPointer nodeToBeDeleted) {
        nodeToBeDeleted.setNumber(nodeToBeDeleted.getNext().getNumber());
        nodeToBeDeleted.setNext(nodeToBeDeleted.getNext().getNext());
    }
}
