package blockchain.utils;

import java.io.File;
import java.nio.file.Files;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.List;

public class SignUtil {

    private List<byte[]> list;

    //The constructor of Message class builds the list that will be written to the file.
    //The list consists of the message and the signature.
    public SignUtil(String data, String keyFile) throws InvalidKeyException, Exception {
        list = new ArrayList<byte[]>();
        list.add(data.getBytes());
        list.add(sign(data, keyFile));
    }

    public static byte[] sign(String data, String keyFile) throws InvalidKeyException, Exception{
        Signature rsa = Signature.getInstance("SHA1withRSA");
        rsa.initSign(getPrivate(keyFile));
        rsa.update(data.getBytes());
        return rsa.sign();
    }

    public static PrivateKey getPrivate(String filename) throws Exception {
        byte[] keyBytes = Files.readAllBytes(new File(filename).toPath());
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }
}
