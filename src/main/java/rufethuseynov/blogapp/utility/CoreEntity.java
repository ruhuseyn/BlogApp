package rufethuseynov.blogapp.utility;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode
@SuperBuilder
@EntityListeners({CoreEntityListener.class})
@MappedSuperclass
public class CoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    String id;
    @Column(name = "created_by", nullable = false)
    String createdBy;
    @Column(name = "created_time", nullable = false)
    Long createdTime;
    @Column(name = "status", nullable = false)
    String status;
    @Column(name = "insert_date", nullable = false)
    Long insertDate;
    @Column(name = "created_date", nullable = false)
    Long createdDate;
}
