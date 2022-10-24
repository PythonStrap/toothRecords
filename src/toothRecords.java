import java.util.Scanner;
public class toothRecords {
    private static final Scanner keyboard  = new Scanner(System.in);
    private static final int MAXIMUM_NUM_IN_FAMILY = 6;
    private static final int MAX_NUMBER_OF_TEETH = 8;

    private static final int MIN_NUM_OF_ROWS = 2;
//===================================================================

    public static void main(String[] args) {
//-------------- Create variables
        int numOfFamilyMembers = 0;
        String names = " ", upperTeeth = " ", lowerTeeth = " ";
        char [][][] familyTeethNum;
        char incisors = 'I', bicuspids = 'B', missingTeeth = 'M';



//----------- Display welcome message
welcomeMessage();

//----------- Get number of people in family
numOfFamilyMembers = getNumberOfMembers(numOfFamilyMembers);

//----------- Get names of family numbers
        String familyNames [ ] = new String [numOfFamilyMembers] ;
memberNameAndTeeth(numOfFamilyMembers);
//-----------Display menu
        dentalRecordsMenu(upperTeeth,lowerTeeth);

//=============================================================================

    }
//-----------------Welcome the user
    public static void welcomeMessage(){
        System.out.println("Welcome to the Floridian Tooth Records\n" + "-------------------------------------");
    }
 //------------Method to get number of family members form user
public static int getNumberOfMembers(int numInFamily){
    System.out.println("Please enter number of people in the family :");
    numInFamily = keyboard.nextInt();
    while(numInFamily <=0 || numInFamily > MAXIMUM_NUM_IN_FAMILY) {
        System.out.println("Invalid number of people, try again");
         numInFamily = keyboard.nextInt();
    }
    memberNameAndTeeth(numInFamily);
    char upperTeeth = (char)numInFamily;
    char lowerTeeth = (char) numInFamily;

    String[] allNames = new String [numInFamily];
    char [][][] familyTeethNum = new char [numInFamily][MIN_NUM_OF_ROWS][MAX_NUMBER_OF_TEETH];
    return numInFamily;
}
//-------------- Method to get family member's names
public static String memberNameAndTeeth( int numInFamily){
        String [] allNames = new String [numInFamily];
        String upperTeeth = " ";
        String lowerTeeth;
      char [][][] familyTeethNum = new char[numInFamily][MIN_NUM_OF_ROWS][MAX_NUMBER_OF_TEETH];
        for(int i = 0; i < numInFamily; i++) {
            System.out.println("Please enter the name of family member " + (i + 1));
            allNames[i] = keyboard.next();

            System.out.println("Please enter the uppers for " + allNames[i] + ": ");
            upperTeeth = keyboard.next();
            upperTeeth = upperTeeth.toUpperCase();
            System.out.println(upperTeeth);

            for(int row = 0; row < upperTeeth.length(); row++){
                while(upperTeeth.charAt(row) != 'I' && upperTeeth.charAt(row) != 'B' && upperTeeth.charAt(row) != 'M'){
                    System.out.println("Invalid teeth types, try again : ");
                    upperTeeth = keyboard.next();
                    upperTeeth = upperTeeth.toUpperCase();
                }
                while(upperTeeth.length() > MAX_NUMBER_OF_TEETH ){
                    System.out.println("Too many teeth, try again : ");
                    upperTeeth = keyboard.next();
                    upperTeeth = upperTeeth.toUpperCase();
                }
            }

            System.out.println("Please enter the lowers for " + allNames[i] + ": ");
            lowerTeeth = keyboard.next();
            lowerTeeth = lowerTeeth.toUpperCase();
            System.out.println(lowerTeeth);

            for(int column = 0; column < lowerTeeth.length(); column++){
                while(lowerTeeth.charAt(column) != 'I' && upperTeeth.charAt(column) != 'B' && upperTeeth.charAt(column) != 'M'){
                    System.out.println("Invalid teeth types, try again : ");
                    lowerTeeth = keyboard.next();
                    lowerTeeth = lowerTeeth.toUpperCase();
                }
                while(lowerTeeth.length() > MAX_NUMBER_OF_TEETH ){
                    System.out.println("Too many teeth, try again : ");
                    lowerTeeth = keyboard.next();
                    lowerTeeth = lowerTeeth.toUpperCase();
                }
            }
        }

        return upperTeeth;
}

//---------------Dental Record Menu
    public static char dentalRecordsMenu(String upperTeeth, String lowerTeeth){
        System.out.println("(P)rint, (E)xtract, (R)oot, e(X)it  :");
        char dentalMenuInput = ((keyboard.next()).toUpperCase()).charAt(0);

        while(dentalMenuInput != 'X'){
            System.out.println(upperTeeth);
            switch(dentalMenuInput){
                case 'P':
                    System.out.println("Uppers");
                    for(int row = 0; row < MAXIMUM_NUM_IN_FAMILY; row++){
                        System.out.println((row +1) + ":" + upperTeeth.charAt(row) + " ");
                        break;
                    }
                case'E':
                    //getNumberOfMembers(MAXIMUM_NUM_IN_FAMILY);
                   //for (int row = 0; row < allNames.length; row++) {
                case 'R':

                case 'X':
                    System.out.println("Exiting the Floridian Tooth Records :-)");
                    while (dentalMenuInput != 'P' && dentalMenuInput != 'E' && dentalMenuInput != 'R'){
                        System.out.println("Invalid menu option, try again          :");
                    }
            }
        }
        return dentalMenuInput;
    }
}