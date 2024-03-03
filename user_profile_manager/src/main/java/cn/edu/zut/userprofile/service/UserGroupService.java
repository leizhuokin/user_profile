package cn.edu.zut.userprofile.service;

import cn.edu.zut.userprofile.bean.UserGroup;
import com.baomidou.mybatisplus.extension.service.IService;

public interface UserGroupService  extends IService<UserGroup> {

        public void genUserGroup(UserGroup userGroup);

        public Long evaluateUserGroup(UserGroup userGroup);

        public void   refreshUserGroup(String userGroupId,String busiDate);
}
