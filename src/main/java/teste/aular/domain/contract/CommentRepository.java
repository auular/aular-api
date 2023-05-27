package teste.aular.domain.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import teste.aular.domain.entity.Address;
import teste.aular.domain.vo.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("SELECT new teste.aular.domain.vo.Comment(c.author, c.comment) " +
            "FROM Comment c " +
            "WHERE c.hotel.hotelUuid = ?1 ")
    Optional<List<Comment>> getCommentsByHotelUuid(String hotelUuid);
}
