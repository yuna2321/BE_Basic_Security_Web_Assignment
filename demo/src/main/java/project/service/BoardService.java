// src/main/java/project/myboard/service/BoardService.java
package project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.entity.BoardEntity;
import project.repository.BoardRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardEntity save(BoardEntity board) {
        return boardRepository.save(board);
    }

    public List<BoardEntity> findAll() {
        return boardRepository.findAll();
    }

    public BoardEntity findById(Long id) {
        return boardRepository.findById(id).orElse(null);
    }

    public BoardEntity update(Long id, BoardEntity newBoard) {
        BoardEntity existing = boardRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setTitle(newBoard.getTitle());
            existing.setContent(newBoard.getContent());
            return boardRepository.save(existing);
        }
        return null;
    }

    public void delete(Long id) {
        boardRepository.deleteById(id);
    }
}

