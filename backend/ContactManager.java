/**
 * Main Class - Demonstrates usage of the Contact Management System
 * This would typically be a REST Controller in a Spring Boot application
 */
public class ContactManager {
    public static void main(String[] args) {
        ContactService service = new ContactService();

        // Demo CRUD operations
        System.out.println("=== Contact Manager Demo ===");

        // Add some contacts
        Contact c1 = service.addContact("Alina Sharma", "alina.sharma@example.com", "98765 43210", "Tech Innovators");
        Contact c2 = service.addContact("Ravi Verma", "ravi.verma@consult.net", "99001 23456", "Global Consult");
        Contact c3 = service.addContact("Priya Singh", "priya.singh@design.org", "87654 32109", "Creative Hub");

        // Display all contacts
        System.out.println("\nAll Contacts:");
        service.getAllContacts().forEach(System.out::println);

        // Search contacts
        System.out.println("\nSearch results for 'tech':");
        service.searchContacts("tech").forEach(System.out::println);

        // Update a contact
        service.updateContact(c1.getId(), "Alina Sharma", "alina.sharma@newcompany.com", "98765 43210", "New Tech Corp");

        // Delete a contact
        service.deleteContact(c2.getId());

        System.out.println("\nFinal Contacts:");
        service.getAllContacts().forEach(System.out::println);
    }
}