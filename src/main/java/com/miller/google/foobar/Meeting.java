package com.miller.google.foobar;

/**
 * Meeting object
 * @author Jonathan
 *
 */
public class Meeting {
	
	private int startTime;
	private int endTime;
	
	public Meeting(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
			
	public boolean after(Meeting meeting) {
		return this.getStartTime() >= meeting.getEndTime();
	}
	
	public boolean before(Meeting meeting) {
		return this.getEndTime() <= meeting.getStartTime();
	}
	
	public boolean shorter(Meeting meeting) {
		return this.getLength() < meeting.getLength();
	}
				
	public int getStartTime() {
		return startTime;
	}
	
	public int getLength() {
		return endTime - startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Meeting other = (Meeting) obj;
		if (endTime != other.endTime)
			return false;
		if (startTime != other.startTime)
			return false;
		return true;
	}

	public String toString() {
		return "[" + getStartTime() + ", " + getEndTime() + "]";
	}
}
