package rufethuseynov.blogapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import rufethuseynov.blogapp.utility.CoreEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity(name = "blogs")
public class BlogEntity extends CoreEntity {

    @Column(name = "name", nullable = false)
    String name;
    @Column(name = "title", nullable = false)
    String title;
    @Column(name = "content", nullable = false)
    String content;
    @Column(name = "publish_date", nullable = false)
    Long publishDate;
    @Column(name = "view_count")
    Long viewCount;
    @Column(name = "cover_image_url")
    String coverImageUrl;



}
