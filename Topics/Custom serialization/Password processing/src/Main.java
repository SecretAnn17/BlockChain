import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

class UserProfile implements Serializable {
    private static final long serialVersionUID = 26292552485L;

    private String login;
    private String email;
    private transient String password;

    public UserProfile(String login, String email, String password) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    // implement readObject and writeObject properly

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    private void writeObject(ObjectOutputStream oos) throws Exception {
        oos.defaultWriteObject();
        String encryptPassword = encrypt(password);
        oos.writeObject(encryptPassword);
    }

    private void readObject(ObjectInputStream ois) throws Exception {
        ois.defaultReadObject();
        password = decrypt((String) ois.readObject());
    }

    private String encrypt(String password) {
        String encriptedPass = "";
        for(int i=0; i<password.length(); ++i) {
            encriptedPass = encriptedPass+((char)(((int)password.charAt(i))+1));
        }
        return encriptedPass;
    }

    private String decrypt(String password) {
        String dencriptedPass = "";
        for(int i=0; i<password.length(); ++i) {
            dencriptedPass = dencriptedPass+((char)(((int)password.charAt(i))-1));
        }
        return dencriptedPass;
    }
}