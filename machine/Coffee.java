package machine;

public enum Coffee {
    ESPRESSO(1, 4, 250, 0, 16),
    LATTE(2, 7, 350, 75, 20),
    CAPPUCCINO(3, 6, 200, 100, 12);

    int option;
    int cost;
    int water;
    int milk;
    int beans;

    Coffee(int option, int cost, int water, int milk, int beans) {
        this.option = option;
        this.cost = cost;
        this.water = water;
        this.milk = milk;
        this.beans = beans;
    }

    public int getCost() {
        return cost;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getBeans() {
        return beans;
    }

    public static Coffee getCoffeeTypeByOption(int option) {
        for (Coffee value : values()) {
            if (value.option == option) {
                return value;
            }
        }
        return null;
    }
}
