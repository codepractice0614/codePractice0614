package little.dms.domain.board.domain.repository;

import little.dms.domain.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
