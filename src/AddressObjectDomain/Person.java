package AddressObjectDomain;

import java.io.Serializable;
import java.time.LocalDate;


public class Person implements Serializable{
    
    protected String name;
    String address;
    protected LocalDate dateOfBirth;
    protected String disease;
    protected boolean hospitalEmployee;
    static final long serialVersionUID = 42L;

    
    public Person(String name, String address, LocalDate dateOfBirth, String disease, boolean hospitalEmployee){
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.disease = disease;
        this.hospitalEmployee = hospitalEmployee;
    }
    
    public boolean isPatient(){
        return !hospitalEmployee;
    }
    
    public boolean isHospitalEmployee(){
        return hospitalEmployee;
    }
    
    public String getName(){
        return name;
    }
    
    public String getAddress(){
        return address;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public void setBirthday(int year, int month, int day){
        dateOfBirth = LocalDate.of(year, month-1, day);
    }
    
    public LocalDate getBirthday(){
        return dateOfBirth;
    }
    
    public void setDisease(String disease){
        this.disease = disease;
    }
    
    public String getDisease(){
        return disease;
    }

}
    
    
    
