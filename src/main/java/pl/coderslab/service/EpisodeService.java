package pl.coderslab.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.dto.EpisodeData;
import pl.coderslab.model.CurrentQuiz;
import pl.coderslab.model.Episode;
import pl.coderslab.model.Question;
import pl.coderslab.repository.EpisodeRepository;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

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

    public List<Episode> findRandom(int numberOfQuestions) {
        List<Episode> episodes = episodeRepository.findAll();
        if (episodes.size() > numberOfQuestions) {
            Collections.shuffle(episodes);
            return episodes.subList(0, numberOfQuestions);
        }
        return episodes;
    }

    public CurrentQuiz makeWritersQuiz(int numberOfQuestions) {
        List<Episode> episodes = this.findRandom(numberOfQuestions);
        CurrentQuiz currentQuiz = new CurrentQuiz();
        currentQuiz.setPath("/quiz/writers");
        for (Episode episode : episodes) {
            Question question = new Question("Title: " + episode.getTitle() + ". Description: " + episode.getDescription());
            question.addAnswer(episode.getWriter().getName(), true);
            currentQuiz.addQuestion(question);
        }
        return currentQuiz;
    }

    public CurrentQuiz makeDirectorsQuiz(int numberOfQuestions) {
        List<Episode> episodes = this.findRandom(numberOfQuestions);
        CurrentQuiz currentQuiz = new CurrentQuiz();
        currentQuiz.setPath("/quiz/directors");
        for (Episode episode : episodes) {
            Question question = new Question("Title: " + episode.getTitle() + ". Description: " + episode.getDescription());
            question.addAnswer(episode.getDirector().getName(), true);
            currentQuiz.addQuestion(question);
        }
        return currentQuiz;
    }

}
