package little.dms.domain.board.presentation.service;

import little.dms.domain.board.presentation.domain.Board;
import little.dms.domain.board.presentation.domain.repository.BoardRepository;
import little.dms.domain.board.presentation.dto.request.CreateBoardRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class BoardUpdateService {
    BoardRepository boardRepository;

    @Transactional // JPA 변경 감지
    public void update(Long id, CreateBoardRequest createBoardRequest) {
        Board board = boardRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("wrong Id"));
        board.setContent(createBoardRequest.getContent());
        board.setTitle(createBoardRequest.getTitle());
    }
}