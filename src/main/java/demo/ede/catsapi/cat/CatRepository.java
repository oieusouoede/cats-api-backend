package demo.ede.catsapi.cat;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepository extends JpaRepository <Cat, Integer> {
}
