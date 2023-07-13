package machine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CoffeeMachine {
    private static final int ESPRESSO_WATER_PER_CUP = 250;
    private static final int ESPRESSO_COFFEE_PER_CUP = 16;
    private static final int ESPRESSO_PRICE = 4;

    private static final int LATTE_WATER_PER_CUP = 350;
    private static final int LATTE_MILK_PER_CUP = 75;
    private static final int LATTE_COFFEE_PER_CUP = 20;
    private static final int LATTE_PRICE = 7;

    private static final int CAPPUCCINO_WATER_PER_CUP = 200;
    private static final int CAPPUCCINO_MILK_PER_CUP = 100;
    private static final int CAPPUCCINO_COFFEE_PER_CUP = 12;
    private static final int CAPPUCCINO_PRICE = 6;

    private static final int CUP = 1;

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {




        int[] coffeeMachine = {550, 400, 540, 120, 9}; // money, water, milk, coffee, cups

        boolean isExit = false;

        while (isExit == false) {
            System.out.println("Write action (buy, fill, take, remaining, exit)");
            String action = SCANNER.nextLine();

            if (action.equals("remaining")) {
                remaining(coffeeMachine);
            }
            if (action.equals("exit")) {
                System.exit(0);
            }
            if (action.equals("buy")) {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                String buyAction = SCANNER.nextLine();
                if ( buyAction.equals("1")) {
                    makeEspresso(coffeeMachine);
                } else if (buyAction.equals("2")) {
                    makeLatte(coffeeMachine);
                } else if (buyAction.equals("3")) {
                    makeCappuccino(coffeeMachine);
                } else if (buyAction.equals("back")) {
                    isExit = false;
                    return;
                } else {
                    isExit = false;
                    return;
                }
            }
            if (action.equals("fill")) {
                System.out.println("Write how many ml of water you want to add:");
                int fillWater = SCANNER.nextInt();
                System.out.println("Write how many ml of milk you want to add:");
                int fillMilk = SCANNER.nextInt();
                System.out.println("Write how many grams of coffee beans you want to add:");
                int fillCoffee = SCANNER.nextInt();
                System.out.println("Write how many disposable cups you want to add:");
                int fillCups = SCANNER.nextInt();
                coffeeMachine[1] += fillWater;
                coffeeMachine[2] += fillMilk;
                coffeeMachine[3] += fillCoffee;
                coffeeMachine[4] += fillCups;
                continue;
            }
            if (action.equals("take")) {
                take(coffeeMachine);
                continue;
            }
            continue;
        }

    }
    public static int[] take(int[] coffeeMachine) {
        System.out.println("I gave you $" + coffeeMachine[0] );
        coffeeMachine[0] = 0;
        return coffeeMachine;
    }
    public static void remaining(int[] coffeeMachine) {
        System.out.println("The coffee machine has:");
        System.out.println(coffeeMachine[1] + " ml of water");
        System.out.println(coffeeMachine[2] + " ml of milk");
        System.out.println(coffeeMachine[3] + " g of coffee beans");
        System.out.println(coffeeMachine[4] + " disposable cups");
        System.out.println("$" + coffeeMachine[0] + " of money");
    }
    public static int[] makeEspresso(int[] coffeeMachine) {
        if (coffeeMachine[1] < ESPRESSO_WATER_PER_CUP) {
            System.out.println("You don't have enough water");
        } else if (coffeeMachine[3] < ESPRESSO_COFFEE_PER_CUP) {
            System.out.println("You don't have enough coffee");
        } else if (coffeeMachine[0] < ESPRESSO_PRICE) {
            System.out.println("You don't have enough money");
        } else if (coffeeMachine[4] < 1 ) {
            System.out.println("You don't have enough cups");
        } else {
            coffeeMachine[1] -= ESPRESSO_WATER_PER_CUP;
            coffeeMachine[3] -= ESPRESSO_COFFEE_PER_CUP;
            coffeeMachine[0] -= ESPRESSO_PRICE;
            coffeeMachine[4] -= 1;
            System.out.println("here's an espresso");
        }

        return coffeeMachine;
    }
    public static int[] makeLatte(int[] coffeeMachine) {
        if (coffeeMachine[1] < LATTE_WATER_PER_CUP) {
            System.out.println("You don't have enough water");
        } else if (coffeeMachine[3] < LATTE_COFFEE_PER_CUP) {
            System.out.println("You don't have enough coffee");
        } else if (coffeeMachine[0] < LATTE_PRICE) {
            System.out.println("You don't have enough money");
        } else if (coffeeMachine[4] < CUP ) {
            System.out.println("You don't have enough cups");
        } else if (coffeeMachine[2] < LATTE_MILK_PER_CUP ) {
            System.out.println("You don't have enough milk");
        }
        else {
            coffeeMachine[1] -= LATTE_WATER_PER_CUP;
            coffeeMachine[3] -= LATTE_COFFEE_PER_CUP;
            coffeeMachine[0] -= LATTE_PRICE;
            coffeeMachine[4] -= CUP;
            coffeeMachine[2] -= LATTE_MILK_PER_CUP;
            System.out.println("here's a latte");
        }

        return coffeeMachine;
    }
    public static int[] makeCappuccino(int[] coffeeMachine) {
        if (coffeeMachine[1] < CAPPUCCINO_WATER_PER_CUP) {
            System.out.println("You don't have enough water");
        } else if (coffeeMachine[3] < CAPPUCCINO_COFFEE_PER_CUP) {
            System.out.println("You don't have enough coffee");
        } else if (coffeeMachine[0] < CAPPUCCINO_PRICE) {
            System.out.println("You don't have enough money");
        } else if (coffeeMachine[4] < CUP) {
            System.out.println("You don't have enough cups");
        } else if (coffeeMachine[2] < CAPPUCCINO_MILK_PER_CUP) {
            System.out.println("You don't have enough milk");
        }
        else {
            coffeeMachine[1] -= CAPPUCCINO_WATER_PER_CUP;
            coffeeMachine[3] -= CAPPUCCINO_COFFEE_PER_CUP;
            coffeeMachine[0] -= CAPPUCCINO_PRICE;
            coffeeMachine[4] -= CUP;
            coffeeMachine[2] -= CAPPUCCINO_MILK_PER_CUP;
            System.out.println("here's a Cappuccino");
        }

        return coffeeMachine;
    }
}
