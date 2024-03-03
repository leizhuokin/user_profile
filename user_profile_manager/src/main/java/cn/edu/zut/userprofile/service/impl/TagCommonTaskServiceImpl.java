package cn.edu.zut.userprofile.service.impl;

import cn.edu.zut.userprofile.mapper.TagCommonTaskMapper;
import cn.edu.zut.userprofile.service.FileInfoService;
import cn.edu.zut.userprofile.service.TagCommonTaskService;
import cn.edu.zut.userprofile.bean.FileInfo;
import cn.edu.zut.userprofile.bean.TagCommonTask;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangchen
 * @since 2021-04-27
 */
@Service
@DS("mysql")
public class TagCommonTaskServiceImpl extends ServiceImpl<TagCommonTaskMapper, TagCommonTask> implements TagCommonTaskService {

    @Autowired
    FileInfoService fileInfoService;

    public  TagCommonTask getTagCommonTaskWithJarFile(Long id){
        TagCommonTask tagCommonTask =   getById(id);
        if(tagCommonTask!=null){
            FileInfo fileInfo = fileInfoService.getById(tagCommonTask.getTaskFileId());
            tagCommonTask.setFileInfo(fileInfo);
        }

        return  tagCommonTask;
    }


}
