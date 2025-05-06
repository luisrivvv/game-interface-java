import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
// Could use this class to read curr words, and keep track of rounds score and etc. Also make a write method?? 
public class FileManager {

    private final static String progressFile = "fileContents.txt";//Maybe we need to write a file ourselves?
    private final static String wordsFile = "";
    private ArrayList<String> words;

    public FileManager(){
        words = new ArrayList<>();
        readWords();

    }

    private void readWords() {
        try{

            BufferedReader reader = new BufferedReader(new FileReader(wordsFile));

            String line = reader.readLine();

            while(line != null){

                words.add(line);
            }

            reader.close();

        }catch(IOException e){

            System.out.println(e.getMessage());

        }
        
    }

    //Check first if the file exists if not write it 
    public String readInitialRound () {
        String lastValue = null;

        try{

            BufferedReader reader = new BufferedReader(new FileReader(progressFile));

            String line = reader.readLine();
            
        
            while(line != null){
                lastValue = line;
            }

            reader.close();

        }catch(IOException e){

            System.out.println(e.getMessage());

        }

        return lastValue;
    }

    public void writeProgressToFile(String progress){

    }

    //Should I clone or not? 
    public ArrayList<String> getWords(){// We need to shuffle the words. And yes we probably need to clone since words are reused
        return words;
    }

    
}


