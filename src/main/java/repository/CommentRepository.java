package repository;

import domain.Comment;
import domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by user on 2016-06-10.
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
