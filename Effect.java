
import java.io.*;
import java.nio.file.Files;


public class Effect {
    public static void main(String[] args) throws IOException {
        //reading the dat file using Files
        System.out.println("Trying to read input dat file");
        //the path can be changed according to user's file location
        String inpath="C:\\Users\\DELL\\Downloads\\Music\\assign3audio\\mysteryTones.dat";
        String[] lines = Files.readAllLines(new File(inpath).toPath()).toArray(new String[0]);

        // Array tim and ampr are created to hold the values of time and amplitudes
        double[] tim=new double[lines.length];
        double[] ampr=new double[lines.length];
        //Array header holds the file header
        String[] header = new String[2];
        //assigning values to header array
        header[0]=lines[0];
        header[1]=lines[1];
        //Filling in values of tim array by iterating through the dat file and readin git line by line
        for(int i=2;i<lines.length;i++) {
            String[] elements = lines[i].split("\\s+");
            tim[i]=Double.parseDouble(elements[1]);
        }

        //Filling in values of ampr array by iterating through the dat file and readin git line by line
        for(int i=2;i<lines.length;i++) {
            String[] elements = lines[i].split("\\s+");
            ampr[i]=Double.parseDouble(elements[2]);
        }


        System.out.println("Applying Distortion Filter");

        //applying distortion filter to ampr array values to perform hard clipping at values greater than 0.5 and less than -0.5
        for(int i=0;i<ampr.length;i++) {

            if(ampr[i]>0.5){
                ampr[i]=0.5;
            }
            else
                if(ampr[i]<-0.5){
                ampr[i]=-0.5;
            }
            else{
                continue;
                }
        }

        System.out.println("Writing new data to a new dat file");

        //Creating a new file named filteredoutput.dat to store the updated signal values after application of distortion filter
        //path of output file can be changed according to user
        String outpath="C:\\Users\\DELL\\Downloads\\Music\\assign3audio\\filteredoutput.dat";
        File file = new File(outpath);
        if(!file.exists())
        {
            boolean created = file.createNewFile();
        }

        //using BufferedWriter to write header lines data to output file filteredoutput.dat
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
        bufferedWriter.write(header[0]);
        bufferedWriter.newLine();
        bufferedWriter.write(header[1]);
        bufferedWriter.newLine();

        //using BufferedWriter to write time and amplitude values to output file filteredoutput.dat
        for (int i=0;i<ampr.length;i++){
            bufferedWriter.newLine();
            bufferedWriter.write(String.format("%.10f",tim[i])+ " " +String.format("%.10f",ampr[i]));
        }



    }
}
