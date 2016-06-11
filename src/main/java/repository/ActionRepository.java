package repository;

import domain.Action;
import domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by user on 2016-06-10.
 */
@Repository
public interface ActionRepository extends JpaRepository<Action, Long> {

}
