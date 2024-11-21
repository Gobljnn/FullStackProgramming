// import java.util.Arrays;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class IpConversionC {
    Scanner stdIn = new Scanner(System.in);
    String dotDecimal = "192.168.0.1";
    int firstOct = 0 ;
    int secOct = 0;
    int thirdOct = 0;
    int fourthOct = 0;
    String oct;
    String preferred;
    String[] octect;
    String[] octi;

    String goAgain;
    Boolean tryAgain;
    String mode;

    //********************************************************************************

    public IpConversionC(String goAgain, Boolean tryAgain) {

        this.goAgain = goAgain;
        this.tryAgain = tryAgain;

    }

    //********************************************************************************

    public Boolean getTryAgain(String mode){

        if (mode.equals("1")){

            Boolean appropriate = true;

            while (appropriate == true){
                System.out.print("Would you like to input another IP Address? (y/n) : ");
                goAgain = stdIn.nextLine();

                if (goAgain.equalsIgnoreCase("y")){
                    System.out.println("Thank you for returning...");
                    appropriate = false;
                    return true;
                }
        
                else if (goAgain.equalsIgnoreCase("n")){
                    System.out.println("Thank you come again...");
                    appropriate = false;
                    return false;
                }
        
                else {
                    System.out.println("Please choose an appropriate value (y/n)");
                }
            }
        }

        else if (mode.equals("2")){
            Boolean appropriate = true;

            while (appropriate == true){
                goAgain = JOptionPane.showInputDialog(null, "Would you like to input another IP Address? (y/n) : ");

                if (goAgain.equalsIgnoreCase("y")){
                    JOptionPane.showMessageDialog(null, "Thank you for returning...");
                    appropriate = false;
                    return true;
                }
        
                else if (goAgain.equalsIgnoreCase("n")){
                    JOptionPane.showMessageDialog(null, "Thank you come again...");
                    appropriate = false;
                    return false;
                }
        
                else {
                    JOptionPane.showMessageDialog(null, "Please choose an appropriate value (y/n)");
                }
            }
        }
        return false;
    }
    //********************************************************************************

    public String getDotDecimal(String dotDecimal){
        return dotDecimal;
    }
    //********************************************************************************
    public void getOct(int octPosition, String[] octi, String mode){

        if (mode.equals("1")){
            if (octPosition == 1){
                this.octi = octi;
                System.out.println(octi[octPosition - 1]);
            }
    
            else if (octPosition == 2){
                this.octi = octi;
                System.out.println(octi[octPosition - 1]);
            }
    
            else if (octPosition == 3){
                this.octi = octi;
                System.out.println(octi[octPosition - 1]);
            }
    
            else if (octPosition == 4){
                this.octi = octi;
                System.out.println(octi[octPosition - 1]);
            }
    
            else{
                System.out.println("Please choose an octect within the range of 1 - 4");
            }
        }
    }
    //********************************************************************************

    public boolean dialogGetOct(String[] octi, String mode) {
        String a, b, c, d;

        a = octi[0];
        b = octi[1];
        c = octi[2];
        d = octi[3];

        JOptionPane.showMessageDialog(null,"Your IP Address is : " + Arrays.toString(octi) + "\n\nOctect 4: " + d + "\nOctect 1: " + a + "\nOctect 3: " + c + "\nOctect 2: " + b );
        return true;
    }
    //********************************************************************************

    public String getMode(String preferred){
        this.preferred = JOptionPane.showInputDialog(null, "* Running IP Conversion Program *" + "\n \n" + 
                                            "Would you prefer to work in the Terminal (1) or Dialog Box (2)");
        return this.preferred;
    }
    //********************************************************************************    

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        String preferred = "";
        Boolean firstTime = true;
        Boolean tryAgain = true;
        String goAgain = "y";

        IpConversionC user1 = new IpConversionC(goAgain, tryAgain);
        preferred = user1.getMode(preferred);

        while (preferred.equals("1") && tryAgain == true){

            if (firstTime == true){
                JOptionPane.showMessageDialog(null, "Terminal chosen, go to your IDE's terminal");
                firstTime = false;
            }

            IpConversionC ip1 = new IpConversionC(goAgain, tryAgain);
            System.out.print("What is your ip address? ");
            ip1.dotDecimal = stdIn.nextLine();

            System.out.println("Your IP Address is : " + ip1.getDotDecimal(ip1.dotDecimal));

            //////// Splitting Octect

            String[] octect =  (ip1.dotDecimal).split("\\.");
    
            /////// receiving octect
    
            System.out.print("Octect 4: ");
            ip1.getOct(4, octect, preferred);
            
            System.out.print("Octect 1: ");
            ip1.getOct(1, octect, preferred);

            System.out.print("Octect 3: ");
            ip1.getOct(3, octect, preferred);
            
            System.out.print("Octect 2: ");
            ip1.getOct(2, octect, preferred);

            tryAgain = ip1.getTryAgain(preferred);
        }

        while (preferred.equals("2") && tryAgain == true){
            if (firstTime == true){
                JOptionPane.showMessageDialog(null, "Dialog box chosen, please continue");
                firstTime = false;
            }

            IpConversionC ip1 = new IpConversionC(goAgain, tryAgain);
            ip1.dotDecimal = JOptionPane.showInputDialog(null,"What is your ip address? " );
            
            //JOptionPane.showMessageDialog(null, "Your IP Address is : " + ip1.getDotDecimal(ip1.dotDecimal));

            //////// Splitting Octect

            String[] octect =  (ip1.dotDecimal).split("\\.");
    
            /////// receiving octect

            ip1.dialogGetOct(octect, preferred);
            tryAgain = ip1.getTryAgain(preferred);
        }
        stdIn.close();  
    }
}
