import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Contact Model Class - Represents a contact entity
 * Demonstrates OOP principles: Encapsulation, Constructors, Getters/Setters
 */
public class Contact {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String company;

    // Constructor
    public Contact(String name, String email, String phone, String company) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.company = company;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    @Override
    public String toString() {
        return "Contact{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}

/**
 * ContactService Class - Handles business logic for contacts
 * Demonstrates Service Layer pattern and CRUD operations
 */
class ContactService {
    private List<Contact> contacts = new ArrayList<>();

    // CREATE
    public Contact addContact(String name, String email, String phone, String company) {
        Contact contact = new Contact(name, email, phone, company);
        contacts.add(contact);
        System.out.println("Added contact: " + contact);
        return contact;
    }

    // READ ALL
    public List<Contact> getAllContacts() {
        return new ArrayList<>(contacts);
    }

    // READ BY ID
    public Optional<Contact> getContactById(String id) {
        return contacts.stream()
                .filter(contact -> contact.getId().equals(id))
                .findFirst();
    }

    // UPDATE
    public boolean updateContact(String id, String name, String email, String phone, String company) {
        Optional<Contact> contactOpt = getContactById(id);
        if (contactOpt.isPresent()) {
            Contact contact = contactOpt.get();
            contact.setName(name);
            contact.setEmail(email);
            contact.setPhone(phone);
            contact.setCompany(company);
            System.out.println("Updated contact: " + contact);
            return true;
        }
        return false;
    }

    // DELETE
    public boolean deleteContact(String id) {
        Optional<Contact> contactOpt = getContactById(id);
        if (contactOpt.isPresent()) {
            contacts.remove(contactOpt.get());
            System.out.println("Deleted contact with ID: " + id);
            return true;
        }
        return false;
    }

    // SEARCH/FILTER
    public List<Contact> searchContacts(String searchTerm) {
        return contacts.stream()
                .filter(contact ->
                    contact.getName().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    contact.getEmail().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    contact.getCompany().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    (contact.getPhone() != null && contact.getPhone().contains(searchTerm))
                )
                .toList();
    }
}
