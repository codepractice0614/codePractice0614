package little.dms.domain.board.service;

import jakarta.transaction.Transactional;
import little.dms.domain.board.domain.Board;
import little.dms.domain.board.domain.repository.BoardRepository;
import little.dms.domain.board.presentation.dto.request.CreateBoardRequest;
import little.dms.domain.user.domain.User;
import little.dms.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class CreateBoardService {

    private final BoardRepository boardRepository;
    private final UserFacade userFacade;

    public void execute(CreateBoardRequest request) {

        User currentUser = userFacade.getCurrentUser();

        boardRepository.save(
            Board.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .user(currentUser)
                .build()
        );
    }
}
