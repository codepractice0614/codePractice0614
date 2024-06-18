package little.dms.domain.board.presentation.service;

import little.dms.domain.board.presentation.domain.Board;
import little.dms.domain.board.presentation.domain.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor // 생성자 구조 Autowired
public class BoardDeleteService {
    protected BoardRepository boardRepository;

    public void deleteByid(Long id){
        boardRepository.findById(id).orElseThrow
                (()-> new IllegalArgumentException("error"));
        boardRepository.deleteById(id);
    }
}
