package cn.edu.zut.userprofile.controller;


import cn.edu.zut.userprofile.service.HdfsService;
import cn.edu.zut.userprofile.service.TaskInfoService;
import cn.edu.zut.userprofile.service.TaskProcessService;
import cn.edu.zut.userprofile.service.TaskSubmitService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import cn.edu.zut.userprofile.bean.TaskInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhangchen
 * @since 2021-04-15
 */
@RestController
public class TaskInfoController {

    @Autowired
    TaskSubmitService taskSubmitService;

    @Autowired
    TaskProcessService taskProcessService;

    @Autowired
    TaskInfoService taskInfoService;

    @Autowired
    HdfsService hdfsService;

    @RequestMapping("/task-submit")
    @CrossOrigin
    public void doTask(@RequestParam("id") Long taskId,@RequestParam("dt") String taskDate ){

      //  taskSubmitService.submitTask(taskId,taskDate,false);

    }


    @GetMapping("/tasklist")
    @CrossOrigin
    public String getTaskList(@RequestParam("pageNo")int pageNo , @RequestParam("pageSize") int pageSize ,@RequestParam(value = "taskType",required = false) String taskType){
        int startNo=(  pageNo-1)* pageSize;
        int endNo=startNo+pageSize;

        QueryWrapper<TaskInfo> queryWrapper = new QueryWrapper<>();
        if(taskType!=null){
            queryWrapper.eq("task_type",taskType) ;
        }
        int count = taskInfoService.count(queryWrapper);

        queryWrapper.orderByAsc("task_exec_level").last(" limit " + startNo + "," + endNo);
        List<TaskInfo> taskInfoList = taskInfoService.list(queryWrapper);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("detail",taskInfoList);
        jsonObject.put("total",count);

        return  jsonObject.toJSONString();
    }

    @PostMapping("/taskinfo")
    @CrossOrigin
    public String saveTaskInfo(@RequestBody TaskInfo taskInfo){
        taskInfoService.saveTaskInfoWithTag(taskInfo);
        return "success";
    }

    @GetMapping("taskinfo/{id}")
    @CrossOrigin
    public String getTaskInfo(@PathVariable("id") Long taskId ){
        TaskInfo taskInfo = taskInfoService.getTaskInfoWithTag(taskId);

        return JSON.toJSONString(taskInfo) ;
    }


    @DeleteMapping("taskinfo/{id}")
    @CrossOrigin
    public String delTaskInfo(@PathVariable("id") Long taskId ){
        taskInfoService.removeById(taskId);
        return "success" ;
    }

    public static final String PATH_JAR="/user_profile/task_customer/jar/";

    @PostMapping("/upload")
    @CrossOrigin
    public String   uploadTaskJar(@RequestParam(value = "file") MultipartFile file ){
        Long fileId = hdfsService.createFile(PATH_JAR, file);

        return  "{\"fileId\":\""+fileId+"\"}";

    }



}

