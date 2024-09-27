package DASTRUC.LinkedLists;

class Stack {
    public static void main(String[] args) {
        List<String> list = new List<>();

        list.add("faa");
        list.add("fee");
        list.add("foo");
        list.add("fuu");
        list.add(2, "fii");

        list.remove(3);

        list.display();
    }
}