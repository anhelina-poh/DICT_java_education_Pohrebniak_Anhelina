package CoffeeMachine;

@SuppressWarnings("all")
public class CoffeeMaker {
    public void calculateIngredients(int cups) {
        int water = cups * 200;
        int milk = cups * 50;
        int beans = cups * 15;

        System.out.println("For " + cups + " cups of coffee you will need:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + " g of coffee beans");
    }
}