package main.java;

import java.util.function.Function;

public class Message {
    private String message;

    public Message(String message) {
        this.message = message;
    }
    
    public Double getPrix() {
        String[] parts = message.split(" ||| ");
        for (String part : parts) {
            if (part.startsWith("prix : ")) {
                return Double.parseDouble(part.substring(7));
            }
        }
        return null;
    }
    
    public Double getPourcentage(){
        String[] parts = message.split(" ||| ");
    for (String part : parts) {
        if (part.startsWith("% modif : ")) {
            return Double.parseDouble(part.substring(10));
        }
    }
    return null;
    }
}
