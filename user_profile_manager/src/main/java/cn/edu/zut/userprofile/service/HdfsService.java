package cn.edu.zut.userprofile.service;

import org.springframework.web.multipart.MultipartFile;

public interface HdfsService {

    public   Long createFile(String path, MultipartFile file);
}
