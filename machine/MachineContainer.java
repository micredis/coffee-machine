package machine;

import java.util.Scanner;

public class MachineContainer {
    private final int BIT_WATER = 200;
    private final int BIT_MILK = 50;
    private final int BIT_BEANS = 15;
    private int water;
    private int milk;
    private int beans;
    private long money;
    private int cups;
    private int cupsOrdered;

    public MachineContainer() {
    }

    public MachineContainer(int cupsOrdered) {
        this.water = cupsOrdered * BIT_WATER;
        this.milk = cupsOrdered * BIT_MILK;
        this.beans = cupsOrdered * BIT_BEANS;
        this.cupsOrdered = cupsOrdered;
    }

    // basically, it's a getter
    // take all the money form the machine's container
    public long takeMoney() {
        long moneyTaken = money;
        this.money = 0;
        return moneyTaken;
    }

    // basically, it's a setter
    public void takeWater(int amount) {
        this.water -= amount;
    }

    public void takeMilk(int amount) {
        this.milk -= amount;
    }

    public void takeBeans(int amount) {
        this.beans -= amount;
    }

    public void takeCups(int amount) {
        this.cups -= cups;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String calculateIngredientsByCups() {
        return String.format(
                "For %d cups of coffee you will need:%n" +
                        "%d ml of water%n" +
                        "%d ml of milk%n" +
                        "%d g of coffee beans%n",
                this.cupsOrdered, this.water, this.milk, this.beans
        );
    }

    public void putIngredients() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has:");
        this.water = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        this.milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        this.beans = scanner.nextInt();
    }

    public void setMachineContainerState(long money, int water, int milk, int beans, int cups) {
        this.money = money;
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
    }

    public void fillMachine(int water, int milk, int beans, int cups) {
        this.water += water;
        this.milk += milk;
        this.beans += beans;
        this.cups += cups;
    }

    public void fillMachineInteractive() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%nWrite how many ml of water you want to add:%n");
        this.water += scanner.nextInt();
        System.out.printf("Write how many ml of milk you want to add:%n");
        this.milk += scanner.nextInt();
        System.out.printf("Write how many grams of coffee beans you want to add:%n");
        this.beans += scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        this.cups += scanner.nextInt();
        System.out.println();
    }

    public void takeIngredients(Coffee coffee) {
        if (this.water < coffee.water) {
            System.out.printf("Sorry, not enough water!%n%n");
        } else if (this.milk < coffee.milk) {
            System.out.printf("Sorry, not enough milk!%n%n");
        } else if (this.beans < coffee.beans) {
            System.out.printf("Sorry, not enough beans!%n%n");
        } else if (this.cups < 1) {
            System.out.printf("Sorry, not enough cups!%n%n");
        } else {
            System.out.printf("I have enough resources, making you a coffee!%n%n");
            this.money += coffee.getCost();
            this.water -= coffee.water;
            this.milk -= coffee.milk;
            this.beans -= coffee.beans;
            this.cups--;
        }
    }

    public void setCupsOrdered(int cups) {
        this.cupsOrdered = cups;
    }

    public void checkCupsNeeded() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need:");
        this.cupsOrdered = scanner.nextInt();

        int waterForCups = water / BIT_WATER;
        int milkForCups = milk / BIT_MILK;
        int coffeeForCups = beans / BIT_BEANS;

        // how many cups of coffee can be made from the ingredients available
        int cupsAvailable = Math.min(waterForCups, Math.min(milkForCups, coffeeForCups));

        if (cupsAvailable == cupsOrdered) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (cupsAvailable < cupsOrdered) {
            System.out.printf("No, I can make only %d cup(s) of coffee%n", cupsAvailable);
        } else {
            System.out.printf(
                    "Yes, I can make that amount of coffee (and even %d more than that)%n",
                    (cupsAvailable - cupsOrdered)
            );
        }
    }

    @Override
    public String toString() {
        return String.format(
                "%nThe coffee machine has:%n" +
                        "%d ml of water%n" +
                        "%d ml of milk%n" +
                        "%d g of coffee beans%n" +
                        "%d disposable cups%n" +
                        "$%d of money%n",
                water, milk, beans, cups, money
        );
    }
}
