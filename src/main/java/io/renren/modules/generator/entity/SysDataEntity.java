package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 数据表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-09 15:14:11
 */
@Data
@TableName("sys_data")
public class SysDataEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键自增
	 */
	@TableId
	private Integer id;
	/**
	 * 是否震动0:否 1:是
	 */
	private String shock;
	/**
	 * 温度
	 */
	private String temperature;
	/**
	 * 火焰0:否 1:是
	 */
	private String flame;
	/**
	 * 烟雾浓度
	 */
	private String smok;
	/**
	 * 压力
	 */
	private String pressure;
	/**
	 * 创建时间
	 */
	private Date createTime;

}
