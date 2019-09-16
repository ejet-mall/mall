package com.macro.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
* Created by Mybatis Generator 2019/09/16
*/
@Data
@Getter
@Setter
public class CmsPrefrenceAreaProductRelation implements Serializable {
    private Long id;

    private Long prefrenceAreaId;

    private Long productId;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", prefrenceAreaId=").append(prefrenceAreaId);
        sb.append(", productId=").append(productId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}