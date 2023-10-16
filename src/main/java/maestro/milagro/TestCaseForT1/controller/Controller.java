package maestro.milagro.TestCaseForT1.controller;

import maestro.milagro.TestCaseForT1.model.RequestDTO;
import maestro.milagro.TestCaseForT1.model.ResponseDTO;
import maestro.milagro.TestCaseForT1.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    private final Service service;
    @Autowired
    public Controller(Service service){
        this.service = service;
    }

    @PostMapping("/sort")
    public ResponseEntity<ResponseDTO> sortPost(@RequestBody RequestDTO requestDTO){
        return new ResponseEntity<>(service.sortMessage(requestDTO), HttpStatus.OK);
    }
}
