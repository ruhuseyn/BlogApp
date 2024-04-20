package rufethuseynov.blogapp.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import rufethuseynov.blogapp.entity.BlogEntity;
import rufethuseynov.blogapp.entity.ContactUserEntity;

@Repository
@Transactional
public interface ContactUserRepository extends JpaRepository<ContactUserEntity, String>,
        JpaSpecificationExecutor<ContactUserEntity> {
}
