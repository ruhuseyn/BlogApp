package rufethuseynov.blogapp.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rufethuseynov.blogapp.entity.ImageEntity;

import java.util.List;

@Repository
@Transactional
public interface ImageRepository extends JpaRepository<ImageEntity, String> {

    List<ImageEntity> findByFkBlogId(String fkBlogId);
}
