package io.mk.cache.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TVPrograms implements Serializable {

	private static final long serialVersionUID = 1L;

	private int channelId;
	private String channelName;
	private List<TVProgram> tvProgramList;

	public int getChannelId() {
		return channelId;
	}

	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public List<TVProgram> getTvProgramList() {
		if (tvProgramList == null) {
			tvProgramList = new ArrayList<>();
		}
		return tvProgramList;
	}

	public void setTvProgramList(List<TVProgram> tvProgramList) {
		this.tvProgramList = tvProgramList;
	}

}
