import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws Exception {
       /* BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String rawText =  reader.readLine().trim();
        if(rawText.isEmpty()){
            System.out.print(0);
        } else {
            String[] text = rawText.split("\\s+");
            System.out.print(text.length);
        }
        reader.close();*/

        int[] message = new int[] {114, 101, 97, 100, 32, 97, 98, 111, 117, 116, 32, 65, 83, 67, 73, 73};

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        for (int code : message) {
            outputStream.write(code);
        }

        System.out.println(outputStream.toString());
    }
}