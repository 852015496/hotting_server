package com.hetting.hottable.export.controller;

import com.hetting.hottable.entity.UserVO;
import com.hetting.hottable.export.ImportExcel;
import com.hetting.hottable.export.service.impl.IImportConcentUserServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Description TODO
 * @Date $
 * @Param $
 * @Author zhangwentao
 **/
@Controller
@RequestMapping("/ImportConcentUserController")
public class ImportConcentUserController {


    private static final Logger logger = LoggerFactory.getLogger(Exception.class);

    @Autowired
    private IImportConcentUserServiceImpl importConcentUserService;


    @RequestMapping(value = "/import",method = RequestMethod.POST)
    @ResponseBody
    public String exImport(@RequestParam(value = "file")MultipartFile file, HttpSession session) throws Exception{
        boolean a = false;
        String fileName = file.getOriginalFilename();
        try {
            a = importConcentUserService.insertData(fileName, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a+"导入成功";
    }

}
