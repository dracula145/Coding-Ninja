class Base {
    public void show() {
        System.out.println("Base show");
    }
}
class Derived extends Base {
    public void show() { 
        System.out.println("Derived show");
    }
}
public class Solution {
    public static void main(String[] args) {
        Base b = new Derived();
        b.show();
    }
}