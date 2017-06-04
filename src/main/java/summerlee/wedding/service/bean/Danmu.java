package summerlee.wedding.service.bean;

/**
 * 弹幕对象
 * 
 * Danmu
 * 
 * @author 李斌
 * @CreateDate 2017年6月4日
 **/

public class Danmu {

	private Integer id;
	private String firend;
	private String avatar;
	private String msg;
	private Long createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirend() {
		return firend;
	}

	public void setFirend(String firend) {
		this.firend = firend;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Danmu [id=" + id + ", firend=" + firend + ", avatar=" + avatar + ", msg=" + msg + ", createTime="
				+ createTime + "]";
	}
}