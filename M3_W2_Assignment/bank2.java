import java.util.Scanner;

public class bank2 {

    public static void main(String[] args) {
        long balance;
        long years = 0;
        long fyears = 0;
        long syears = 0;
        boolean fstage = false;
        boolean sstage = false;

            Scanner stdIn = new Scanner(System.in);
            System.out.println("Enter a number:");
            balance = stdIn.nextLong();


        while ((balance > 0) && (fstage == false) && (balance < 999_999))
        {
            balance *= 2;
            years++;

                if (balance >= 100_000)
                {   
                    fstage = true;
                    fyears = years;
                }
        }

        while ((balance > 100_000) && (sstage == false))
        {
            balance *= 2;
            years++;

                if (balance >= 1_000_000)
                {
                    sstage = true;
                    syears = years;
                }
        }

        if ((balance >= 1_000_000) && (fstage) && (sstage))
        {
           System.out.println("It will take you " + fyears + "hunny" + syears);
        }

        if ((balance >= 1_000_000) && (fstage == false) && (sstage == false))
        {
            // fstage = true;
            // sstage = true;
            System.out.println("My guy you already got $" + balance + " you don't need any more money " + 
                        " share some with me I got bills to pay ...please and thank you." + years);
        }
        else if (balance <= 0)
        {
            System.out.println("Bro... $" + balance + " you too broke, put some money in your account.");
        }
        stdIn.close();
    }
    
}

// boolean fstage = false;
// boolean sstage = false;

// balance = Long.parseLong(JOptionPane.showInputDialog("Enter your starting balance ($ - with no commas or symbols) : "));

// balance *= 2;

// while (balance > 0)
// {
//     if (balance >= 100_000)
//     {
//         JOptionPane.showMessageDialog(null,"It will take you " + years + " year(s) to make atleast $100,000");
//         years++;
//     }

//     if (balance >= 1_000_000)
//     {
//         JOptionPane.showMessageDialog(null,"It will take you " + years + " year(s) to make atleast $1,000,000");
//         years++;
//     }

//     years++;
// }

