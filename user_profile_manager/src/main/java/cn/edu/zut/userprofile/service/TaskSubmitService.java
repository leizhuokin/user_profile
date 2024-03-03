package cn.edu.zut.userprofile.service;

import cn.edu.zut.userprofile.bean.TaskProcess;

public interface TaskSubmitService {


    public void submitTask(TaskProcess taskProcess, boolean isRetry);
}
