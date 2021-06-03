package pl.krystian.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.krystian.entities.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

	BookEntity findByTitle(String title);
}
