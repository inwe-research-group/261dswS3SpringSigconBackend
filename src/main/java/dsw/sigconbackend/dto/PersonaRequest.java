package dsw.sigconbackend.dto;

import dsw.sigconbackend.model.Persona;
import dsw.sigconbackend.model.Sexo;
import dsw.sigconbackend.model.TipoDocumento;
import dsw.sigconbackend.model.Ubigeo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonaRequest {
    private Long idPersona;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombres;
    private String idSexo; // Cambiado a String para recibir "M" o "F"
    private LocalDate fechaNacimiento;
    private Integer idTipoDocumento;
    private String numDocumento; // Cambiado para coincidir con el JSON
    private String direccion;
    private String telefono;
    private String idUbigeo;
    
     public static Persona toEntity(PersonaRequest personaRequest) {
        Persona persona = new Persona();
        
        // Si es 0 o null, lo dejamos como null para que JPA haga un INSERT
        if (personaRequest.getIdPersona() != null && personaRequest.getIdPersona() > 0)
            persona.setIdPersona(personaRequest.getIdPersona());
        else
            persona.setIdPersona(null);

        
        persona.setNombres(personaRequest.getNombres());
        persona.setApellidoPaterno(personaRequest.getApellidoPaterno());
        persona.setApellidoMaterno(personaRequest.getApellidoMaterno());
        persona.setFechaNacimiento(personaRequest.getFechaNacimiento());
        persona.setDireccion(personaRequest.getDireccion());        
        persona.setNumDocumento(personaRequest.getNumDocumento());
        persona.setTelefono(personaRequest.getTelefono());
        if (personaRequest.getIdSexo() != null)
             persona.setSexo(Sexo.builder().idSexo(personaRequest.getIdSexo()).build());
        if (personaRequest.getIdTipoDocumento() != null)
            persona.setTipoDocumento(TipoDocumento.builder().idTipoDocumento(personaRequest.getIdTipoDocumento()).build());
        if (personaRequest.getIdUbigeo() != null)
            persona.setUbigeo(Ubigeo.builder().idUbigeo(personaRequest.getIdUbigeo()).build());

        return persona;
    }
}
