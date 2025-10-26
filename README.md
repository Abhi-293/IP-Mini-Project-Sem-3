# Contact Manager Pro

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Project Modules](#project-modules)
- [Installation & Setup](#installation--setup)
- [Usage](#usage)
- [Development Notes](#development-notes)
- [Future Enhancements](#future-enhancements)
- [Functionality Explanation with Code Snippets](#functionality-explanation-with-code-snippets)
- [Contributing](#contributing)
- [License](#license)
- [Acknowledgments](#acknowledgments)

## Overview

**Contact Manager Pro** is a comprehensive mini project developed as part of the Industrial Practices Evaluation for Full Stack Development (FSD). This application demonstrates fundamental concepts in web development, including HTML structure, CSS styling, JavaScript DOM manipulation, and simulated backend integration with Java technologies. It serves as a practical showcase of building a responsive, interactive contact management system entirely in the browser.

The project simulates a full-stack application where the frontend communicates with a Java Spring Boot/Servlet API, fulfilling CRUD (Create, Read, Update, Delete) operations through client-side JavaScript functions that mimic API calls.

## Features

- **Contact Management (CRUD Operations)**
  - Add new contacts with name, email, phone, and company details
  - Edit existing contact information
  - Delete contacts with confirmation prompts
  - Unique ID generation for each contact (simulating database primary keys)

- **Search and Filtering**
  - Real-time search across contact names, emails, phone numbers, and companies
  - Instant filtering as you type

- **View Modes**
  - List view: Compact, row-based layout
  - Grid view: Card-based layout with visual icons
  - Smooth transitions between view modes

- **Responsive Design**
  - Mobile-first approach with Tailwind CSS
  - Adaptive layouts for desktop, tablet, and mobile devices
  - Custom scrollbar styling for enhanced aesthetics

- **User Experience Enhancements**
  - Fade-in animations for contact entries
  - Hover effects and transitions
  - Modal dialogs for add/edit operations
  - Keyboard shortcuts (Esc to close modals)
  - Empty state messaging when no contacts are found
  - Direct calling for contacts with phone numbers (click-to-call functionality)

- **Simulated Backend Integration**
  - Mock API calls to Java endpoints (`/api/contacts`)
  - Asynchronous operations with Promise-based functions
  - Console logging for API simulation tracking

## Technologies Used

- **HTML5**: Semantic structure and accessibility
- **CSS3**: Custom styling with Tailwind CSS framework
- **JavaScript (ES6+)**: DOM manipulation, event handling, and async operations
- **Tailwind CSS**: Utility-first CSS framework for responsive design
- **Lucide Icons**: Modern, scalable icon library
- **Google Fonts (Inter)**: Clean, professional typography
- **Simulated Java Backend**: Spring Boot/Servlet API concepts demonstrated through JavaScript

## Project Modules

The application is structured around educational modules demonstrating different aspects of full-stack development:

### Module 1 & 2: Java/OOP Concepts via JavaScript Analogues
- Demonstrates object-oriented programming principles
- Data structures and methods mirroring Java classes
- Unique ID generation (analogous to database auto-increment)
- Array manipulation for data persistence

### Module 3: HTML Structure & CSS Styling
- Semantic HTML5 markup
- Tailwind CSS for modern, responsive styling
- Custom color palette and typography
- CSS animations and transitions

### Module 4: JavaScript & DOM Manipulation
- Dynamic content rendering
- Event-driven programming
- Form handling and validation
- Real-time UI updates

### Module 6: Frontend/Java Integration
- Simulated RESTful API interactions
- Asynchronous JavaScript with Promises
- CRUD operations mapping to HTTP methods
- Error handling and logging

## Installation & Setup

1. **Prerequisites**
   - Modern web browser (Chrome, Firefox, Safari, Edge)
   - Internet connection for loading external resources (Tailwind CSS, Lucide Icons, Google Fonts)
   - Java Development Kit (JDK) 8 or higher for running the backend (optional)

2. **Running the Application**

   ### Frontend Only (Client-Side)
   - Clone or download the project files
   - Open `index.html` in your web browser
   - No build process or server required - it's a client-side application

   ### With Local Server (Recommended)
   - Start a local HTTP server in the project root directory:
     ```
     python -m http.server 8000
     ```
   - Open your browser and navigate to `http://localhost:8000/index.html`

   ### Backend (Java)
   - Compile the Java files:
     ```
     javac backend/*.java
     ```
   - Run the ContactManager:
     ```
     java -cp backend ContactManager
     ```
   - The backend demonstrates CRUD operations and can be integrated with the frontend for full-stack functionality

3. **File Structure**
   ```
   IP-Mini-Project-Sem-3/
   ├── index.html    # Main application file
   ├── README.md     # This documentation
   ├── assets/
   │   ├── css/
   │   │   └── styles.css    # Additional custom styles
   │   └── js/
   │       └── script.js     # JavaScript logic for DOM manipulation
   └── backend/
       ├── Contact.java      # Contact model and service class
       ├── ContactManager.java # Main class for backend operations
       ├── ContactService.class
       └── *.class           # Compiled Java classes
   ```

## Usage

### Getting Started
1. Open `index.html` in your browser
2. The application loads with an empty contact list (ready for adding new contacts)
3. Use the interface to manage your contacts

### Adding Contacts
- Click the "Add Contact" button (green with user-plus icon)
- Fill in the required fields (Name and Email are mandatory)
- Optional: Phone number and Company
- Click "Save Contact" to add

### Editing Contacts
- Click the edit button (pen icon) on any contact
- Modify the information in the modal
- Save changes

### Deleting Contacts
- Click the delete button (trash icon) on any contact
- Confirm the deletion in the popup dialog

### Searching Contacts
- Use the search bar at the top
- Type to filter contacts by name, email, phone, or company
- Results update in real-time

### Switching Views
- Use the toggle buttons to switch between List and Grid views
- List view: Compact rows
- Grid view: Visual cards

### Keyboard Shortcuts
- **Esc**: Close any open modal dialogs

## Development Notes

- **Data Persistence**: Currently uses in-memory storage. In a production environment, this would connect to a real database via the Java backend.
- **API Simulation**: All backend calls are mocked. Replace the `fetch` calls with actual API endpoints for full integration.
- **Performance**: Optimized for small to medium contact lists. For larger datasets, consider pagination and server-side filtering.
- **Security**: Client-side validation only. Server-side validation should be implemented in the Java backend.

## Future Enhancements

- Real database integration with Java Spring Boot
- User authentication and authorization
- Contact import/export functionality
- Advanced filtering and sorting options
- Contact groups/categories
- Email integration for contact communication
- Mobile app version using React Native or similar

## Functionality Explanation with Code Snippets

### 1. Contact Management (CRUD Operations)

The application provides full CRUD functionality for managing contacts. Here's how each operation works:

#### Create Operation
When adding a new contact, the form data is collected and sent to the simulated API:

```javascript
// From assets/js/script.js - Form submission handler
// This function handles both adding new contacts and updating existing ones
// Uses async/await for asynchronous API calls, demonstrating modern JavaScript
document.getElementById('contact-form').onsubmit = async (event) => {
    event.preventDefault(); // Prevents default form submission behavior

    // Extract form data using DOM API
    const id = document.getElementById('contact-id').value;
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const phone = document.getElementById('phone').value;
    const company = document.getElementById('company').value;

    // Create contact object using object literal syntax
    const contactData = { name, email, phone, company };

    try {
        if (id) {
            // Update operation - spreads existing data with new values
            await apiUpdateContact({ ...contactData, id });
        } else {
            // Create operation - adds new contact
            await apiAddContact(contactData);
        }

        closeContactModal(); // Close the modal dialog
        filterContacts(); // Re-render the UI with updated data
    } catch (error) {
        console.error("Failed to save contact:", error);
        alert("Error saving contact. Check console for details.");
    }
};
```

The `apiAddContact` function simulates a POST request to the backend:

```javascript
// Simulates RESTful API POST request for creating new contacts
// Demonstrates asynchronous programming and data persistence
async function apiAddContact(contactData) {
    console.log('API Call: POST /api/contacts - Simulating Java Backend');
    // Spread operator creates new object with unique ID
    const newContact = { ...contactData, id: generateUniqueId() };
    contacts.push(newContact); // Add to in-memory array
    saveContacts(); // Persist to browser's localStorage
    return Promise.resolve(newContact); // Return resolved promise
}
```

#### Read Operation
Contacts are loaded on application startup and displayed in the UI:

```javascript
// Simulates RESTful API GET request for retrieving all contacts
// Demonstrates data persistence using browser's localStorage API
async function fetchContacts() {
    console.log('API Call: GET /api/contacts - Simulating Java Backend');

    // Attempt to load persisted data from localStorage
    const stored = localStorage.getItem('contacts');
    if (stored) {
        contacts = JSON.parse(stored); // Parse JSON string back to array
    } else {
        // Initialize empty array if no stored data exists
        contacts = [];
    }
    return Promise.resolve(contacts); // Return promise for async consistency
}
```

#### Update Operation
Editing a contact reuses the same form but pre-fills the data:

```javascript
// Modal management function that handles both add and edit modes
// Demonstrates conditional logic and DOM manipulation for dynamic UI
async function openContactModal(contactId = null) {
    // ... modal setup code ...

    if (contactId) {
        // Edit Mode - Find existing contact using array.find() method
        const contact = contacts.find(c => c.id === contactId);
        if (contact) {
            title.textContent = `Edit Contact: ${contact.name}`;
            // Pre-fill form fields with existing contact data
            document.getElementById('contact-id').value = contact.id;
            document.getElementById('name').value = contact.name;
            document.getElementById('email').value = contact.email;
            document.getElementById('phone').value = contact.phone;
            document.getElementById('company').value = contact.company;
        }
    } else {
        // Add Mode - Reset form for new contact
        title.textContent = 'Add New Contact';
    }

    // Show modal using Tailwind CSS classes
    modal.classList.remove('hidden');
    modal.classList.add('flex');
}
```

#### Delete Operation
Deletion includes a confirmation dialog:

```javascript
// Handles contact deletion with user confirmation
// Demonstrates error handling and user interaction patterns
async function confirmDelete(id, name) {
    // Browser's built-in confirm dialog for user safety
    if (window.confirm(`Are you sure you want to delete contact for ${name}? This action cannot be undone.`)) {
        try {
            await apiDeleteContact(id); // Call simulated API
            console.log(`Deleted contact ID: ${id}`);
            filterContacts(); // Re-render UI to reflect changes
        } catch (error) {
            console.error("Failed to delete contact:", error);
            alert("Error deleting contact. Check console for details.");
        }
    }
}
```

### 2. Search and Filtering

Real-time search filters contacts as you type:

```javascript
// Implements real-time search functionality using array.filter()
// Demonstrates functional programming concepts and case-insensitive matching
function filterContacts() {
    // Get search input and convert to lowercase for case-insensitive search
    const searchTerm = document.getElementById('search-input').value.toLowerCase();
    // Filter contacts array based on multiple fields
    const filtered = contacts.filter(contact =>
        contact.name.toLowerCase().includes(searchTerm) ||
        contact.email.toLowerCase().includes(searchTerm) ||
        contact.company.toLowerCase().includes(searchTerm) ||
        contact.phone.toLowerCase().includes(searchTerm)
    );
    renderContacts(filtered); // Re-render UI with filtered results
}
```

### 3. View Modes

The application supports both list and grid views with smooth transitions:

```javascript
// Toggles between list and grid view modes
// Demonstrates dynamic CSS class manipulation and responsive design
function setViewMode(mode) {
    currentViewMode = mode;
    // Update button styling (omitted for brevity)
    // ...
    renderContacts(contacts); // Re-render with new layout
}

// Main rendering function that handles both view modes
// Uses conditional rendering and CSS Grid/Flexbox for layouts
function renderContacts(displayContacts = contacts) {
    const container = document.getElementById('contact-container');

    // Apply different Tailwind CSS classes based on view mode
    if (currentViewMode === 'grid') {
        // CSS Grid layout with responsive columns
        container.className = 'grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-6';
    } else {
        // Flexbox layout for list view
        container.className = 'space-y-4';
    }

    // Render each contact with staggered animation
    displayContacts.forEach((contact, index) => {
        const contactElement = currentViewMode === 'grid'
            ? createGridCard(contact) // Card layout for grid
            : createListRow(contact); // Row layout for list
        // Staggered fade-in animation
        contactElement.style.animationDelay = `${index * 0.05}s`;
        container.appendChild(contactElement);
    });

    lucide.createIcons(); // Initialize Lucide icons
}
```

### 4. Java Backend Integration

The Java backend demonstrates OOP principles and CRUD operations:

```java
// From backend/Contact.java - Contact Model Class
// Demonstrates encapsulation, constructors, and UUID for unique identification
public class Contact {
    // Private fields - encapsulation principle
    private String id;
    private String name;
    private String email;
    private String phone;
    private String company;

    // Constructor with parameters (excluding id which is auto-generated)
    public Contact(String name, String email, String phone, String company) {
        this.id = UUID.randomUUID().toString(); // Generate unique identifier
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.company = company;
    }

    // Getters and setters would be implemented here for encapsulation
    // Getters allow read access, setters allow controlled write access
}

// ContactService Class - Business Logic Layer
// Demonstrates service pattern and collection management
class ContactService {
    // In-memory storage using Java Collections Framework
    private List<Contact> contacts = new ArrayList<>();

    // Create operation - adds new contact and returns it
    public Contact addContact(String name, String email, String phone, String company) {
        Contact contact = new Contact(name, email, phone, company);
        contacts.add(contact); // Add to collection
        return contact; // Return for confirmation
    }

    // Other CRUD methods would include:
    // - Read: getAllContacts(), getContactById()
    // - Update: updateContact()
    // - Delete: deleteContact()
}

### 5. Direct Calling

The application includes direct calling functionality for contacts with phone numbers. When a contact has a phone number, a call button appears next to the contact, allowing users to initiate a call directly from the browser (on mobile devices or systems with telephony support).

```javascript
// From assets/js/script.js - Call button in list view
// Template literal with conditional rendering using ternary operator
// Demonstrates string interpolation and conditional logic in template literals
${contact.phone ? `<a href="tel:${contact.phone}" title="Call Contact" class="p-2 text-green-400 rounded-full hover:bg-gray-700 transition"><i data-lucide="phone" class="w-5 h-5"></i></a>` : ''}
```

This uses the `tel:` URI scheme, which opens the default phone application on the user's device when clicked. The conditional operator (`? :`) ensures the call button only renders when a phone number exists, demonstrating defensive programming practices.

## Contributing

This is an educational mini project. For improvements or modifications:
1. Fork the repository
2. Make your changes
3. Test thoroughly
4. Update documentation as needed

## License

This project is developed for educational purposes as part of the Industry Practices - JAVA course. Feel free to use and modify for learning purposes.

## Acknowledgments

- Tailwind CSS for the excellent utility-first framework
- Lucide for beautiful, consistent icons
- Google Fonts for the Inter typeface
- The open-source community for inspiration and tools

---

**Contributors**: Abhishek Vishwakarma, Sanchita Warkad, Diya Tailor
<br>
**Course**: Industrial Practices - Full stack JAVA development course
<br>
**Institution**: Thakur College of Engineering and Technology (TCET)
<br>
**Date**: October 2025
