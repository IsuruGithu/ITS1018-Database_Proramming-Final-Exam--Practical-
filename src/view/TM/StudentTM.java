/**
 * @author : Isuru Lakmal G K A
 * Date    : $(DATE)
 **/

package view.TM;

public class StudentTM {
    String Id;
    String Name;
    String Email;
    String Contact;
    String Address;
    String NIC;

    public StudentTM() {
    }

    public StudentTM(String id, String name, String email, String contact, String address, String NIC) {
        Id = id;
        Name = name;
        Email = email;
        Contact = contact;
        Address = address;
        this.NIC = NIC;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    @Override
    public String toString() {
        return "StudentTM{" +
                "Id='" + Id + '\'' +
                ", Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", Contact='" + Contact + '\'' +
                ", Address='" + Address + '\'' +
                ", NIC='" + NIC + '\'' +
                '}';
    }
}
