package cn.edu.zut.userprofile.service;

import cn.edu.zut.userprofile.bean.TagCommonTask;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhangchen
 * @since 2021-04-27
 */
public interface TagCommonTaskService extends IService<TagCommonTask> {


    public  TagCommonTask getTagCommonTaskWithJarFile(Long id);
}
