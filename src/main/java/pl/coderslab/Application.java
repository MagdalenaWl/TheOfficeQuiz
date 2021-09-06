package pl.coderslab;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import pl.coderslab.dto.CharacterDTO;
import pl.coderslab.dto.CrewMemberDTO;
import pl.coderslab.dto.EpisodeDTO;
import pl.coderslab.dto.QuoteDTO;
import pl.coderslab.model.CrewMember;
import pl.coderslab.model.Episode;
import pl.coderslab.model.Quote;
import pl.coderslab.service.CharacterService;
import pl.coderslab.service.CrewMemberService;
import pl.coderslab.service.EpisodeService;
import pl.coderslab.service.QuoteService;

import java.util.Arrays;


@SpringBootApplication
@Slf4j
@AllArgsConstructor
public class Application extends SpringBootServletInitializer {
    CharacterService characterService;
    QuoteService quoteService;
    CrewMemberService crewMemberService;
    EpisodeService episodeService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            CharacterDTO characterDTO = restTemplate.getForObject(
                    "https://www.officeapi.dev/api/characters", CharacterDTO.class);
            Arrays.stream(characterDTO.getData()).forEach(el->characterService.save(el));
            log.info(characterDTO.toString());
            QuoteDTO quoteDTO = restTemplate.getForObject("https://www.officeapi.dev/api/quotes",QuoteDTO.class);
            log.info(quoteDTO.toString());
            Arrays.stream(quoteDTO.getData()).forEach(el->quoteService.save(el));
            CrewMemberDTO crewMemberDTO=restTemplate.getForObject("https://www.officeapi.dev/api/crew",CrewMemberDTO.class);
            log.info(crewMemberDTO.toString());
            Arrays.stream(crewMemberDTO.getData()).forEach(el->crewMemberService.save(el));
            EpisodeDTO episodeDTO=restTemplate.getForObject("https://www.officeapi.dev/api/episodes",EpisodeDTO.class);
            log.info(episodeDTO.toString());
            Arrays.stream(episodeDTO.getData()).forEach(el->episodeService.save(el));


        };
    }

}