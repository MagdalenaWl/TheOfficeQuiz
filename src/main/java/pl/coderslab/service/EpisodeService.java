package pl.coderslab.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.dto.CrewMemberData;
import pl.coderslab.dto.EpisodeData;
import pl.coderslab.model.Episode;
import pl.coderslab.repository.EpisodeRepository;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class EpisodeService {
    EpisodeRepository episodeRepository;
    CrewMemberService crewMemberService;

    @Transactional
    public void save(EpisodeData episodeData) {
        if (!episodeRepository.existsEpisodeByApiId(episodeData.get_id())) {
            Episode episode = new Episode();
            episode.setApiId(episodeData.get_id());
            episode.setTitle(episodeData.getTitle());
            episode.setDescription(episodeData.getDescription());
            episode.setDirector(crewMemberService.findByApiId(episodeData.getDirector().get_id()));
            episode.setWriter(crewMemberService.findByApiId(episodeData.getWriter().get_id()));
            episodeRepository.save(episode);
        }
    }
}
