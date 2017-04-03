package eu.programisci.Test;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.HEAD, RequestMethod.OPTIONS, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
public class TestRestController {

    @RequestMapping(value = "/odwrocString", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String odwrocString(@RequestParam("stringDoOdwrocenia") String aStringDoOdwrocenia) {
        System.out.println("Konwertuje "+aStringDoOdwrocenia);
        return new StringBuilder(aStringDoOdwrocenia).reverse().toString();
    }

    @RequestMapping(value = "/dodajWartosci", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public OdpowiedzDTO dodajWartosci(@RequestBody ParaLiczbDTO aParaLiczbDTO) {
        return new OdpowiedzDTO(aParaLiczbDTO.getX() + aParaLiczbDTO.getY(), "Kopytko");
    }

    @RequestMapping(value = "/dodajUsera", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserDTO dodajUsera(@RequestBody UserDTO aUserDTO) {
        UserDTO newUser = UserRepository.save(new UserDTO(aUserDTO.getName(), aUserDTO.getLastname(), aUserDTO.getLogin(), aUserDTO.getPassword(), aUserDTO.getEmail()));
        System.out.println("Data utworzenia "+newUser.getCreationDate());
        return newUser;
    }

    @RequestMapping(value = "/usunUsera", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void usunUsera(@RequestParam("id") Long id) {
        System.out.println("Usuwam uzytkownika o id "+id);
        UserRepository.deleteOne(id);
    }

}
