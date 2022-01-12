import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    Einleser einleser;

    public Main(){
        einleser = new Einleser();
    }

    public static void main(String[] args) {

        Main program = new Main();
        program.run();
    }

    private void run() {
        Greetings();
    }

    public void Greetings(){
        System.out.println("");
        System.out.println("Welcome to our sorting program v.1.2.");
        System.out.println("");
        System.out.println("");
        chooseFile();
    }

    public void ClearCmd(){
        for (int i = 0; i < 50; i++){
            System.out.println("");
        }
    }

    public void chooseFile(){

        char fileChoice = ' ';

        System.out.println("Choose a file which will be sorted.");
        System.out.println("___________________________________");

        while (fileChoice == ' '){

            System.out.println("Press A - InvertedPartialSorted (1000)");
            System.out.println("Press B - InvertedPartialSorted (10000)");
            System.out.println("Press C - InvertedPartialSorted (100000)");
            System.out.println("Press D - Random (1000)");
            System.out.println("Press E - Random (10000)");
            System.out.println("Press F - Random (100000)");
            System.out.println("Press G - PartialSorted (1000)");
            System.out.println("Press H - PartialSorted (10000)");
            System.out.println("Press I - PartialSorted (100000)");
            fileChoice = einleser.readChar("> ", new char[]{'a','b','c','d', 'e', 'f', 'g', 'h', 'i'});
            fileChoice = Character.toUpperCase(fileChoice);

        }

        Initialize(fileChoice);

    }

    public void Initialize(char choice2){

        String fileName = "";
        int fileSize = 0;
        FileDat[] fileDats = new FileDat[9];

        FileDat file1 = new FileDat('A', "InversTeilsortiert1000.dat", 1000);
        FileDat file2 = new FileDat('B', "InversTeilsortiert10000.dat", 10000);
        FileDat file3 = new FileDat('C', "InversTeilsortiert100000.dat", 100000);
        FileDat file4 = new FileDat('D', "Random1000.dat", 1000);
        FileDat file5 = new FileDat('E', "Random10000.dat", 10000);
        FileDat file6 = new FileDat('F', "Random100000.dat", 100000);
        FileDat file7 = new FileDat('G', "Teilsortiert1000.dat", 1000);
        FileDat file8 = new FileDat('H', "Teilsortiert10000.dat", 10000);
        FileDat file9 = new FileDat('I', "Teilsortiert100000.dat", 100000);

        fileDats[0]= file1;
        fileDats[1]= file2;
        fileDats[2]= file3;
        fileDats[3]= file4;
        fileDats[4]= file5;
        fileDats[5]= file6;
        fileDats[6]= file7;
        fileDats[7]= file8;
        fileDats[8]= file9;


        for (int i = 0; i < 9; i++){
            if (choice2 == fileDats[i].getFileToken()){
                fileName = fileDats[i].getFileName();
                fileSize = fileDats[i].getFileSize();
            }
        }

        fillArray(fileName, fileSize);
    }

    public void fillArray(String filename, int fileSize){

        int[] arrayToSort = new int[fileSize];
        int cntr = 0;

        BufferedReader br = null;
        try {
            File file = new File("files\\" + filename); // java.io.File
            FileReader fr = new FileReader(file); // java.io.FileReader
            br = new BufferedReader(fr); // java.io.BufferedReader
            String line;
            while ((line = br.readLine()) != null) {
                arrayToSort[cntr] = Integer.parseInt(line);
                cntr++;
            }
        }
        catch(IOException e) { e.printStackTrace();}
        finally
        {
            try { if (br != null) br.close(); }
            catch(IOException e) { e.printStackTrace(); }
        }

        ChooseAlgorithm(arrayToSort);
    }

    public void ChooseAlgorithm(int[] arrayToSort){
        char algorithmChoice = ' ';

        ClearCmd();
        System.out.println("Choose algorithm, which will be tested.");

        while (algorithmChoice == ' '){

            System.out.println("Press A - QuickSort");
            System.out.println("Press B - RadixSort");
            System.out.println("Press C - SelectionSort");
            algorithmChoice = einleser.readChar("> ", new char[]{'a','b','c'});
            algorithmChoice = Character.toUpperCase(algorithmChoice);

        }
        if (algorithmChoice == 'A'){
            //QuickSort.sort(arrayToSort);
        }
        else if (algorithmChoice == 'B'){
            //RadixSort.sort(arrayToSort);
        }
        else if (algorithmChoice == 'C'){
            //SelectionSort.sort(arrayToSort);
        }
    }


}
