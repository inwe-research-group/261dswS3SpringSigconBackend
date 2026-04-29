package dsw.sigconbackend.controller;

import dsw.sigconbackend.Service.TipoDocumentoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/tipodocumento")
public class TipoDocumentoController {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    TipoDocumentoService tipoDocumentoService;

    @GetMapping
    public ResponseEntity<?> getTipoDocumentos(){
        try{
            return ResponseEntity.ok(tipoDocumentoService.getTipoDocumentos());
        }catch(Exception e ){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
