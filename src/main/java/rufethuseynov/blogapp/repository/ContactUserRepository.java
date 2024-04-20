package rufethuseynov.blogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rufethuseynov.blogapp.entity.ContactUserEntity;

@Repository
public interface ContactUserRepository extends JpaRepository<ContactUserEntity, String> {
}
