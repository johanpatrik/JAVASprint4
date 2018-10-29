package ÖvnUppg8_Sessionsobjekt;

import java.io.Serializable;


public class Session implements Serializable{
    
    protected RiddleState state;
    //Sätts initialt av servern
    protected String riddle;
    //SÄtts av klienten
    protected String answer = "";
    protected Boolean verdict;
    
    public Session (String r){
        riddle = r;
        verdict = null;
        state = RiddleState.WAITING;
    }
    
    protected RiddleState getState(){
        return state;
    }
    
    protected Boolean getVerdict(){
        return verdict;
    }
    
    protected String getRiddle(){
        return riddle;
    }
    
    protected String getAnswer(){
        return answer;
    }
    
    protected void setState(RiddleState s){
        state = s;
    }
    
    protected void setVerdict(Boolean b){
        verdict = b;
    }
    
    protected void setRiddle(String s){
        riddle = s;
    }
    
    protected void setAnswer(String s){
        answer = s;
    }
}
