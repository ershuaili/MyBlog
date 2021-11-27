package entity;
import lombok.Data;

import java.io.Serializable;

/**
 * (BlogType)实体类
 *
 * @author 李二帅
 * @since 2021-11-27 16:38:29
 */
@Data
public class BlogType implements Serializable {
    private static final long serialVersionUID = -25604250014591224L;
    /**
    * 博客分类id
    */
    private Long id;
    /**
    * 博客id
    */
    private Long blogId;
    /**
    * 分类id
    */
    private Long typeId;
}
