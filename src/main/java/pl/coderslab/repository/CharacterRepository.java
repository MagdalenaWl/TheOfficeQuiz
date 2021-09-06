package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Character;


@Repository
public interface CharacterRepository extends JpaRepository<Character,Long> {
    @Query("select c from Character c where c.apiId=:apiId")
    Character findFirstByApiId(String apiId);

    boolean existsCharacterByApiId(String apiId);
}
