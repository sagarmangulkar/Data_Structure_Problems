
public class Start {
    public static void main(String[] str){
        System.out.println("\nReverse Linked List Using Array:");
        Methods.TestReverseLinkedListUsingArray();

        System.out.println("\nReverse Linked List Using Previous:");
        Methods.TestReverseLinkedListUsingPrevious();

        System.out.println("\nReverse Linked List Using Recursion:");
        Methods.TestReverseLinkedListUsingRecursion();

        System.out.println("\nDelete given Node without traversing Linked List:");
        Methods.TestDeleteNodeWithoutTraversing();
    }
}
