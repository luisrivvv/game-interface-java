import java.util.*;

class Main{
    public static void main(String[] args){
        mainMenu();
    }

    private static void mainMenu(){
        FileManager file = new FileManager();
        ArrayList <String> words = file.getWords();


        String userInput = "";

        while(!userInput.equals("x")){

            userInput = getUserInput();//scanner something 
        
            System.out.println("We got here4");
            processInput(userInput,words);
        }
    }

    private static String getUserInput(){

        String msg = "Current session score: 0\r\n" + //
        "1 - Concentration (level 1)\r\n" + //
        "2 - Hangman (level 1)\r\n" + //
        "w - Display word queue\r\n" + //
        "x - Exit\r\n" + //
        "Choose an option:";

        Scanner scnr = new Scanner(System.in);

        System.out.print(msg);
        String input = "";
        input = scnr.nextLine();
        System.out.println();

        boolean isValid = false;
        while (!isValid){
            if (input.length() == 1 && (input.contains("1") || input.contains("2") 
            || input.contains("w") || input.contains("x"))){

                isValid = true;
            }
            else{

                System.out.print(msg);
                input = scnr.nextLine();
                System.out.println();
            }
        }
        scnr.close();

        return input.toLowerCase();
    }

    private static boolean processInput(String input, ArrayList<String> words){

        switch(input.charAt(0)){

            case '1':
                break;

            case '2':
                play(words, "hangman");
                break;

            case 'w':
                break;

            default:
                System.out.println("The Game Will Exit.");

        }

        return false;
    }

    private static int play(ArrayList<String> words, String type){// This could be actually the only method we need even for concentrate. just change the type of instance 

        int score = -1;

        Game game = new Game();
        if (type.equals("hangman")){// We need the extends 
            game = new HangMan(words);
        }


        while(game.getGameState()){
            game.getUserInput();
        }

        score = game.getScore();
        return score;
    }

}