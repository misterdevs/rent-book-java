package entities.members;

public class Member {
    private String id;
    private String name;
    private String address;

    public Member() {

    }

    public Member(String id, String name, String addrees) {
        this.id = id;
        this.name = name;
        this.address = addrees;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        String string = "[" + this.id + "," + this.name + "," + this.address + "]";
        return string;
    }

}
