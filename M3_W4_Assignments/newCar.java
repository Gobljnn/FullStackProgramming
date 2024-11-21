public class newCar extends Car{
    String colour = "" ;

    public void getColour(String colour) {
        this.colour = colour ;
    }
    // public boolean equals(Object obj){
    //     usedCar a = (usedCar) obj;

    //     if (this.mile != a.mile){
    //         return false;
    //     }

    //     if (this.getMile(mile) != (a.getMile(mile))){
    //         return false;
    //     }
    //     if (this.price != (a.getPrice())){
    //         return false;
    //     }

    //     else {
    //         return true;
    //     }
    
    // }


    ////////////////////////

    // @Override
    // // equals() takes an Object as the method parameter
    // public boolean equals(Object obj) {
        
    //   if (obj != null && obj instanceof Class) {
    //     Class someObj = (Class) obj;
    //     // if (this.price == someObj.price)
    //     // Checks whether the objects have the same 'name'
    //     return this.name == someObj.name;
    //   } else {
    //     return false;
    //   }
    // }





    ////////////////////////
    

    public newCar(double cost, String colour){
        this.cost = cost;
        this.colour = colour;
    }

    public void display2() {
       System.out.println("The colour of the new car is " + this.colour);
    }
}
