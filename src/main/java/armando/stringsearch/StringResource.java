package armando.stringsearch;

import java.util.List;
import armando.stringsearch.model.*; 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import armando.stringsearch.service.StringService;

@RestController
@RequestMapping("/string")
public class StringResource {

    private final StringService stringService;

    public StringResource(StringService stringService){
        this.stringService = stringService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Strings>> getAllStrings(){
        List<Strings> strings = stringService.findAllStrings();
        return new ResponseEntity<>(strings, HttpStatus.OK);
    }

    // @GetMapping("/find/{id}")
    // public ResponseEntity<Strings> getStringById(@PathVariable("id") Long id){
    //     Strings string = stringService.findStringById(id);
    //     return new ResponseEntity<>(string, HttpStatus.OK);
    // }

    @PostMapping("/add")
    public ResponseEntity<Strings> addString(@RequestBody Strings string){
        Strings newString = stringService.addStrings(string);
        return new ResponseEntity<>(newString, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteString(@PathVariable("id") Long id){
        stringService.deleteString(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    
}
