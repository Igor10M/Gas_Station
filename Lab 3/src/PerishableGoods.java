abstract class PerishableGoods {
    // Attributes
    protected String expiryDate;
    protected int calories;

    // Constructor
    public PerishableGoods(String expiryDate, int calories) {
        this.expiryDate = expiryDate;
        this.calories = calories;
    }
}

class Chocolate extends PerishableGoods implements GasStationItem {
    // Attribute
    private String name;

    // Constructor
    public Chocolate(String expiryDate, int calories, String name) {
        super(expiryDate, calories);
        this.name = name;
    }

    // Override method to display the details of the chocolate bar
    @Override
    public void displayDetails() {
        System.out.println("=====================================");
        System.out.println("The " + name + " chocolate bar has " + calories + " calories.");
        System.out.println("The chocolate bar will expiry in: " + expiryDate);
    }

    // Override isChocolate method located in the interface
    @Override
    public boolean isChocolate() {
        return true;
    }

    // Override isSandwich method located in the interface
    @Override
    public boolean isSandwich() {
        return false;
    }

    // Override isCoffee method located in the interface
    @Override
    public boolean isCoffee() {
        return false;
    }

    // Override isGas method located in the interface
    @Override
    public boolean isGas() {
        return false;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for calories
    public int getCalories() {
        return calories;
    }
}

class Sandwich extends PerishableGoods implements GasStationItem {
    // Attribute
    private String size;
    private String typeOfSandwich;
    private double price;

    // Constructor
    public Sandwich(String expiryDate, int calories, String size, String typeOfSandwich, double price) {
        super(expiryDate, calories);
        this.size = size;
        this.typeOfSandwich = typeOfSandwich;
        this.price = price;
    }

    // Override method to display the details of the sandwich
    @Override
    public void displayDetails() {
        System.out.println("=====================================");
        System.out.println("The " + size + " " + typeOfSandwich + " sandwich has " + calories + " calories.");
        System.out.println("The sandwich will expiry in: " + expiryDate);
    }

    // Override isChocolate method located in the interface
    @Override
    public boolean isChocolate() {
        return false;
    }

    // Override isSandwich method located in the interface
    @Override
    public boolean isSandwich() {
        return true;
    }

    // Override isCoffee method located in the interface
    @Override
    public boolean isCoffee() {
        return false;
    }

    // Override isGas method located in the interface
    @Override
    public boolean isGas() {
        return false;
    }

    // Getter for name
    public String getSize() {
        return size;
    }

    // Getter for calories
    public String getTypeOfSandwich() {
        return typeOfSandwich;
    }

    // Getter for price
    public double getPrice() {
        return price;
    }

    // Getter for calories
    public int getCalories() {
        return calories;
    }
}

class Coffee extends PerishableGoods implements GasStationItem {
    // Attribute
    private String size;

    // Constructor
    public Coffee(String expiryDate, int calories, String size) {
        super(expiryDate, calories);
        this.size = size;
    }

    // Override method to display the details of the coffee
    @Override
    public void displayDetails() {
        System.out.println("=====================================");
        System.out.println("The " + size + " coffee has " + calories + " calories.");
        System.out.println("The coffee will expiry in: " + expiryDate);
    }

    // Override isChocolate method located in the interface
    @Override
    public boolean isChocolate() {
        return false;
    }

    // Override isSandwich method located in the interface
    @Override
    public boolean isSandwich() {
        return false;
    }

    // Override isCoffee method located in the interface
    @Override
    public boolean isCoffee() {
        return true;
    }

    // Override isGas method located in the interface
    @Override
    public boolean isGas() {
        return false;
    }
}