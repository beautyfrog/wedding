package summerlee.wedding.service.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import summerlee.wedding.service.bean.Danmu;

/**
 * 
 * 
 * DanmuDao
 * @author 李斌
 * @CreateDate 2017年6月4日
 **/

public interface DanmuDao {

	public int insert(Danmu danmu);
	
	public int getCount(Danmu danmu);
	
	public List<Danmu> getList(
			@Param("danmu") Danmu danmu, 
			@Param("start") int start, 
			@Param("limit") int limit);
}
