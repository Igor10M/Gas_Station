public class Gas implements GasStationItem {
    // Attributes
    protected double liters;

    // Constructor
    public Gas(double liters) {
        this.liters = liters;
    }

    // Method to display the details of gas
    public void displayDetails() {
        System.out.println("=====================================");
        System.out.println(liters + " liters of gas putin the vehicle.");
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
        return false;
    }

    // Override isGas method located in the interface
    @Override
    public boolean isGas() {
        return true;
    }
}
