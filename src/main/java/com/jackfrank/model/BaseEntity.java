package com.jackfrank.model;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by jack on 17-12-31.
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 3391409618176237973L;
}
