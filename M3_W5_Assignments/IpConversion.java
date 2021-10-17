/************************************************************************
* IpConversion.java
* Dammy 'Gobljnn' Adebayo
* Module 3_ Week 5 Assignment #2 - Ip Conversion   
*
* This program stores an IP address as a dotted-decimal string and 
* as four octet ints. The four octects can then be retrieved.
*************************************************************************/

public class IpConversion {
    String dotDecimal = "192.168.0.1";  //IP address to be examined
    int firstOct = 0 ; 
    int secOct = 0;
    int thirdOct = 0;
    int fourthOct = 0;
    String oct;  // Where the Oct substring will be appended to
    

    public String getDotDecimal(String dotDecimal){
        return dotDecimal;
    }

    public int getOct(int octPosition){
        if (octPosition == 1){
            oct = dotDecimal.substring(0, 3);
            firstOct = Integer.parseInt(oct);
            return firstOct;
        }

        else if (octPosition == 2){
            oct = dotDecimal.substring(4, 7);
            secOct = Integer.parseInt(oct);
            return secOct;
        }

        else if (octPosition == 3){
            oct = dotDecimal.substring(8, 9);
            thirdOct = Integer.parseInt(oct);
            return thirdOct;
        }

        else if (octPosition == 4){
            oct = dotDecimal.substring(10);
            fourthOct = Integer.parseInt(oct);
            return fourthOct;
        }

        else{
            System.out.println("Please choose an octect within the range of 1 - 4");
        }
        
        return octPosition;
    }

    public static void main(String[] args) {
        IpConversion ip1 = new IpConversion();
        ip1.dotDecimal = "192.168.4.4";
        System.out.println(ip1.getDotDecimal(ip1.dotDecimal));

        System.out.println(ip1.getOct(4));
        System.out.println(ip1.getOct(1));
        System.out.println(ip1.getOct(3));
        System.out.println(ip1.getOct(2));
    }
    
    
}
