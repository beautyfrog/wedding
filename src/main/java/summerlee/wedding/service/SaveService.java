package summerlee.wedding.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import summerlee.wedding.service.bean.Danmu;
import summerlee.wedding.service.bean.Page;
import summerlee.wedding.service.dao.DanmuDao;

/**
 * 
 * 
 * SaveService
 * @author 李斌
 * @CreateDate 2017年6月4日
 **/

@Service
public class SaveService {

	@Autowired
	private DanmuDao danmuDao;
	
	@Transactional
	public void save(Danmu danmu) {
		danmuDao.insert(danmu);
	}
	
	@Transactional(readOnly=true)
	public Page getList(Danmu danmu, int pageIndex, int pageSize) {
		int totalCount = danmuDao.getCount(danmu);
		if(totalCount==0){
			return new Page(new ArrayList<Danmu>(), pageSize, totalCount);
		}
		List<Danmu> list = danmuDao.getList(danmu, (pageIndex - 1) * pageSize, pageSize);
		return new Page(list, pageSize, totalCount);
	}
	
	public static class SaveJob implements Runnable {
		
		private final Logger logger = LoggerFactory.getLogger(this.getClass());

		private Danmu danmu;
		private SaveService service;

		public SaveJob(String firend, String avatar, String msg, SaveService service) {
			this.danmu = new Danmu();
			danmu.setFirend(firend);
			danmu.setAvatar(avatar);
			danmu.setMsg(msg);
			danmu.setCreateTime(System.currentTimeMillis());
			this.service = service;
		}

		@Override
		public void run() {
			try {
				service.save(danmu);
			} catch (Exception e) {
				logger.error("Invoking saveJob error : " + e.getMessage(), e);
			}
		}
	}
}
