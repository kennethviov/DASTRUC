class Node {
   String data;
   int index;
   Node next;
   
   public Node(String data, int index) {
      this.data = data;
      this.index = index;
      next = null;
   }
}

class NodeList {
   private Node head;
   private int count;
   
   public NodeList() {
      head = null;
      count = 0;
   }
   
   public boolean add(String data) {
      Node n = new Node(data, count);
      
      if (head == null) {
         head = n;
      } else {
         Node curr = head;
         while (curr.next != null) {
            curr = curr.next;
         }
         curr.next = n;
      }
      count++;
      return true;
   }
   
   public boolean delete(int location) {
      if (isEmpty()) {
         System.out.println("Cannot delete. List is Empty.");
         return false;
      }
      
      Node curr = head;
      Node prev = null;
      
      if (curr.index == location) {
         head = curr.next;
         count--;
         updateIndx();
         return true;
      }
      
      while (curr != null && curr.index != location) {
         prev = curr;
         curr = curr.next;
      }
      
      while (curr == null) {
         System.out.println("No node fount at location " + location);
         return false;
      }
      
      prev.next = curr.next;
      count--;
      updateIndx();
      return true;
   }
   
   public void display() {
      Node curr = head;
      if (!isEmpty()) {
         System.out.println("List:");
         while (curr != null) {
            System.out.println("[" + curr.index + "] " + curr.data);
            curr = curr.next;
         }
      } else {
         System.out.println("List is Empty");
      }
   }
   
   private boolean isEmpty() {
      return count == 0;
   }
   
   private void updateIndx() {
      Node curr = head;
      int idx = 0;
      
      while (curr != null) {
         curr.index = idx++;
         curr = curr.next;
      }
   }
}