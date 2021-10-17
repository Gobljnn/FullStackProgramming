
public class carDriver {

        public static void main(String[] args) {
            String stringcost;
            String stringprice;
            

            double cost = 5000;
            double mile = 10;
            String colour = "Silver";

            //new objects
            usedCar used1 = new usedCar (cost, mile);
            usedCar used2 = new usedCar (cost, mile);

            newCar new1 = new newCar (cost, colour);
            newCar new2 = new newCar (cost, colour);
            
            //Used Car 
            used1.getCost(cost);
            used1.getPrice();
            used1.getMile(mile);

            used2.getCost(cost);
            used2.getPrice();
            used2.getMile(mile);

            //new Car
            new1.getCost(cost);
            new1.getPrice();
            new1.getColour(colour);

            new2.getCost(cost);
            new2.getPrice();
            new2.getColour(colour);

            //checking for equality
            stringcost = Double.toString(used1.getCost(cost));
            stringprice = Double.toString(used1.getPrice());
            String [] converttingz = {stringcost, stringprice};

            System.out.println("Hello" + converttingz);
        

            // used1.parsing();



            if (used1.equals(used2)){   // if statement which does not work, our arguments are not strings I tried using " == " to compare but it wouldn't work I even tried
                    used1.display();    // to manually override in usedCar and newCar methods but it wasn't working I tried all week to get to work but I am actually lost.
            }

            if (new1.equals(new2)){
                new1.display();
            }

            else{
                System.out.println("They are not equal");
            }

            used1.display();
            used1.display2();

            new1.display();
            new2.display2();

            System.out.println(used1.getPrice());

            //System.out.println();

            
    } 
}
