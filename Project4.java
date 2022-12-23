import java.time.Year;
import java.util.*;

import javax.lang.model.util.ElementScanner14;

public class Project4 {
    public static void main (String[] args) throws InterruptedException
    {
        Scanner s = new Scanner(System.in);
        final String WILDCAT_ID = "859740790";
        final String LAST_NAME = "Lucas";
        final String PASSWORD = "CSNerd22";

        
/* 
        //username is first four letters of last name, and last four digits of ID
        String part1 = LAST_NAME.substring(0, 4);
        String part2 = WILDCAT_ID.substring(WILDCAT_ID.length() - 4, WILDCAT_ID.length());
        String user = part1 + part2; 
        System.out.println("Username generated: " + user);
        System.out.println();

        System.out.print("Please enter your username: ");
        String username = s.nextLine().toLowerCase();
        System.out.print("Please enter your password: ");
        String password = s.nextLine().toLowerCase();
        int numTries = 1;

        boolean validUsername = username.equals(user.toLowerCase());
        boolean validPassword = password.equals(password);

        while (!validUsername || !validPassword)
        {
            System.out.println("Username and/or password is invalid.");
            System.out.print("Please re-enter your username: ");
            username = s.nextLine().toLowerCase();
            System.out.print("Please re-enter your password: ");
            password = s.nextLine().toLowerCase();   
            numTries++;
            if (numTries == 3)
            {
                System.out.println("Invalid username and/or password entered 3 times.");
                System.out.println("EXITING PROGRAM...");
                validUsername = true;
                validPassword = true;
                return;
            }
        }

        */
        System.out.println("** Welcome to the 2022 Las Vegas Poker Festival! **");
        System.out.println();

        char response = 'y';
        while (response == 'y')
        {
            Thread.sleep(500);
            System.out.println("Shuffling cards...");
            Thread.sleep(500);
            System.out.println("Dealing cards...");
            System.out.println();
            Thread.sleep(500);
            System.out.println("Here are your 5 cards...");

            String[] suits = new String[5];
            String[] values = new String[5];
            int[] randomSuits = new int[5];
            int[] randomValues = new int[5];

            Random r = new Random();
            for (int i = 0; i < 5; i++)
            {
                boolean repeat = true;
                while (repeat)
                {
                    randomSuits[i] = r.nextInt(4) + 1;
                    randomValues[i] = r.nextInt(13) + 1;
                    repeat = false;
                    for (int j = 0; j < i; ++j)
                    {
                        if ((randomSuits[i] == randomSuits[j]) && (randomValues[i] == randomValues[j]))
                        {
                            repeat = true;
                        }
                    }
                }
            }
            String[] pokerSuits = {"Spades", "Clubs", "Hearts", "Diamonds"};
            String[] pokerValues = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
            Arrays.sort(randomSuits);
            Arrays.sort(randomValues);

            //assigns values and suits
            for (int i = 0; i < 5; ++i)
            {
                values[i] = pokerValues[randomValues[i] - 1];
                suits[i] = pokerSuits[randomSuits[i] - 1];
            }
            
            //printing all 5 cards dealt
            for (int i = 0; i < 5; ++i)
            {
                System.out.println(values[i] + " of " + suits[i]);
            }

            boolean royalFlush = false;
            boolean straightFlush = false;
            boolean fourOfAKind = false;
            boolean fullHouse = false;
            boolean flush = false;
            boolean straight = false;
            boolean threeOfAKind = false;
            boolean twoPairs = false;
            boolean onePair = false;

            // royal flush, striaght flush, normal flush;
            int sameSuit = 0;
            for (int i = 0; i < 5; ++i)
            {
                if (randomSuits[0] == randomSuits[i])
                {
                    sameSuit++;
                }
            }
            if (sameSuit == 5)
            {
                // normal flush
                flush = true;
                //royal flush
                int royalCount = 0;
                for (int i = 0; i < 5; ++i)
                {
                    if (randomValues[i] >= 10)
                    {
                        royalCount++;
                    }      
                }
                if (royalCount == 5)
                {
                    royalFlush = true;
                }                    
                //straight flush
                int sf = 0;
                for (int j = 0; j < 4; ++j)
                {
                    if (randomValues[j] == randomValues[j + 1] - 1)
                    {
                        sf++;
                    }
                }
                if (sf == 4)
                {
                    straightFlush = true;
                }
            }

            // full house, one pair, two pairs, four of a kind, three of a kind
            int count = 0;
            for (int i = 0; i <= 3; ++i)
            {
                for (int j = i; j <= 3; ++j)
                {
                    if (randomValues[i] == randomValues[j + 1])
                    {
                        count++;
                    }
                }
            }
            // four of a kind
            if (count > 4)
            {
                fourOfAKind = true;
            }
            // full house
            else if (count == 4)
            {
                fullHouse = true;
            }
            // three of a kind
            else if (count == 3)
            {
                threeOfAKind = true;
            }
            // two pair
            else if (count == 2)
            {
                twoPairs = true;
            }
            // one pair
            else if (count == 1)
            {
                onePair = true;
            }

            // straight
            int straightCount = 0;
            for (int j = 0; j < 4; ++j)
            {
                if (randomValues[j] == randomValues[j + 1] - 1)
                {
                    straightCount++;
                }
            }
            if (straightCount == 4)
            {
                flush = true;
            }    
            
            // highCard
            String highCard;
            if (values[0].equals("Ace"))
            {
                highCard = "Ace";
            }
            else
            {
                highCard = values[values.length - 1];
            }
                
            System.out.println();
            if (royalFlush)
            {
                System.out.println("You were dealt a royal flush!");
            }
            else if (straightFlush)
            {
                System.out.println("You were dealt a straight flush!");
            }
            else if (fourOfAKind)
            {
                System.out.println("You were dealt four of kind!");
            }
            else if (fullHouse)
            {
                System.out.println("You were dealt a full house!");
            }
            else if (flush)
            {
                System.out.println("You were dealt a flush!");
            }
            else if (straight)
            {
                System.out.println("You were dealt a straight!");
            }
            else if (threeOfAKind)
            {
                System.out.println("You were dealt a three of a kind!");
            }
            else if (twoPairs)
            {
                System.out.println("You were dealt two pairs!");
            }
            else if (onePair)
            {
                System.out.println("You were dealt one pair!");
            }
            else
            {
                System.out.println("High card is " + highCard + ".");
            }
            System.out.println();
            System.out.println();
            System.out.print("Play again? (y/n): ");
            response = s.nextLine().toLowerCase().charAt(0);
            System.out.println();
        }
    }
}