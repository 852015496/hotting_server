package com.hetting.hottable.export.service;

import com.hetting.hottable.entity.*;
import com.hetting.hottable.export.service.impl.IImportConcentUserServiceImpl;
import com.hetting.hottable.mapper.*;
import com.hetting.hottable.utils.MyException;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Date $
 * @Param $
 * @Author zhangwentao
 **/
@Service
public class ImportConcentUserService implements IImportConcentUserServiceImpl {

    @Autowired
    private ConcentMapper concentMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private HotMapper hotMapper;

    @Autowired
    private ValveMapper valveMapper;

    @Autowired
    private ConcentMessageMapper concentMessageMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean insertData(String fileName, MultipartFile file) throws Exception {
        boolean b = false;
        boolean notNull = false;
        List<UserVO> userList = new ArrayList<>();
        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            throw new MyException("上传文件格式不正确");
        }
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = file.getInputStream();
        Workbook wb = null;
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);
        }
        Sheet sheet = wb.getSheetAt(0);
        System.err.println(sheet + "--------- 11111");
        if(sheet!=null){
            notNull = true;
        }
        UserVO userVO;
        for (int r = 1; r <= sheet.getLastRowNum(); r++) {//r = 2 表示从第三行开始循环 如果你的第三行开始是数据
            Row row = sheet.getRow(r);//通过sheet表单对象得到 行对象
            if (row == null){
                continue;
            }
            //sheet.getLastRowNum() 的值是 10，所以Excel表中的数据至少是10条；不然报错 NullPointerException
            userVO = new UserVO();
            short lastCellNum = row.getLastCellNum();
            for (int i = 1; i < 27; i++) {
                Cell cell = row.getCell(i);
                //如果单元格 不等空的话 Cell转换为文本类型
                if(cell != null){
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                }
                // 如果单元格为null continue; 避免获取空指针
                if(cell == null){
                    continue;
                }
                //获取单元格中的值
                String value = cell.getStringCellValue();
                //如果获取的值为null  continue;
                if(value == null){
                    continue;
                }
                // 根据获取到的值,赋值给实体类
                if (i == 0){
                    userVO.setHousing(value);
                }
                if (i == 1){
                    userVO.setConcentCode(value);
                }
                if (i == 2){
                    userVO.setUserName(value);
                }
                if (i == 3){
                    userVO.setUserBuilding(value);
                }
                if (i == 4){
                    userVO.setUserCell(value);
                }
                if (i == 5){
                    userVO.setUserDoornum(value);
                }
                if (i == 6){
                    userVO.setUserArea(value);
                }
                if (i == 7){
                    userVO.setHotAddress(value);
                }
                if (i == 8){
                    userVO.setHotAisle(value);
                }
                if (i == 9){
                    userVO.setHotVenderName(value);
                }
                if (i == 10){
                    userVO.setValveAddress(value);
                }
                if (i == 11){
                    userVO.setValveWorkMode(value);
                }
                if (i == 12){
                    userVO.setValveChn(value);
                }
                if (i == 13){
                    userVO.setValveVenderName(value);
                }
                if (i == 14){
                    userVO.setRustSport(value);
                }
                if (i == 15){
                    userVO.setTempInterval(value);
                }
                if (i == 16){
                    userVO.setTempAdjust(value);
                }
                if (i == 17){
                    userVO.setOpening(value);
                }
                if (i == 18){
                    userVO.setMinOpen(value);
                }
                if (i == 19){
                    userVO.setMaxOpen(value);
                }
                if (i == 20){
                    userVO.setTempUpper(value);
                }
                if (i == 21){
                    userVO.setTempLower(value);
                }
                if (i == 22){
                    userVO.setSetTempValue(value);
                }
                if (i == 23){
                    userVO.setSetPower(value);
                }
                if (i == 24){
                    userVO.setSetFlow(value);
                }
                if (i == 25){
                    userVO.setPowerOpening(value);
                }
                if (i == 26){
                    userVO.setTrimClosing(value);
                }
                if (i == 27){
                    userVO.setApportionHot(value);
                }
            }
            //完整的循环一次 就组成了一个对象
            userList.add(userVO);
        }
        for (UserVO userResord : userList) {
            try {
                // 集中器代码不能为null
                String concentCode = userResord.getConcentCode();
                //根据集中器代码获取到集中器的id
                Concent concentId = concentMapper.concentCodeInfoList(concentCode);
                System.err.println(concentId);
                if (null == concentId) {
//                    return b; //没有这个集中器代码 先添加此集中器代码
                    System.err.println("暂时" + concentCode + "没有这个集中器,先添加" + concentCode + "再进行导入");
                    throw new MyException("500", "暂时" + concentCode + "没有这个集中器,先添加" + concentCode + "再进行导入");
                } else {
                    //添加用户信息 同时得到对应的集中器id
                    User user = new User();
                    user.setConcentId(concentId.getConcentId());
                    user.setUserName(userResord.getUserName());
                    user.setUserBuilding(userResord.getUserBuilding());
                    user.setUserCell(userResord.getUserCell());
                    user.setUserDoornum(userResord.getUserDoornum());
                    user.setUserArea(userResord.getUserArea());
                    user.setUserConcentCode(userResord.getUserConcentCode());
                    userMapper.insertSelective(user);
                    Integer userId = user.getUserId();
                    System.err.println(userId);

                    //添加热表信息 同时得到对应的集中器id
                    Hot hot = new Hot();
                    hot.setUserId(userId);
                    hot.setConcentId(concentId.getConcentId());
                    hot.setHotVenderName(userResord.getHotVenderName());
                    hot.setHotAisle(userResord.getHotAisle());
                    hot.setHotAddress(userResord.getHotAddress());
                    hotMapper.insertSelective(hot);
                    System.err.println(userId);

                    //添加阀门信息 同时得到对应的集中器id
                    Valve valve = new Valve();
                    valve.setUserId(userId);
                    valve.setConcentId(concentId.getConcentId());
                    valve.setValveVenderName(userResord.getValveVenderName());
                    valve.setValveChn(userResord.getValveChn());
                    valve.setValveAddress(userResord.getValveAddress());
                    valve.setValveWorkMode(userResord.getValveWorkMode());
                    valve.setSetIndoorTemp(userResord.getSetIndoorTemp());
                    valve.setOpening(userResord.getOpening());
                    valve.setMinOpen(userResord.getMinOpen());
                    valve.setMaxOpen(userResord.getMaxOpen());
                    valve.setTempUpper(userResord.getTempUpper());
                    valve.setTempLower(userResord.getTempLower());
                    valve.setSetTempValue(userResord.getSetTempValue());
                    valve.setSetPower(userResord.getSetPower());
                    valve.setSetFlow(userResord.getSetFlow());
                    valve.setApportionHot(userResord.getApportionHot());
                    valve.setPowerOpening(userResord.getPowerOpening());
                    valve.setTrimClosing(userResord.getTrimClosing());
                    valve.setRustSport(userResord.getRustSport());
                    valve.setTempInterval(userResord.getTempInterval());
                    valve.setTempAdjust(userResord.getTempAdjust());
                    valveMapper.insertSelective(valve);
                    Integer valveId = valve.getValveId();
                    System.err.println(valveId);
                    System.out.println(" 插入 " + userResord);
                }
            } catch (MyException e) {
                e.setErrorCode("200");
                throw e;
            }
        }
        return notNull;
    }
}
