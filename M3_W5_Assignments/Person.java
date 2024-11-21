/************************************************************************
* Person.java
* Dammy 'Gobljnn' Adebayo
* Module 3_ Week 5 Assignment #2 - Ip Conversion   
*
* This program simulates the creation and display of Person objects.
*************************************************************************/

public class Person {
    String firstName = "John";
    String lastName = "Doe";
    static int numOfPeople = 0;  //Starting counter to see how many objects are created
    
    

    public Person (String firstName, String lastName){ //2-parameter constructor
        this.firstName = firstName;
        this.lastName = lastName;
        numOfPeople ++;
    }

    public Person (){  // 0-parameter constructor
        firstName = "John";
        lastName = "Doe";
    }

    public void setName(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        numOfPeople ++ ;
    }

    public void setFirst(String firstName){
        this.firstName = firstName;
    }

    public void setLast(String lastName){
        this.lastName = lastName;
        numOfPeople ++;
    }


    public void printFullName(){
        System.out.println(firstName + " " + lastName);
    }

    public static void main(String[] args) {
        Person person1 = new Person();
        person1.printFullName();

        Person person2 = new Person("Matt", "Thebo");
        person2.printFullName();

        person1.setFirst("Paul");
        person1.setLast("John");
        person1.printFullName();


        // Used to check to see if the counter works.
        
        // Person person3 = new Person ();
        // person3.setName("Dammy", "Adebayo");
        // person3.printFullName();


        System.out.println("Total number of people = " + numOfPeople);
    }
    
}
