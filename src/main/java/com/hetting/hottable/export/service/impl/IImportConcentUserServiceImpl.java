package com.hetting.hottable.export.service.impl;

import com.hetting.hottable.entity.UserVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Description TODO
 * @Date $
 * @Param $
 * @Author zhangwentao
 **/
public interface IImportConcentUserServiceImpl {

    boolean insertData(String fileName, MultipartFile file) throws Exception;
}
