package eu.programisci;

import eu.programisci.Test.UserDTO;
import eu.programisci.Test.UserRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class Bootstrapper implements ApplicationListener<ContextRefreshedEvent> {

    Logger log = Logger.getLogger(this.getClass().getName());

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("Tutaj wykona sie import danych");
        UserRepository.save(new UserDTO("Jan", "Kowalski", "j.kowalski", "tajneHaslo123", "j.kowalski@wp.pl"));
        UserRepository.save(new UserDTO("Adam", "Nowak", "a.nowak", "tajneHaslo123", "a.nowak@wp.pl"));
        UserRepository.save(new UserDTO("Stefan", "Batory", "s.batory", "tajneHaslo123", "s.batory@wp.pl"));
        UserRepository.save(new UserDTO("Anna", "Kowalska", "a.kowalska", "tajneHaslo123", "a.kowalska@wp.pl"));
        UserRepository.save(new UserDTO("Zenon", "Zenon", "z.zenon", "tajneHaslo123", "z.zenon@wp.pl"));
        UserRepository.save(new UserDTO("Krzysztof", "Nazwisko", "k.nazwisko", "tajneHaslo123", "k.nazwisko@wp.pl"));
        UserRepository.initializeSequence();
    }
}
