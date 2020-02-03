package io.mk.cache.model;

import java.io.Serializable;

public class TVProgram implements Serializable {

	private static final long serialVersionUID = 1L;

	private int programId;
	private String programName;
	private String startTime;
	private int duration;

	public TVProgram(int programId, String programName, String startTime, int duration) {
		super();
		this.programId = programId;
		this.programName = programName;
		this.startTime = startTime;
		this.duration = duration;
	}

	public int getProgramId() {
		return programId;
	}

	public void setProgramId(int programId) {
		this.programId = programId;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

}
