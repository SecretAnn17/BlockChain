package blockchain.utils;

import java.io.*;

public class SerializationUtils {

    public static void serialize(Object blockChain, File file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file, true);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(blockChain);
        oos.close();
    }

    public static Object deserialize(File file) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);
        Object obj = ois.readObject();
        ois.close();
        return obj;
    }
}
