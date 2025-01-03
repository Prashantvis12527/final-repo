

import java.util.Scanner;
// Interface: Defines a blueprint for a class with methods that must be implemented.
interface camera {
    void takesnap(); // Abstract method: Must be implemented by the class.

    void recordvideo(); // Abstract method: Must be implemented by the class.

    private void greet() { 
        // Private method: Can only be used within this interface.
        System.out.println("Good Morning");
    }

    default void record4kvideo() { 
        // Default method: Provides a default implementation. 
        // Can be overridden by implementing classes.
        greet(); // Calls the private method within the interface.
        System.out.println("Recording in 4k...");
    }
}

// Interface: Used to define networking-related methods.
interface Mywifi {
    String[] getnetworks(); // Abstract method: Must be implemented.

    void connectingtonetworks(String networks); // Abstract method: Must be implemented.
}

// Class: A base class that provides common functionality for a phone.
class MycellPhone {
    void callnumber(int number) { 
        // Simple method: Prints the number being called.
        System.out.println("Calling: " + number);
    }

    void pickcall() { 
        // Simple method: Prints a message for connecting the call.
        System.out.println("Connecting...");
    }
}

// Class: Extends `MycellPhone` and implements `camera` and `Mywifi` interfaces.
// Demonstrates inheritance and interface implementation.
class Mysmartphone extends MycellPhone implements camera, Mywifi {
    @Override
    public void takesnap() { 
        // Implements the `takesnap` method from `camera` interface.
        System.out.println("Taking snap...");
    }

    @Override
    public void recordvideo() { 
        // Implements the `recordvideo` method from `camera` interface.
        System.out.println("Recording video...");
    }

    @Override
    public String[] getnetworks() { 
        // Implements `getnetworks` from `Mywifi`.
        System.out.println("Getting list of networks...");
        return new String[] { "Hacker", "Home", "Office" }; // Returns a sample array.
    }

    @Override
    public void connectingtonetworks(String networks) { 
        // Implements `connectingtonetworks` from `Mywifi`.
        System.out.println("Connecting to " + networks);
    }

    public void samplefunc() { 
        // Additional method: Not part of any interface.
        System.out.println("Sample function...");
    }
}

// Main class: Demonstrates polymorphism and usage of interfaces.
public class ch_11_59_polymorphism {
    public static void main(String[] args) {
        // Object Creation: Using a concrete class to access its methods.
        Mysmartphone phone = new Mysmartphone();
        phone.takesnap(); // Calls the `takesnap` method from `camera`.
        phone.recordvideo(); // Calls the `recordvideo` method from `camera`.

        // Demonstrates the usage of the `Mywifi` interface.
        String[] net = phone.getnetworks(); // Calls `getnetworks` from `Mywifi`.
        for (String ip : net) { 
            // Loops through and prints the networks.
            System.out.println(ip);
        }

        phone.connectingtonetworks("Home"); // Connects to a network.

        phone.record4kvideo(); 
        // Calls the default method from the `camera` interface.

        phone.callnumber(89828923); 
        // Calls the `callnumber` method from `MycellPhone`.

        // Polymorphism: Assigning a `Mysmartphone` object to a `camera` reference.
        camera cam = new Mysmartphone();

         
        // Polymorphism: Only methods in `camera` can be called.
        
        Scanner sc = new Scanner(System.in);
        cam.takesnap();

        // Type Casting: Accessing methods not part of the `camera` interface.
        ((Mysmartphone) cam).getnetworks(); // Casts to `Mysmartphone` to access additional methods.
        ((Mysmartphone) cam).samplefunc(); // Calls a method unique to `Mysmartphone`.
    }
}