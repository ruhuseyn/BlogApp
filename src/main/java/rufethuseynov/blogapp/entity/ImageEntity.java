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
@Entity(name = "images")
public class ImageEntity extends CoreEntity {

    @Column(name = "image_url", nullable = false)
    String imageUrl;
    @Column(name = "sub_title")
    String subTitle;
    @Column(name = "is_cover")
    String isCover;
    @Column(name = "fk_blog_id", nullable = false)
    String fkBlogId;
}
