// src/main/java/project/myboard/repository/BoardRepository.java
package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
}

