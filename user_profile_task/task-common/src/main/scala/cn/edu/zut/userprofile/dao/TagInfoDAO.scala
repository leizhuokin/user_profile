package cn.edu.zut.userprofile.dao

import cn.edu.zut.userprofile.bean.TagInfo
import cn.edu.zut.userprofile.util.MySqlUtil

object TagInfoDAO {


    def getTagInfoByTaskId(taskId:String): TagInfo ={
      val tagInfoOpt: Option[TagInfo] = MySqlUtil.queryOne[TagInfo](s"select * from tag_info where tag_task_id='$taskId'" ,classOf[TagInfo], true )
      if(tagInfoOpt==None){
        throw  new RuntimeException(s" no this taskId $taskId for tag !")
      }
      tagInfoOpt.get
    }

  // 查询所有启用中的标签
  def getTagInfoListOnTask(): List[TagInfo] ={
     val tagInfoList: List[TagInfo] = MySqlUtil.queryList[TagInfo](s"select tg.* from tag_info tg join task_info tk on tg.tag_task_id = tk.id where  tk.task_status='1'   " ,classOf[TagInfo], true )
      tagInfoList
  }

}
