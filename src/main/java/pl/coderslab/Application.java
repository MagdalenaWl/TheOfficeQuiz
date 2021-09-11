package pl.coderslab;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import pl.coderslab.service.CharacterService;
import pl.coderslab.service.CrewMemberService;
import pl.coderslab.service.EpisodeService;
import pl.coderslab.service.QuoteService;

import java.util.Locale;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@Slf4j
@AllArgsConstructor
@ServletComponentScan
public class Application extends SpringBootServletInitializer {
    CharacterService characterService;
    QuoteService quoteService;
    CrewMemberService crewMemberService;
    EpisodeService episodeService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.ENGLISH);
        return slr;
    }
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    // @TODO odkomentowac
//    @Bean
//    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
//        return args -> {
//            CharacterDTO characterDTO = restTemplate.getForObject(
//                    "https://www.officeapi.dev/api/characters", CharacterDTO.class);
//            Arrays.stream(characterDTO.getData()).forEach(el->characterService.save(el));
//            log.info(characterDTO.toString());
//            QuoteDTO quoteDTO = restTemplate.getForObject("https://www.officeapi.dev/api/quotes",QuoteDTO.class);
//            log.info(quoteDTO.toString());
//            Arrays.stream(quoteDTO.getData()).forEach(el->quoteService.save(el));
//            CrewMemberDTO crewMemberDTO=restTemplate.getForObject("https://www.officeapi.dev/api/crew",CrewMemberDTO.class);
//            log.info(crewMemberDTO.toString());
//            Arrays.stream(crewMemberDTO.getData()).forEach(el->crewMemberService.save(el));
//            EpisodeDTO episodeDTO=restTemplate.getForObject("https://www.officeapi.dev/api/episodes",EpisodeDTO.class);
//            log.info(episodeDTO.toString());
//            Arrays.stream(episodeDTO.getData()).forEach(el->episodeService.save(el));
//
//
//        };
// }

}