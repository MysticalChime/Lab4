import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;


public class Main {
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        int cardValue = 0;
        int gameNum = 1;
        int playerHand = 0;
        int dealerHand;
        int playerInput = 0;
        int playerCard1 = 0;
        int playerCard2 = 0;
        int numPlayerWins = 0;
        int numDealerWins = 0;
        int numTies = 0; // number of tie games
        double winPercent; // player's win percentage
        boolean game = true;

        Random rng = new Random(); //Random number generator

        while (game == true) {

            System.out.println("START GAME# " + gameNum);
            cardValue = rng.nextInt(13) + 1; // Generates number from 1-13

            switch (cardValue) {
                case 1:
                    playerHand = playerHand + 1;
                    System.out.println("Your card is an ACE!");
                    System.out.println("Your hand is: " + playerHand);
                    break;

                case 2:
                    playerHand = playerHand + 2;
                    System.out.println("Your card is a two!");
                    System.out.println("Your hand is: " + playerHand);
                    break;

                case 3:
                    playerHand = playerHand + 3;
                    System.out.println("Your card is a three!");
                    System.out.println("Your hand is: " + playerHand);
                    break;

                case 4:
                    playerHand = playerHand + 4;
                    System.out.println("Your card is a four!");
                    System.out.println("Your hand is: " + playerHand);
                    break;

                case 5:
                    playerHand = playerHand + 5;
                    System.out.println("Your card is a five!");
                    System.out.println("Your hand is: " + playerHand);
                    break;


                case 6:
                    playerHand = playerHand + 6;
                    System.out.println("Your card is a six!");
                    System.out.println("Your hand is: " + playerHand);
                    break;

                case 7:
                    playerHand = playerHand + 7;
                    System.out.println("Your card is a seven!");
                    System.out.println("Your hand is: " + playerHand);
                    break;

                case 8:
                    playerHand = playerHand + 8;
                    System.out.println("Your card is an eight!");
                    System.out.println("Your hand is: " + playerHand);
                    break;

                case 9:
                    playerHand = playerHand + 9;
                    System.out.println("Your card is a nine!");
                    System.out.println("Your hand is: " + playerHand);
                    break;

                case 10:
                    playerHand = playerHand + 10;
                    System.out.println("Your card is a ten!");
                    System.out.println("Your hand is: " + playerHand);
                    break;

                case 11:
                    playerHand = playerHand + 10;
                    System.out.println("Your card is a JACK!");
                    System.out.println("Your hand is: " + playerHand);
                    break;

                case 12:
                    playerHand = playerHand + 10;
                    System.out.println("Your card is a QUEEN!");
                    System.out.println("Your hand is: " + playerHand);
                    break;

                case 13:
                    playerHand = playerHand + 10;
                    System.out.println("Your card is a KING!");
                    System.out.println("Your hand is: " + playerHand);
                    break;

            }

            if (playerHand > 21) {
                System.out.println("You exceeded 21! You lose :(");
                numDealerWins = ++numDealerWins;
                ++gameNum;
                playerHand = 0;
                playerInput = 0;
            }

            if (playerHand == 21) {
                System.out.println("BLACKJACK! You won!");
                numPlayerWins = ++numPlayerWins;
                ++gameNum;
                playerHand = 0;
                playerInput = 0;
            }

            System.out.println("1. Get another card");
            System.out.println("2. Hold hand");
            System.out.println("3. Print statistics");
            System.out.println("4. Exit");
            System.out.println("Choose an option:");

            dealerHand = rng.nextInt(11) + 16; // Generates number from 16-26

            while ((playerInput != 1) & (playerInput != 2) & (playerInput != 3) & (playerInput !=4)) {

                try {
                    playerInput = Integer.parseInt(scanner.next());
                    if (playerInput > 4 || playerInput < 1) {
                        System.out.println("Invalid Input!");
                        System.out.println("Please enter an integer between 1 and 4");
                    }
                }
                catch (NumberFormatException n)
                {
                    System.out.println("Invalid Input!");
                    System.out.println("Please enter an integer between 1 and 4");
                }
            }

            switch (playerInput) {

                case 1:
                    playerInput = 0;
                    break;

                case 2:
                    System.out.println("Dealer's hand: " + dealerHand);
                    System.out.println("Your hand is: " + playerHand);
                    if (playerHand > dealerHand || dealerHand > 21) {
                        System.out.println("You win!");
                        numPlayerWins = ++numPlayerWins;
                        ++gameNum;
                        playerHand = 0;
                        playerInput = 0;
                    } else if (playerHand == dealerHand) {
                        System.out.println("It's a tie! No one wins!");
                        numTies = ++numTies;
                        ++gameNum;
                        playerHand = 0;
                        playerInput = 0;
                    } else if (playerHand > 21) {
                        System.out.println("You exceeded 21! You lose :(");
                        numDealerWins = ++numDealerWins;
                        ++gameNum;
                        playerHand = 0;
                        playerInput = 0;
                    } else if (dealerHand == 21 || dealerHand > playerHand) {
                        System.out.println("Dealer wins!");
                        numDealerWins = ++numDealerWins;
                        ++gameNum;
                        playerHand = 0;
                        playerInput = 0;
                    }
                    break;

                case 3:
                    gameNum = gameNum - 1;
                    winPercent = ((double)numPlayerWins / (double)gameNum)* 100.0;
                    System.out.println("Number of player wins: " + numPlayerWins);
                    System.out.println("Number of dealer wins: " + numDealerWins);
                    System.out.println("Number of tie games: " + numTies);
                    System.out.println("Percentage of Player wins: " + winPercent + "%");
                    gameNum = gameNum + 1;
                    break;

                case 4:
                    System.exit(0);
                    break;


            }
        }

        }

    }
