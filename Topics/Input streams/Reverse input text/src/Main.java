import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.CharBuffer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] ch = new char[50];
        int numberOfBytes = reader.read(ch);
        reader.close();
        for(int i = numberOfBytes-1; i >= 0; i--){
            System.out.print(ch[i]);
        }


    }
}