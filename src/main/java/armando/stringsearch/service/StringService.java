package armando.stringsearch.service;

import java.util.List;
//import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import armando.stringsearch.model.Strings;
import armando.stringsearch.repo.StringRepo;



@Service
public class StringService {
    private final StringRepo stringRepo;

    @Autowired
    public StringService(StringRepo stringRepo){
        this.stringRepo = stringRepo;
    }

    public Strings addStrings(Strings string){
        string.setInputString(string.getInputString());
        string.setSearchtext(string.getSearchString());
        boolean found = string.getInputString().indexOf(string.getSearchString()) != -1 ? true : false;
        if(found == true){
            string.setIsFound("true");
            string.setIsCaseSensitive("true");
        }else if(found == false){
            string.setIsFound("false");
        }else{
            string.setIsCaseSensitive("false");
        }
        return stringRepo.save(string);
    }

    public List<Strings> findAllStrings(){
        return stringRepo.findAll();
    }
    
    public Strings findStringById(Long id){
        return stringRepo.findStringById(id)
        .orElseThrow(() -> new UserNotFoundException("Test case by id: " + id + "not found."));
    }

    public void deleteString(Long id){
        stringRepo.deleteStringById(id);
    }
    



}
