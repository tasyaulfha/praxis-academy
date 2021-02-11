public class Employee {
    private String firstName;
    private String lastName;
    private String type;
    private String id;
    private Address addrees;

    public Address getAddrees() {
        return addrees;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getType() {
        return type;
    }

   public String getId() {
        return id;
    }


    public void setAddrees(Address addrees) {
        this.addrees = addrees;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(String id) {
        this.id = id;
    }
}