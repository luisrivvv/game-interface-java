import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class HangMan {// This is a good skeleton for a superclass

    private final static String message = "HANGMAN!!!";
    private int numOfLives;
    private boolean gameState;
    private ArrayList<String> words;
    private String chosenWord;
    private boolean[] revealedLetters;
    private boolean[] usedLetters;// The user cannot repeat the same letter
    private int score;

    public HangMan(ArrayList<String> words){
        this.words = words;
        this.gameState = true;
        this.numOfLives = 0;
        chosenWord = words.removeFirst();// get from array list
        revealedLetters = new boolean[chosenWord.length()];// True if we want to reveal the letter to the user
    }

    public int getScore(){
        return this.score;
    }
    
    public void checkGameState(){

        if (checkGameWon()){

            gameState = false;
        }

        if (numOfLives <= 0){

            this.gameState = false;

            System.out.println("Game Over!");
        }

    }

    private void getCurrRound(){// read a file to check which round we are at 

        FileManager files = new FileManager();

        String line = files.readInitialRound();

        String[] tokens = line.split("&");
    }

    public boolean getGameState(){
        return this.gameState;
    }

    public String getUserInput(){

        Scanner scnr = new Scanner(System.in);
        String input = null;

        while (!isValid(input)){

            input = scnr.nextLine().toLowerCase();
        }

        //scnr.close();
        return input;
    }

    private boolean isValid(String input){
        boolean valid = true;

        if (input == null){

            valid = false;
        }

        else if (input.length() != 1){

            System.out.println("Invalid input");
            valid = false;
        }
        
        else if (usedLetters[(int) input.charAt(0) - 61]){

            System.out.println("Letter already Chosen choose another Letter.");
            valid = false;
        }

        System.out.println("Choose a letter from A-Z");

        return valid;
    }

    public void processInput(String input){

        usedLetters[(int) input.charAt(0) -61] = true;

        if (!chosenWord.contains(input)){

            numOfLives--;
            
            checkGameState();
        }

        giveReveledLetters();
    }

    // Prints HANGMAN!!! or less
    public void printMessage(){

        for (int i = 0; i < numOfLives; i++){

            System.out.print(message.charAt(i));
        }

        System.out.println();
    }

    private void giveReveledLetters(){

        for (int i = 0; i < chosenWord.length(); i++){

            if (revealedLetters[i]){

                System.out.print(chosenWord.charAt(i));
            }

            else{

                System.out.print("_");
            }
        }
    }

    // Check if every letter is revealed
    public boolean checkGameWon(){

        boolean win = true;

        for (boolean correct: revealedLetters){

            if (!correct){

                win = false;
            }
        }
        return win;
    }
    //then maybe some private helper functions?
}

// Maybe do the randomize after you have the complete logic of the program 

// same thing with keeping track of the rounds 
// KEEP TRACK OF SCORE LEVEL ROUDNDS ETC 