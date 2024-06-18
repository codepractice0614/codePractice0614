package little.dms.domain.board.presentation.domain.repository;

import little.dms.domain.board.presentation.domain.Board;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface BoardRepository extends CrudRepository<Board,Long> {
}
