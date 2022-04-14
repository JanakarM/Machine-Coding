package design_1.model;

public class User {
    Integer id;
    String name;
    String email;
    User(Integer id, String name, String email){
        this.id=id;
        this.name=name;
        this.email=email;
    }

    public Integer getId() {
        return id;
    }
}
