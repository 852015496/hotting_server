package com.hetting.hottable.utils;

import com.hetting.hottable.connect.SpringContextHolder;
import com.hetting.hottable.entity.ConcentMessage;
import com.hetting.hottable.entity.FacilityAllMessage;
import com.hetting.hottable.server.ConcentMessageService;
import org.apache.log4j.Logger;

public class NewNettyUtils {

	public static Logger log = Logger.getLogger(NewNettyUtils.class);

	//集中器信息
	private static ConcentMessageService concentMessageService = SpringContextHolder.getBean(ConcentMessageService.class);

	/**
	 * 集中器上传运行状态命令 0x10
	 * 
	 * @param address    集中器地址
	 * @param dataString 数据内容
	 */
	/**
	 * @Author ZhangWenTao
	 * @Description //TODO	集中器信息表上传状态命令
	 * @Date 2020/9/9
	 * @Param [address, dataString]
	 * @return void
	 **/
	public static void uploadRunStatus(String address, String dataString) {
		log.info("----开始 集中器上传运行状态命令 0x10 ----");

		String[] datas = dataString.split(" ");
		if (datas.length != 32) {
			log.info("集中器上传运行状态命令 0x10--解析数据有误");
			return;
		}

		FacilityAllMessage amm = new FacilityAllMessage();
		amm.setConcentCode(address);
		amm.setChannel1(datas[0]);
		amm.setChannel2(datas[1]);
		amm.setChannel3(datas[2]);
		amm.setChannel4(datas[3]);
		amm.setStatus485(datas[4]);
		amm.setStatusloar(datas[5]);
//		amm.setDianyaval(Integer.parseInt(datas[6], 16) + "");	电压值新增
//		amm.setDianyuankaiguan(datas[7]);	电源开关
//		amm.setStatusout(datas[8]);	输出电源开关状态
//		amm.setNblevel(datas[9]);	4G/NB信号强度
		StringBuffer ccid = new StringBuffer();
		for (int i = 10; i < 30; i++) {
			ccid.append(datas[i]);
		}
		amm.setPhoneId(ccid.toString());
//		amm.setSpare12(datas[30]); // 被用字段
//		qxConcentrator.setFentansf(datas[31]); 分摊收费

		if (concentMessageService.updateRunStatus(amm) > 0) {
			log.info("集中器上传运行状态命令 0x10--保存成功");
		} else {
			log.info("集中器上传运行状态命令 0x10--保存失败");
		}

		log.info("----结束 集中器上传运行状态命令 0x10 ----");
	}


}
