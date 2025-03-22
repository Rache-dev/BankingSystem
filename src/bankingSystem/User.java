package bankingSystem;
//import org.mindrot.jbcrypt.BCrypt;
public class User {

    private String username;
    private String hashedPassword;
    private String email;
    private Account account;

    public User(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.hashedPassword = password;
        this.account = new Account("ACC_" + account);
    }

    // Hash the password using BCrypt
    public String hashedPassword(String plainTextPassword) {
        return this.hashedPassword;
    }

    // Verify the password
    public String verifyPassword(String plainTextPassword) {
        return this.hashedPassword;
    }

    // Getters and Setters
    public String getUsername(){
       return username;
    }

    public void setUsername(String username){
        this.username = username;
    }
    public String getPassword(){
        return hashedPassword;
    }

    public Account getAccount() {
        return account;
    }

    public String getEmail() {
        return email;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + hashedPassword + '\'' + ", account='"+ account+
                '}';
    }
}