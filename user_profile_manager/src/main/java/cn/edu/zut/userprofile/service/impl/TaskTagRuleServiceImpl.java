package cn.edu.zut.userprofile.service.impl;

import cn.edu.zut.userprofile.bean.TaskTagRule;
import cn.edu.zut.userprofile.mapper.TaskTagRuleMapper;
import cn.edu.zut.userprofile.service.TaskTagRuleService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangchen
 * @since 2021-04-15
 */
@Service
@DS("mysql")
public class TaskTagRuleServiceImpl extends ServiceImpl<TaskTagRuleMapper, TaskTagRule> implements TaskTagRuleService {

}
