package little.dms.domain.board.presentation.controller;

import little.dms.domain.board.presentation.dto.request.CreateBoardRequest;
import little.dms.domain.board.presentation.service.BoardDeleteService;
import little.dms.domain.board.presentation.service.BoardGetService;
import little.dms.domain.board.presentation.service.BoardPostSercie;
import little.dms.domain.board.presentation.service.BoardUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/crud")
@RequiredArgsConstructor
public class BoardContoller {
    BoardDeleteService boardDeleteService;
    BoardGetService boardGetService;
    BoardPostSercie boardPostSercie;
    BoardUpdateService boardUpdateService;

    @DeleteMapping("/{id}")
    public void deleteBoard(@RequestParam Long id){
        boardDeleteService.deleteByid(id);
    }

    @PatchMapping("/{id}")
    public void updateBoard(@RequestParam Long id, CreateBoardRequest createBoardRequest){
        boardUpdateService.update(id, createBoardRequest);
    }
}