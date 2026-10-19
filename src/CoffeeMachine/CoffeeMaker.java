package CoffeeMachine;

@SuppressWarnings("all")
public class CoffeeMaker {
    private int water = 400;
    private int milk = 540;
    private int beans = 120;
    private int cups = 9;
    private int money = 550;

    public void printRemaining() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }

    private boolean checkResources(int reqWater, int reqMilk, int reqBeans) {
        if (water < reqWater) {
            System.out.println("Sorry, not enough water!");
            return false;
        }
        if (milk < reqMilk) {
            System.out.println("Sorry, not enough milk!");
            return false;
        }
        if (beans < reqBeans) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        }
        if (cups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
            return false;
        }
        return true;
    }

    public void buyCoffee(String type) {
        switch (type) {
            case "1" -> make(250, 0, 16, 4);
            case "2" -> make(350, 75, 20, 7);
            case "3" -> make(200, 100, 12, 6);
            case "back" -> {}
        }
    }

    private void make(int reqWater, int reqMilk, int reqBeans, int price) {
        if (checkResources(reqWater, reqMilk, reqBeans)) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= reqWater;
            milk -= reqMilk;
            beans -= reqBeans;
            cups -= 1;
            money += price;
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