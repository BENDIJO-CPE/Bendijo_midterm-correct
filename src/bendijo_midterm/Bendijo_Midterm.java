package bendijo_midterm;

import java.util.Scanner;

class Node {
        String data;
        Node next;
        
        Node (String m){
            data = m;
            next = null;
        }
    }
public class Bendijo_Midterm {



    
public static Node head, tail;
private int size;

 public Node insertNode (String data){
    Node newNode = new Node (data);
    newNode.next = head;
    head = newNode;
    return head;
    }
 
        public void displaySingly(){
         Node node = head;
         
      
            while (node != null){
                System.out.println(node.data+"");
                node = node.next;
     }
         System.out.println();
     }
        public boolean delete (String target) {
    Node current = head;
    Node prev = null;

    while (current != null) {
        if (current.data.equalsIgnoreCase(target)) {
            if (prev == null) {
                // If the product is the first node, update the head
                head = current.next;
            } else {
                prev.next = current.next;
            }
            size--;
            return true; // Product removed successfully
        }
        prev = current;
        current = current.next;
    }
    return false; // Product not found
}
        
     public boolean search (String target){
             Node current = head;
             
             while(current != null){
                 if (current.data.equals(target)){
                     return true;
                 }
                 current = current.next;
             }
             return false;
     }
    
    public int searchPosition(String target){
    Node current = head;
    int pos = 0;
        while (current != null) {            
            if (current.data.equalsIgnoreCase(target)) {
                return pos;
                
            }
            current = current.next;
            pos++;
        }
        return -1;
    }
       
    private Node createNewNode(String index) throws Exception {
        Node node = new Node(index);
        node.data = index;
        node.next = null;
        return node;
    }

    private void insertion(String index, int position) throws Exception {
        if (position < 0 || position > size) {
            throw new Exception("Invalid Index");
        } else if (position == 0) {
            insertBeginning(index);
        } else if (position == size) {
            insertEnd(index);
        } else {
            Node node = createNewNode(index);
            Node prev = getNodeAt(position - 1);
            node.next = prev.next;
            prev.next = node;
            tail.next = head;
            size++;
        }
    }

    private void insertBeginning(String index) throws Exception {
        Node node = createNewNode(index);
        if (size == 0) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        tail.next = head;
        size++;
    }

    private void insertEnd(String index) throws Exception {
        Node node = createNewNode(index);
        if (size > 0) {
            tail.next = node;
            tail = node;
        } else if (size == 0) {
            head = tail = node;
        }
        tail.next = head;
        size++;
    }
      public void displayCircular() throws Exception{
        if (size == 0) {
            throw new Exception("List is empty");
        }

        Node current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println();
     }
      private Node getNodeAt(int position) throws Exception {
        if (size == 0) {
            throw new Exception("Linked list is empty");
        } else if (position < 0 || position >= size) {
            throw new Exception("Invalid Position");
        } else {
            Node current = head;
            for (int i = 0; i < position; i++) {
                current = current.next;
            }
            return current;
        }
    }
    
    public static void main(String[] args) throws Exception {
        Bendijo_Midterm li = new Bendijo_Midterm ();
        
        Scanner scan = new Scanner(System.in);
        boolean number = true;
        
        while (number){
            
            System.out.println("\nNumber?? \n1. Classmates Name \n2. Sari-sari Store,");
                    
            int choice = scan.nextInt();
            
                if (choice  == 2){
                      li.insertNode("Fita");
                      li.insertNode("Pride Powder");
                      li.insertNode("Canola Oil");
                      li.insertNode("Fita");
                      li.insertNode("Nescafe Black Coffee");
                      li.insertNode("Ariel Powder");
                      li.insertNode("rebisco");
                      li.insertNode("Steel Wool");
                      li.insertNode("Head and Shoulder");
                      li.insertNode("Nova");
                      li.insertNode("tanduay");
                      li.insertNode("Bearbrand");
                      li.insertNode("nature Spring Mineral");
                      li.insertNode("Coke");
                      li.insertNode("Sprita kasalo");
                      li.insertNode("Royal");
                      li.insertNode("Sugar");
                
                   
                   boolean loop = true;
                   
                   while (loop){
                    System.out.println("What do you want?");
                    System.out.println("1. Ask or Search");
                    System.out.println("2. Display the products");
                    System.out.println("3.Go Back to MENU");
                    System.out.println("4. Add Products");
                   int hmn = scan.nextInt();
                   
                   
                   
                   if(hmn == 2){
                       li.displaySingly();
                       
                   }else if (hmn == 1){
                    System.out.println("Enter the product you want to search");
                    scan.nextLine();
                    String search = scan.nextLine();
                    
                    String targetVal = search;
        
                    int posi = li.searchPosition(targetVal);
        
                    if (posi != -1) {
                         System.out.println("The " + targetVal + " is here");
                     
                        System.out.println("Do you want to buy it?\n 1. Yes \n 2. No");
                        
                        int buy = scan.nextInt();
                        
                        switch (buy) {
                        case 1:
                            System.out.println("You Succesfully bought " + search);
                            li.delete(targetVal);
                            System.out.println(targetVal + " is sold \n");
                            break;
                            
                        case 2:
                            loop = true;
                            break;
                            
                        default:
                            throw new AssertionError();
                        }
                    } else {
                     System.out.println("The "+ targetVal + " is not here");
            
                            }

                                }else if(hmn == 3){
                                    loop = false;
                                 }else if (hmn == 4){
                                     System.out.println("Add products");
                                     scan.nextLine();
                                     String addproducts = scan.nextLine();
                                     
                                     li.insertNode(addproducts);
                                     System.out.println(addproducts + " added succesfully");
                                 }else {
                                    throw new Exception ("Invalid Input");
                                       }
                            }
                   
                   
                   }else if (choice == 1){
                    boolean nameloop = true;
                    
                    
                    while (nameloop) {
                    
                    System.out.println("1. Insert your Classmates Name");             
                    System.out.println("2. Display");
                        System.out.println("3. Go -> Menu");
                    int input = scan.nextInt();
                    
                    
                    switch (input){
                        case 1: 
                            System.out.println("Insert Name");
                            scan.nextLine();
                            String fullname = scan.nextLine();
                            System.out.println("Enter Position");
                            int position = scan.nextInt();
                            
                            li.insertion(fullname, position - 1);      
                            break;
                    
                        case 2:
                            System.out.println("Your classmate are : ");
                            li.displayCircular();
                            break;
                        case 3:
                            nameloop = false;
                            break;
                        default:
                            System.out.println("WRONG CHOICE");
                }
                    }
                    }else {
                               System.out.println("Invalid Choice \n TRY AGAIN");
                             }
    }
    
}
    }
    
