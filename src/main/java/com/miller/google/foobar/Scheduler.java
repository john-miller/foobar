package com.miller.google.foobar;

/**
 * Handles the scheduling of meetings
 * and will create the longest array of non-overlapping 
 * meetings possible given an array of meetings
 * 
 * @author Jonathan
 *
 */
public class Scheduler {
	
	/* Initialize empty array */
	private Meeting[] meetings = new Meeting[]{};
	private int currentIndex = 0;
	
	/**
	 * Schedules the meeting in the array
	 * 
	 * @param meeting
	 */
	public void schedule(Meeting meeting) {
		/* Empty meeting */
		if(meetings.length == 0) {
			insert(currentIndex, meeting);
		}
		else {
			schedule(meetings[currentIndex], meeting);
		}
	}
	
	public void schedule(Meeting meetingA, Meeting meetingB) {
		if(meetingA.before(meetingB)) {
			if(currentIndex > 0)
				schedule(meetings[--currentIndex], meetingB);
			else
				insert(0, meetingB);
		}
		else if (meetingA.after(meetingB)) {
			if(currentIndex < meetings.length -1)
				schedule(meetings[++currentIndex], meetingB);
			else
				insert(meetings.length, meetingB);
		}
	}
	
	public int getIndex(Meeting meeting) {
		for(int i = 0 ; i < meetings.length; i++) 
			if(meeting.equals(meetings[i]))
				return i;
		return -1;
	}
	
	/**
	 * Inserts a meeting at the given index
	 * 
	 * @param index
	 * @param toBeInserted
	 */
	public void insert(int index, Meeting toBeInserted) {
		Meeting[] newArray = new Meeting[meetings.length + 1];
		int offset = 0;
		for(int i = 0; i < newArray.length; i++) {
			if(i == index)
				newArray[i + offset++] = toBeInserted;
			else 
				newArray[i+offset] = meetings[i];
		}
		meetings = newArray;
	}
	
	public int getScheduleLength(){
		return meetings.length;
	}
	
	public void print() {
		for(Meeting meeting : meetings)
			System.out.print("[" + meeting.getStartTime() + "," + meeting.getEndTime() + "]-> ");
	}
	
	

}
