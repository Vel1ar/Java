package myHomework.homework2.task3;

public class Item {
    private String name;
    private long vendor_code;
    private double price;
    private int quantity;
    private String color;

    public Item(String name, long vendor_code, double price, int quantity) {
        this.name = name;
        this.vendor_code = vendor_code;
        this.price = price;
        this.quantity = quantity;
    }
    public Item(String name, long vendor_code, double price, int quantity, String color) {
        this.name = name;
        this.vendor_code = vendor_code;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
    }
    public void getItem(){
        if(color == null){
            System.out.println(String.format("%s - %s - %s - %s", vendor_code, name, price, quantity));
        }else {
            System.out.println(String.format("%s - %s - %s - %s - %s", vendor_code, name, price, quantity, color));
        }
    }
}
