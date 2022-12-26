# Poker-Game
In order to play the poker game, the user must enter the generated username and password. The username is generated using the first four digits of the user's last name, and the last four digits of the user's ID. The user's last name and ID are assigned using constants. If the user enters an invalid username or password combination 3 times, the program exits. The username is not case sensitive, but the password is case sensitive. Once the user enters the username and password correctly, the poker game can be played. Two players are each dealt 5 random cards each. Then the program assigns the highest classification to each hand. The classifications, from highest to lowest, are as follows:

Royal Flush (all same suit, sequence 10-J-K-Q-A)
Straight Flush (all same suit, ANY five-card sequence)
Four of a Kind (Ex: 4-Jacks or 4-five’s)
Full House (3 of a kind and 2 of a kind – Ex: 3-Jacks and 2-five’s)
Flush (all the same suit)
Straight (ANY 5-card sequential sequence)
Three of a Kind (Ex: 3-Jacks or 3-five’s)
Two pairs (Ex: 2-Kings and 2-three’s)
A pair (Ex: 2-Kings or 2-three’s)
High Card

The player with the highest classification wins the game. If both players have the same classification, the game ends in a tie. The program will loop as long as the user wants to play again.
