public class TestNodeList {
   public static void main(String[] args) {
      NodeList list = new NodeList();
      
      list.add("A");
      list.add("B");
      list.add("C");
      list.add("D");
      list.add("E");
      list.add("F");
      list.add("G");
      
      list.display();
      
      list.delete(6);
      list.delete(5);
      list.delete(4);
      list.delete(3);
      list.delete(2);
      list.delete(1);
      list.delete(1);
      
      list.display();
   }
}