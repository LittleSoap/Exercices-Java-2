import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Exercice2{

    public Exercice2(){}

    BufferedReader reader;

    public void readFile(String text) throws IOException {

        reader = new BufferedReader(new FileReader(text));
        List<Integer> arrayList = new ArrayList<Integer>();

        String line;

        line = reader.readLine();

        while(line != null){

            int score = Integer.parseInt(line.split(":")[1]);

            System.out.println(line);
            System.out.println(score);
            arrayList.add(score);
            line = reader.readLine();
        }

        int moyenne = 0;

        for(int i = 0; i<arrayList.size(); i++){
            moyenne += arrayList.get(i);
        }

        moyenne /= arrayList.size();

        System.out.println("Moyenne : " + moyenne);



    }

    public void getExecutionTime(String text, String email)throws IOException{

        Instant start = Instant.now();


        this.getStudentGrade(text, email);


        Duration duration = Duration.between(start,Instant.now());
        System.out.println("Temps d'exécution du programme : " + duration.toString().substring(2).replaceAll("(\\d[HMS])(?!$)", "$1 ").toLowerCase());


    }


    public void getStudentGrade(String text, String email) throws IOException{

        reader = new BufferedReader(new FileReader(text));
        String line = reader.readLine();
        String score = "";

        while(line != null){

            if(line.split(":")[0].equals(email)){
                score = line.split(":")[1];
            }

            line = reader.readLine();

        }

        if(score.equals("")){
            System.out.println("Pas de note trouvée pour " + email);
        }else{
            System.out.println("Note pour " + email + " : " + score);
        }

    }



}