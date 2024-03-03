package cn.edu.zut.userprofile.service.impl;

import cn.edu.zut.userprofile.mapper.FileInfoMapper;
import cn.edu.zut.userprofile.service.FileInfoService;
import cn.edu.zut.userprofile.bean.FileInfo;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangchen
 * @since 2021-04-14
 */
@Service
@DS("mysql")
public class FileInfoServiceImpl extends ServiceImpl<FileInfoMapper, FileInfo> implements FileInfoService {

}
