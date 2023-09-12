package online_shopping_system;

public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String newValue) {
        name = newValue;
    }

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String newValue) {
        email = newValue;
    }

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String newValue) {
        password = newValue;
    }

    // Constructor
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
