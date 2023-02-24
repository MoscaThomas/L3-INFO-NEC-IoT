package dao;

import java.util.function.Function;

public class Message {
    private String message;

    public Message(String message) {
        this.message = message;
    }
    
    public Double getPrix() {
        String[] elements = this.message.split("\\|\\|\\|");

        for (String element : elements) {
          if (element.trim().startsWith("prix :")) {
            String prixString = element.trim().split("prix :")[1].trim();
            return Double.parseDouble(prixString);
          }
        }
      
        return 0.0;
      }
    
    
    public Double getPourcentage(){
        String[] elements = message.split("\\|\\|\\|");

        for (String element : elements) {
          if (element.trim().startsWith("% modif :")) {
            String percentageString = element.trim().split("% modif : ")[1].trim();
            return Double.parseDouble(percentageString);
          }
        }
      
        return 0.0;
      }
}
