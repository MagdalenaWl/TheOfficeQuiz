package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Episode;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Long> {
    boolean existsEpisodeByApiId(String apiId);
}
