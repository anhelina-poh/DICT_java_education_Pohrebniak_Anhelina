package CoffeeMachine;

@SuppressWarnings("all")
public class CoffeeMaker {
    private int water = 400;
    private int milk = 540;
    private int beans = 120;
    private int cups = 9;
    private int money = 550;

    public void printStatus() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }

    public void buyCoffee(int type) {
        switch (type) {
            case 1 -> { // espresso
                water -= 250;
                beans -= 16;
                cups -= 1;
                money += 4;
            }
            case 2 -> { // latte
                water -= 350;
                milk -= 75;
                beans -= 20;
                cups -= 1;
                money += 7;
            }
            case 3 -> { // cappuccino
                water -= 200;
                milk -= 100;
                beans -= 12;
                cups -= 1;
                money += 6;
            }
        }
    }

    public void addSupplies(int addWater, int addMilk, int addBeans, int addCups) {
        this.water += addWater;
        this.milk += addMilk;
        this.beans += addBeans;
        this.cups += addCups;
    }

    public void takeMoney() {
        System.out.println("I gave you " + money);
        money = 0;
    }
}