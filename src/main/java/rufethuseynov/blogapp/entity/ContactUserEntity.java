package rufethuseynov.blogapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import rufethuseynov.blogapp.utility.CoreEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "contact_users")
public class ContactUserEntity extends CoreEntity {

    String name;
    @Column(name = "phone_number")
    String phoneNumber;
    String email;
    String message;
}
