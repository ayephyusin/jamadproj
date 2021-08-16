package sg.edu.iss.jam.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.jam.model.Comments;

public interface CommentsRepository extends JpaRepository<Comments, Long> {

	@Query("SELECT c FROM Comments c WHERE c.mediaComment.id = :id")
	List<Comments> findCommentsByMediaId(@Param("id") Long id);
	
	@Query("SELECT c FROM Comments c WHERE c.commentUser.userID = :userID")
	List<Comments> findCommentsByUserId(@Param("userID") Long userID);
}
