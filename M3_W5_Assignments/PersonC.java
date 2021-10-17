public class PersonC {
    String firstName = "John";
    String lastName = "Doe";
    static int numOfPeople = 0;
    
    

    public PersonC (String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        numOfPeople ++;
    }

    public PersonC (){
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
        PersonC person1 = new PersonC();
        person1.printFullName();

        PersonC person2 = new PersonC("Matt", "Thebo");
        person2.printFullName();

        person1.setFirst("Paul");
        person1.setLast("John");
        person1.printFullName();

        PersonC person3 = new PersonC();
        person3.setName("Dammy", "Adebayo");
        person3.printFullName();


        System.out.println("Total number of people = " + numOfPeople);
    }
    
}
