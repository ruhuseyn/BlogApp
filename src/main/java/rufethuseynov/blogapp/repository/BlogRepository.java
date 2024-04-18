package rufethuseynov.blogapp.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rufethuseynov.blogapp.entity.BlogEntity;

import java.util.List;

@Repository
@Transactional
public interface BlogRepository extends JpaRepository<BlogEntity, String> {
    List<BlogEntity> findAllByStatus(String a);
}
