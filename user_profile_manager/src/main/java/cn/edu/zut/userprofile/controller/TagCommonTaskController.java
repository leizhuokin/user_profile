package cn.edu.zut.userprofile.controller;


import cn.edu.zut.userprofile.service.TagCommonTaskService;
import com.alibaba.fastjson.JSON;
import cn.edu.zut.userprofile.bean.TagCommonTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhangchen
 * @since 2021-04-27
 */
@RestController
public class TagCommonTaskController {

    @Autowired
    TagCommonTaskService tagCommonTaskService;

    @PostMapping("/tagcommon")
    @CrossOrigin
    public String saveTagCommonTask(@RequestBody TagCommonTask tagCommonTask){
        tagCommonTask.setUpdateTime(new Date());
        tagCommonTaskService.saveOrUpdate(tagCommonTask);
        return "success";
    }

    @GetMapping("/tagcommon/{id}")
    @CrossOrigin
    public String getTagCommonTask(@PathVariable("id") Long id){
        TagCommonTask tagCommonTask = tagCommonTaskService.getTagCommonTaskWithJarFile(id);
        if(tagCommonTask==null) {
            tagCommonTask = new TagCommonTask();
            tagCommonTask.setId(1L);
        }
        return JSON.toJSONString(tagCommonTask);
    }

}

