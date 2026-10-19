package CoffeeMachine;

@SuppressWarnings("all")
public class CoffeeMaker {
    private int water = 400;
    private int milk = 540;
    private int beans = 120;
    private int cups = 9;
    private int money = 550;
    private State state = State.CHOOSING_ACTION;

    public enum State {
        CHOOSING_ACTION,
        CHOOSING_COFFEE,
        FILLING_WATER,
        FILLING_MILK,
        FILLING_BEANS,
        FILLING_CUPS
    }

    public void processInput(String input) {
        switch (state) {
            case CHOOSING_ACTION -> handleAction(input);
            case CHOOSING_COFFEE -> handleCoffeeChoice(input);
            case FILLING_WATER -> handleFillingWater(input);
            case FILLING_MILK -> handleFillingMilk(input);
            case FILLING_BEANS -> handleFillingBeans(input);
            case FILLING_CUPS -> handleFillingCups(input);
        }
    }

    private void handleAction(String input) {
        switch (input) {
            case "buy" -> {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back – to main menu:");
                System.out.print("> ");
                state = State.CHOOSING_COFFEE;
            }
            case "fill" -> {
                System.out.println("Write how many ml of water you want to add:");
                System.out.print("> ");
                state = State.FILLING_WATER;
            }
            case "take" -> {
                takeMoney();
                promptAction();
            }
            case "remaining" -> {
                printRemaining();
                promptAction();
            }
        }
    }

    // --- Калькуляція покупки з 5-го етапу ---
    private void handleCoffeeChoice(String input) {
        switch (input) {
            case "1" -> make(250, 0, 16, 4);
            case "2" -> make(350, 75, 20, 7);
            case "3" -> make(200, 100, 12, 6);
            case "back" -> {}
        }
        promptAction();
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

    // --- Калькуляція поповнення з 5-го етапу ---
    private void handleFillingWater(String input) {
        water += Integer.parseInt(input);
        System.out.println("Write how many ml of milk you want to add:");
        System.out.print("> ");
        state = State.FILLING_MILK;
    }

    private void handleFillingMilk(String input) {
        milk += Integer.parseInt(input);
        System.out.println("Write how many grams of coffee beans you want to add:");
        System.out.print("> ");
        state = State.FILLING_BEANS;
    }

    private void handleFillingBeans(String input) {
        beans += Integer.parseInt(input);
        System.out.println("Write how many disposable cups of coffee you want to add:");
        System.out.print("> ");
        state = State.FILLING_CUPS;
    }

    private void handleFillingCups(String input) {
        cups += Integer.parseInt(input);
        promptAction();
    }

    private void takeMoney() {
        System.out.println("I gave you " + money);
        money = 0;
    }

    public void promptAction() {
        state = State.CHOOSING_ACTION;
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        System.out.print("> ");
    }

    private void printRemaining() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }
}