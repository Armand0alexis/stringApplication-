package armando.stringsearch.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Strings implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String inputString;
    private String searchString;
    private String count;
    private String isFound; 
    private String caseSensitive;
    // boolean isFound = false;
    // boolean caseSensitive = false;
    // @Column(nullable = false, updatable = false)
    // private String stringCode;

    public Strings(){}

   
    public Strings(String inputString, String searchString, String count, String isFound, String caseSensitive){
        this.inputString = inputString;
        this.searchString = searchString;
        this.count = count;
        this.isFound = isFound;
        this.caseSensitive = caseSensitive;
        // this.stringCode = stringCode;
    }
    
    public Long getId(){
        return id;
    }
    public void setId(Long id ){
        this.id = id;
    }

    public String getInputString(){
        return inputString;
    }
    public void setInputString(String inputString){
        this.inputString = inputString;
    }

    public String getSearchString(){
        return searchString;
    }
    public void setSearchtext(String searchString){
        this.searchString = searchString;
    }

    public String getCount(){
        return count;
    }
    public void setCount(String count){
        this.count = count;
    }

    public String setIsFound(){
        return isFound;
    }
    public void setIsFound(String isFound){
        this.isFound = isFound;
    }

    public String getIsCaseSensitive(){
        return caseSensitive;
    }
    public void setIsCaseSensitive(String caseSensitive){
       this.caseSensitive = caseSensitive;
    }

    // public String getStringCode(){
    //     return stringCode;
    // }
    // public void setStringCode(String stringCode){
    //     this.stringCode = stringCode;
    // }

    // public void checkisFound(Boolean str){
    //     str = this.inputString.indexOf(this.searchString) != -1 ? true: false;
    //     setIsFound(str); 
    // }

    // public void checkIsSensitive(Boolean str){
    //     str = this.inputString.indexOf(this.searchString) != -1 ? true: false;
    //     setIsCaseSensitive(str); 
    // }

    

    public java.lang.String toString(){
        return "String{" +
        "Input Text: " + inputString + '\'' +
        "Searched Text: " + searchString + '\'' +
        "Full Word: " + isFound + '\'' +
        "Case Sensistive: " + caseSensitive + '\'' +
        "Count of word Searched: " + count + '\'' +
        "}";
        
    }

}