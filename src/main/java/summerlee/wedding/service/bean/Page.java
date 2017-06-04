package summerlee.wedding.service.bean;

import java.util.List;

/**
 * 
 * 
 * Page
 * 
 * @author 李斌
 * @CreateDate 2017年6月4日
 **/

public class Page {

	private List<Danmu> danmus;
	private int pageSize;
	private int totalCount;
	private int totalPage;
	
	public Page(List<Danmu> danmus, int pageSize, int totalCount) {
		this.danmus = danmus;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.totalPage = totalCount==0 ? 0 : 
			(totalCount%pageSize==0 ? totalCount/pageSize : totalCount/pageSize + 1);
	}

	public List<Danmu> getDanmus() {
		return danmus;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	@Override
	public String toString() {
		return "Page [danmus=" + danmus + ", pageSize=" + pageSize + ", totalCount=" + totalCount + ", totalPage="
				+ totalPage + "]";
	}
}
