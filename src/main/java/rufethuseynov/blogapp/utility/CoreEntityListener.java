package rufethuseynov.blogapp.utility;

import jakarta.persistence.PrePersist;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CoreEntityListener {

    @Autowired
    private SessionManager manager;

    @PrePersist
    private void preInsert(CoreEntity entity) {
        entity.setInsertDate(QDate.getDateTimeLong());
        if (entity.getStatus() == null || entity.getStatus().isEmpty()) {
            entity.setStatus("A");
        }
        entity.setCreatedDate(QDate.getDateTimeLong());
        entity.setCreatedTime(QDate.getCurrentDateTime());
        entity.setCreatedBy(manager.getCurrentUserId());
    }
}


