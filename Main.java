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

      int policeDistance = rand.nextInt(21) + 70;
      
      if(userChoice.equalsIgnoreCase("a")){
        if(currency < 50){
          System.out.println("You don't have enough money.");
        }
        else{
          currency -= 50;
          gasTank = 25;
        }
      }
      if(userChoice.equalsIgnoreCase("b")){ // Moderate Speed
        //milesTraveled += 8*Math.random() + 5;
        milesTraveled += rand.nextInt(11) + 60; //MIN: 60+ 0 = 60 MAX:10 + 60 = 70
        System.out.println("You have traveled: " + milesTraveled);
        gasTank -= rand.nextInt(3) + 2; // decrease our gastank by random number between 2 and 4
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
        hunger = 0;
        System.out.println("The Hunger value: " +  hunger);
        policeTraveled += policeDistance;
      }
      if(userChoice.equalsIgnoreCase("e")){
        System.out.println("Miles Traveled " + milesTraveled);
        System.out.println("You have " + currency + " dollars");
        System.out.println("Hunger: "+ hunger);
        System.out.println("The natives are " + (milesTraveled - policeTraveled) + " miles behind you");
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
        System.out.println("Your camel dead. You lose!");
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