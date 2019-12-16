
import java.util.Scanner;

public class QuickStart {
    public static int diceSides = 6;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of dice you'd like to use");
        int numOfDice = Integer.parseInt(input.nextLine());
        System.out.println("we're now rolling " + numOfDice + " of Dice");
        int[] dice = rollDice(numOfDice);
        System.out.println("you rolled the following dice");
        for(int i = 0; i < dice.length; i++){
            System.out.println(dice[i]);
        }
        System.out.println("now checking the score");
        int[] result = checkResults(dice);
        System.out.println("The best score you could have was with " + result[0] + " and you acheived a score of " + result[1]);
    }

    static int[] checkResults(int[] rolls) {
        int[] scoreList = new int[diceSides];
        for (int i = 0; i < diceSides; i++) {
            for (int j = 0; j < rolls.length; j++) {
                if (rolls[j] == i) {
                    scoreList[i]++;
                }
            }
            scoreList[i] = scoreList[i] * i;
        }
        int bestResultIndex = 0;
        for (int i = 1; i < diceSides; i++) {
            if (scoreList[i] > scoreList[bestResultIndex]) {
                bestResultIndex = i;
            }
        }
        int[] result = { bestResultIndex, scoreList[bestResultIndex] };
        return result;

    }

    static int[] rollDice(int numOfDice) {
        int[] rolledDice = new int[numOfDice];
        for (int i = 0; i < numOfDice; i++) {
            rolledDice[i] = (int)Math.round( Math.random() * (diceSides + 1));
        }
        return rolledDice;
    }

}