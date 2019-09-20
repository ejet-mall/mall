package com.macro.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
* Created by Mybatis Generator 2019/09/20
*/
@Data
@Getter
@Setter
public class SysAppVersion implements Serializable {
    private Long id;

    @ApiModelProperty(value = "app类型")
    private Long appType;

    @ApiModelProperty(value = "版本")
    private Long versionNo;

    @ApiModelProperty(value = "版本")
    private String version;

    @ApiModelProperty(value = "下载地址")
    private String downloadUrl;

    @ApiModelProperty(value = "评论时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "预留")
    private String ext;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appType=").append(appType);
        sb.append(", versionNo=").append(versionNo);
        sb.append(", version=").append(version);
        sb.append(", downloadUrl=").append(downloadUrl);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", ext=").append(ext);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}