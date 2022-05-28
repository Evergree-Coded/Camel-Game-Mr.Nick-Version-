import java.util.Random;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();

    // Default Values
    int milesTraveled = 0;
    int gasTank = 25;
    int hunger = 0;
    int policeTraveled = -20;
    int currency = rand.nextInt(201) + 100;
    boolean stillPlaying = true;

    //Moderate Distance
    //Bank Robbers: 60-70 Miles
    //Police:

    //Fast Distance
    //Bank Robbers: 90-100 Miles
    //Police:

    while(stillPlaying){
      // Menu
      System.out.println("A) Go to a Gas Station");
      System.out.println("B) Ahead at Moderate Speed");
      System.out.println("C) Ahead at Full Speed");
      System.out.println("D) Stop for McDonald's");
      System.out.println("E) Status Check");
      System.out.println("Q) Quit");
      System.out.println("Choose an option from above: ");
      String userChoice = scan.nextLine(); // take in user input

      int policeDistance = rand.nextInt(21) + 50;
      
      if(userChoice.equalsIgnoreCase("a")){
        if(currency < 50){
          System.out.println("You don't have enough money.");
          System.out.println("Would you like to rob the gas station? Yes or No");
          String answer = scan.nextLine();
          if(answer.equals("Yes")){
            int moneyStolen = rand.nextInt(51) + 50;
            currency += moneyStolen;
            policeTraveled += policeDistance / 6;
            System.out.println("No way! You stole: " + moneyStolen + " dollars!");
            System.out.println("Your current balance is: " + currency + " dollars.");
          }
        }
        else{
          currency -= 50;
          gasTank = 25;
          policeTraveled += policeDistance / 6;
        }
      }
      if(userChoice.equalsIgnoreCase("b")){ // Moderate Speed
        //milesTraveled += 8*Math.random() + 5;
        milesTraveled += rand.nextInt(11) + 60; //MIN: 60+ 0 = 60 MAX:10 + 60 = 70
        System.out.println("You have traveled: " + milesTraveled);
        gasTank -= rand.nextInt(3) + 2; // decrease our gasTank by random number between 2 and 4
        hunger += 2;
        policeTraveled += policeDistance;
      }
      if(userChoice.equalsIgnoreCase("c")){ // Fast Speed
        milesTraveled += rand.nextInt(11) + 90;
        System.out.println("You have traveled: " + milesTraveled);
        gasTank -= rand.nextInt(3) + 4; // rand.nextInt(Max - Min + 1) + Min
        hunger += 2; 
        policeTraveled += policeDistance;
      }
      if(userChoice.equalsIgnoreCase("d")){
        if(currency < 5){
          System.out.println("You don't have enough money for Mcdonald's");
          System.out.println("Would you like to rob the Mcdonalds? Yes or No");
          String answer = scan.nextLine();
          if(answer.equals("Yes")){
            int moneyStolen = rand.nextInt(51) + 50;
            currency += moneyStolen;
            policeTraveled += policeDistance / 6;
            System.out.println("No way! You stole: " + moneyStolen + " dollars!");
            System.out.println("Your current balance is: " + currency + " dollars.");
          }
          
        }
        else{
          currency -= 5;
          hunger = 0;
          System.out.println("The Hunger value: " +  hunger);
          policeTraveled += policeDistance / 6;
        }
        
      }
      if(userChoice.equalsIgnoreCase("e")){
        long size = Math.round((10 * gasTank) / 25.0); // 10 slashes
        System.out.println("Miles Traveled " + milesTraveled);
        System.out.println("You have " + currency + " dollars");
        System.out.println("Hunger: "+ hunger);
        System.out.println("The police are " + (milesTraveled - policeTraveled) + " miles behind you");
        System.out.print("Your gas tank is at: " + gasTank + " gallons. ");
        System.out.print("[");
        for(long i = 0; i < 10; i++){
          if(i < size){
            System.out.print("/");
          }
          else{
            System.out.print(" ");
          }
        }
        System.out.println("]");
      }
      if(userChoice.equalsIgnoreCase("q")){
        stillPlaying = false;
      }
      
      if(milesTraveled >= 1300){
        stillPlaying = false;
        System.out.println("You won!");
      }

      if(gasTank >= 4 && gasTank <= 6){
        System.out.println("You need to fill up on Gas!");
      }

      if(gasTank <= 0){
        System.out.println("Gas tank is empty! You Lose");
        stillPlaying = false;
      }
      
      if(hunger >= 5 && hunger <= 8){
        System.out.println("You are hungry!");
      }

      if(hunger > 8){
        stillPlaying = false;
        System.out.println("You starved to death. You lose!");
      }

      if(milesTraveled - policeTraveled <= 70){
        System.out.println("While you are driving, you see red and blue flashes in the rearview mirror. SIRENS!! It's the police in the distance! ");
      }

      if(milesTraveled <= policeTraveled){
        System.out.println("You got caught by the police. You lose!");
        stillPlaying = false;
      }
      
    }
    System.out.println("You traveled " + milesTraveled + " miles.");
  }
}