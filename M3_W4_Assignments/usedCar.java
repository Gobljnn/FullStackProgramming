public class usedCar extends Car{
    double mile = 0 ;
    

    //Creating override equals method (which does not work) I have no idea what to do.


    public boolean equals(Object obj){
        usedCar a = (usedCar) obj;

        if (this.mile != a.mile){
            return false;
        }

        if (this.getMile(mile) != (a.getMile(mile))){
            return false;
        }
        if (this.price != (a.getPrice())){
            return false;
        }

        else {
            return true;
        }
    }

    public double getMile(double mile) { // method
        this.mile = mile ;
        return this.mile;
    }
    
    public usedCar (double cost, double mile){ //constructor
        this.mile = mile;
        this.cost = cost;
    }

    public void display2() {
       System.out.println("The mileage of the used car is " + this.mile + "KM");
    }
}
