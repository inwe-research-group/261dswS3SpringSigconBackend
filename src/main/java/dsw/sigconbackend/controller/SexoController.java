package dsw.sigconbackend.controller;

import dsw.sigconbackend.service.SexoService;
import dsw.sigconbackend.service.TipoDocumentoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/sexo")
public class SexoController {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    SexoService sexoService;

    @GetMapping
    public ResponseEntity<?> getSexo(){
        try{
            return ResponseEntity.ok(sexoService.getSexo());
        }catch(Exception e ){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
