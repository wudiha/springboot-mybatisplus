package com.ums.ums.Entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.context.annotation.Bean;

/**
 * <p>
 * 
 * </p>
 *
 * @author wudi
 * @since 2022-01-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Usertb implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer ID;

    private String Name;

    private String Comment;


}
