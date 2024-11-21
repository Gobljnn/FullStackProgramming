    public class Car {
    public double price = 0; // final price of the car
    public double cost = 0 ; // initial cost of the car

    public String stringcost;
    public String stringprice;
    
    
    public double getCost(double cost){ // constructor
        this.cost = cost;
        return this.cost;
    }

    public double getPrice () { // method
        this.price = this.cost * 2 ;
        return this.price;
    }

  
    public void display() {
        System.out.println("\nThe price of the car $"+ this.price);
        // System.out.print(converttingz);
    }
    
}
