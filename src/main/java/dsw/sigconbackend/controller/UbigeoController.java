package dsw.sigconbackend.controller;

import dsw.sigconbackend.model.Ubigeo;
import dsw.sigconbackend.service.UbigeoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/ubigeo")
public class UbigeoController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UbigeoService ubigeoService;    
    
    @GetMapping()
    public ResponseEntity<?> getUbigeo() {
        logger.info(">listar");

        List<Ubigeo> listaUbigeo = null;
        try {
                listaUbigeo = ubigeoService.getUbigeo();
        } catch (Exception e) {
                logger.error("Unexpected Exception caught.", e);
                return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        logger.info(">listar");
        return new ResponseEntity<>(listaUbigeo, HttpStatus.OK);
    }
}
