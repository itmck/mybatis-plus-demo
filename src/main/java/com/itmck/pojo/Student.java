package com.itmck.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Create by it_mck 2020/4/22 20:24
 *
 * @Description:
 * @Version: 1.0
 */

@Data
@ApiModel(value = "Student类")
public class Student {


    @NotNull(message = "姓名不能为空")
    @ApiModelProperty(value = "姓名",name = "name",example = "itmck",dataType ="String")
    private String name;

    @NotNull(message = "姓名不能为空")
    @ApiModelProperty(value = "年龄",name = "age",example = "25",dataType="int")
    private int  age;

    @ApiModelProperty(value = "邮箱",name = "email",example = "17355805355@163.com")
    private String email;


    @ApiModelProperty(value = "地址",name = "address",example = "安徽阜阳")
    private String address;


    @ApiModelProperty(value = "性别",name = "sex",example = "男",hidden = true)
    private  String sex;


}
