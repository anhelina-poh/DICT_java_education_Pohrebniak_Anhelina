package CoffeeMachine;

@SuppressWarnings("all")
public class CoffeeMaker {
    public void checkCapability(int water, int milk, int beans, int neededCups) {
        int possibleCups = Math.min(water / 200, Math.min(milk / 50, beans / 15));

        if (possibleCups == neededCups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (possibleCups > neededCups) {
            int extra = possibleCups - neededCups;
            System.out.println("Yes, I can make that amount of coffee (and even " + extra + " more than that)");
        } else {
            System.out.println("No, I can make only " + possibleCups + " cups of coffee");
        }
    }
}