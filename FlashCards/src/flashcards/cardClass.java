/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashcards;

/**
 *
 * @author DylanCarfley
 */
public class cardClass {
    private int id;
    private String question;
    private String answer;
    private boolean revisit;

    public cardClass() {
    }

    public cardClass(int id, String question, String answer, boolean revisit) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.revisit = revisit;
    }
    
    public boolean getRevisit(){
        return revisit;
    }
    
    public void setRevisit(boolean revisit){
        this.revisit = revisit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "cardClass{" + "id=" + id + ", question=" + question + ", answer=" + answer + ", revisit=" + revisit + '}';
    }
    
    
}
