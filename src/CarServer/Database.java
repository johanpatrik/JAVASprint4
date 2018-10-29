package CarServer;

import AddressServer.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;


public class Database {
    
    private final Car Anna = new Car("QWE123", "Kalle", "Saab", "Röd");
    private final Car Bertil = new Car("AAA111", 
            "Milla", "Volvo", "blå");
    private final Car Cecil = new Car("BBB222", 
            "Pelle","Audi", "Gul");
    private final Car Danne = new Car("CCC333", 
            "Lotta","Tesla", "svart");
    private final Car Ella = new Car("DDD444", 
            "Nisse","Kia", "Silver");
    
    private final List <Car> allCars = new ArrayList<>();
    
    Database(){
        allCars.add(Anna);
        allCars.add(Bertil);
        allCars.add(Cecil);
        allCars.add(Danne);
        allCars.add(Ella);
    }
   
   
   public String getCarData(String s){
       for (Car c :allCars){
           if (c.getRegNr().equalsIgnoreCase(s)){
               return c.getData();
           }
       }
       return null;
   }
    
}
