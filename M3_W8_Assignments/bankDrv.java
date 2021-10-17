import javax.swing.JOptionPane;

/*******************************************************************************
* bankDrv.java
* Dammy 'Gobljnn' Adebayo
* Module 3_ Week 8  Assignment #2 - Bank Accounts  (Version 1)
*
* This program handles bank account balances for an several of bank accounts. 
* There are two types of bank accounts ─ checking and savings.
*
* This Driver Class file is meant to work with the class files (3) - CheckingAcct.java,
* SavingAcct.java, BankAcct.java
********************************************************************************/
public class bankDrv {
    
    public static void main(String[] args) {
        BankAcct[] accts = new BankAcct[100];
        boolean passed = false;

        BankAcct mainUser = new BankAcct(0);
        SavingAcct svgUser = new SavingAcct(0,0);
        CheckingAcct chkUser = new CheckingAcct(0);

        String mode = mainUser.setMode(); // terminal or dialog
        String difficulty = mainUser.setDifficulty(mode); //basic or advanced
        int acctNum = 0;

        if (difficulty == "Basic"){
            accts[0] = new SavingAcct(1100,0.05);  // index 0; savings
            accts[0].deposit(100);
            accts[0].withdraw(200);
            ((SavingAcct) accts[0]).addInt();
    
            accts[1] = new CheckingAcct(-100); //index 1; checkings
            accts[1].checkBalance();
            accts[1].deposit(50);
    
            accts[2] = new CheckingAcct(200); //index 2; checkings
            accts[2].withdraw(210);
            accts[2].deposit(100);
            ((CheckingAcct) accts[2]).writeCheck(50);
            
            for (int i=0; i<accts.length && accts[i] != null; i++){
                accts[i].display();
            }
        }

        else if (difficulty == "Advanced"){
            passed = false;
            int acct = 00; // exit
            double balance;
            double intRate;
            int bankOption;
            mainUser.initializeDB(); 

            // SavingAcct svg;

            while (passed == false){
                bankOption = mainUser.chooseOption(mode);  //options create, modify, print
                
                if (bankOption ==1){ //create
                    acct = mainUser.setAcct(mode); //savings or checkings

                    if (acct == 1){ // savings account
                        acctNum++;
                        mainUser.addAcctNumDBArr(acctNum);
                        balance = svgUser.advSavingAcct(mode, acctNum);
                        mainUser.setSavingsArr(balance);
                        intRate = svgUser.advIntRate(mode);
                        mainUser.setIntArr(intRate);
                        //accts[acctNum-1] = new SavingAcct(balance, intRate);
                        //passed = true;
                    }

                    else if (acct == 2){ //checkings
                        acctNum++;
                        mainUser.addAcctNumDBArr(acctNum);
                        balance = chkUser.advCheckingsAcct(mode, acctNum);
                        mainUser.setCheckingsArr(balance);
                    }
                }

                else if (bankOption == 2){ //modify acct
                    boolean validAcctSize = true;

                    if (validAcctSize == false){
                        validAcctSize = mainUser.advCheckAcctSize(mode);
                    }

                    else if (validAcctSize == true){
                        mainUser.advModifyAcct(mode);
                    }
                }
                mainUser.printArr();
            }
        }



        // accts[0] = new SavingAcct(1100,0.05);  // index 0; savings
        // accts[0].deposit(100);
        // accts[0].withdraw(200);
        // ((SavingAcct) accts[0]).addInt();

        // accts[1] = new CheckingAcct(-100); //index 1; checkings
        // accts[1].checkBalance();
        // accts[1].deposit(50);

        // accts[2] = new CheckingAcct(200); //index 2; checkings
        // accts[2].withdraw(210);
        // accts[2].deposit(100);
        // ((CheckingAcct) accts[2]).writeCheck(50);
        
        // for (int i=0; i<accts.length && accts[i] != null; i++){
        //     accts[i].display();
        // }
    } //end main
} // end Bank Driver Class
