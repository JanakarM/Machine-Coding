package model;

public class User {
    int id;
    String name;
    String email;
    public User(int id, String name, String email){
        this.id=id;
        this.name=name;
        this.email=email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
