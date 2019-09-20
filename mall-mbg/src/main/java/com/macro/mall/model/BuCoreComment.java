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
public class BuCoreComment implements Serializable {
    private Long id;

    @ApiModelProperty(value = "产品资源ID")
    private Long productId;

    @ApiModelProperty(value = "产品资源名称")
    private String productName;

    @ApiModelProperty(value = "产品资源简述")
    private String productSubject;

    @ApiModelProperty(value = "产品资源图片路径")
    private String productPic;

    @ApiModelProperty(value = "预留")
    private String productExt;

    @ApiModelProperty(value = "评价用户Id")
    private Long userId;

    private String phone;

    @ApiModelProperty(value = "评价用户名称")
    private String userNickName;

    @ApiModelProperty(value = "评论用户头像")
    private String userIcon;

    @ApiModelProperty(value = "评价的ip")
    private String userIp;

    @ApiModelProperty(value = "评价星数：0->5")
    private Integer star;

    @ApiModelProperty(value = "是否置顶: 0->否 1->是 ")
    private Integer isTop;

    @ApiModelProperty(value = "是否推荐: 0->否 1->是 ")
    private Integer isGood;

    @ApiModelProperty(value = "阅读数")
    private Integer readCount;

    @ApiModelProperty(value = "支持数")
    private Integer likeCount;

    @ApiModelProperty(value = "反对数")
    private Integer unlikeCount;

    @ApiModelProperty(value = "回复数")
    private Integer replyCount;

    @ApiModelProperty(value = "展示状态: 1:展示 2：不展示")
    private Integer showStatus;

    @ApiModelProperty(value = "购买时的商品属性")
    private String productAttribute;

    @ApiModelProperty(value = "上传图片地址，以逗号隔开")
    private String pics;

    @ApiModelProperty(value = "评论时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "预留")
    private String ext;

    @ApiModelProperty(value = "评论内容")
    private String content;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productId=").append(productId);
        sb.append(", productName=").append(productName);
        sb.append(", productSubject=").append(productSubject);
        sb.append(", productPic=").append(productPic);
        sb.append(", productExt=").append(productExt);
        sb.append(", userId=").append(userId);
        sb.append(", phone=").append(phone);
        sb.append(", userNickName=").append(userNickName);
        sb.append(", userIcon=").append(userIcon);
        sb.append(", userIp=").append(userIp);
        sb.append(", star=").append(star);
        sb.append(", isTop=").append(isTop);
        sb.append(", isGood=").append(isGood);
        sb.append(", readCount=").append(readCount);
        sb.append(", likeCount=").append(likeCount);
        sb.append(", unlikeCount=").append(unlikeCount);
        sb.append(", replyCount=").append(replyCount);
        sb.append(", showStatus=").append(showStatus);
        sb.append(", productAttribute=").append(productAttribute);
        sb.append(", pics=").append(pics);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", ext=").append(ext);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}