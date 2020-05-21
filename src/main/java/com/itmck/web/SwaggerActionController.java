package com.itmck.web;

import com.itmck.pojo.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by it_mck 2020/4/22 20:21
 *
 * @Description:
 * @Version: 1.0
 */

@Slf4j
@Api(value = "SwaggerActionController文档测试",tags = "控制器作用")
@RestController
public class SwaggerActionController {


    @ApiOperation(value = "swaggwer测试", notes = "swagger使用演示1")
    @PostMapping("/helloq")
    public Map<String,Object> helloSwagger0(@Validated  @RequestBody Student student, BindingResult bindingResult) {

        Map<String,Object> map = new HashMap<>();
        if (bindingResult.hasErrors()){
            bindingResult.getFieldErrors().forEach(error->{
                log.error("参数:{},校验失败,原因:{}",error.getField(),error.getDefaultMessage());
            });
            map.put("message", "非空校验失败");
            map.put("flag", false);
        }
        return map;
    }


    @ApiOperation(value = "swaggwer测试", notes = "swagger使用演示1")
    @PostMapping("/hello")
    public Student helloSwagger(@Validated  @RequestBody Student student, BindingResult bindingResult) {

        return student;
    }


    @ApiOperation(value = "swaggwer测试2", notes = "swagger使用演示2")
    @GetMapping("hello2")
    public Student helloSwagger2(Student student) {

        return student;
    }

    @ApiOperation(value = "swaggwer测试0", notes = "swagger使用演示0")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "姓名", dataType = "String", required = true, allowableValues = "mck,miaocghangke,itmck",paramType="query"),
            @ApiImplicitParam(name = "age", value = "年龄", dataType = "int", required = true, example = "22",paramType="query")
    })
    @GetMapping("hello04")
    public String helloSwagger04(@RequestParam String name,@RequestParam int age) {


        return "my name is:"+name+" and age is : "+age;
    }


    @ApiOperation(value = "swaggwer测试3", notes = "swagger使用演示3")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "姓名", dataType = "String",paramType = "path",allowableValues = "mck,miaocghangke,itmck"),
            @ApiImplicitParam(name = "age", value = "年龄", dataType = "int",paramType = "path")
    })
    @GetMapping("hello3/{name}/{age}")
    public String helloSwagger3(@PathVariable  String name,@PathVariable int age) {


        return "my name is:"+name+" and age is : "+age;
    }

    @ApiOperation(value = "swaggwer测试2", notes = "swagger使用演示2")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "姓名", dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "address", value = "地址", dataType = "String",paramType = "query")
    })
    @GetMapping("hello4/{name}")
    public String helloSwagger4(@PathVariable  String name,@RequestParam String address) {


        return "my name is:"+name+" address: "+address;
    }

    @ApiOperation(value = "上传swagger演示", notes = "swagger演示上传",consumes = "multipart/form-data",hidden = true)
    @PostMapping("hello5/{name}")
    public String helloSwagger5(@PathVariable  String name,@RequestParam("qqfile") MultipartFile file) {

        String name1 = file.getName();
        return "my name is:"+name+"正在测试上传文件:"+name1;
    }

    @ApiOperation(value = "swaggwer隐藏方法", notes = "swaggwer隐藏方法",hidden = true)
    @PostMapping("hello6/{name}")
    public String helloSwagger6(@PathVariable  String name) {


        return "my name is:"+name;
    }

}
