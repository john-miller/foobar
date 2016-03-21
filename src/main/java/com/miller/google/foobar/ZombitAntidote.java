package com.miller.google.foobar;

public class ZombitAntidote {
				
	public static int answer(int[][] meetings) {
		
		/* Sort the original array of meetings */
		/* This helps keep the implementation simple */
		sort(meetings);
		
		/* Initial empty array of scheduled meetings */
		int[][] scheduledMeetings = new int[][] {};

		/* Start iterating through the meetings */
		for(int[] meeting : meetings) {
			
			/* Flag to determine if we have available spots */
			boolean hasAvailablility = true;
			
			/* Iterate through the accepted meetings and check if the meeting we want */
			/* to add will fit in */
			for(int[] scheduled : scheduledMeetings) 
				if (meeting[0] < scheduled[1] && meeting[1] > scheduled[0])
					hasAvailablility = false;
				else if (meeting[1] > scheduled[0] && meeting[0] < scheduled[1])
					hasAvailablility = false;
			
			/* If there is availability, add it to the list */
			if(hasAvailablility)
				scheduledMeetings = insert(scheduledMeetings, meeting);
		}
		
		/* Return the amount of scheduled meetings */
		return scheduledMeetings.length;
	}
	
	/**
	 * Sorts the array by start time then end time
	 * @param meetings
	 * @param sortIndex
	 */
	public static void sort(int[][] meetings) {
        for(int i=0; i < meetings.length-1; i++){
            for(int j=1; j < meetings.length-i; j++) {
            	/* Sort on start time*/
                if(meetings[j-1][0] > meetings[j][0]){
                   int[] temp = meetings[j-1];
                   meetings[j-1] = meetings[j];
                   meetings[j] = temp;
                }
                /* Sort on end time */
                else if((meetings[j-1][0] == meetings[j][0]) && (meetings[j-1][1] > meetings[j][1])) {
                    int[] temp = meetings[j-1];
                    meetings[j-1] = meetings[j];
                    meetings[j] = temp;
                }
            }
        }
	}
	
	/**
	 * Inserts the new meeting at the end of the array
	 * @param originalArray
	 * @param newMeeting
	 * @return
	 */
	public static int[][] insert(int[][] originalArray, int[] newMeeting) {
		int[][] newArray = new int[originalArray.length + 1][2];
		for(int i = 0; i < originalArray.length; i++) 
			newArray[i] = originalArray[i];
		newArray[originalArray.length] = newMeeting;
		return newArray;
	}
	
	public static void print(int[][] meetings) {
		for(int[] meeting : meetings) {
			System.out.print("["+meeting[0] + "," + meeting[1] + "]->");
		}
		System.out.println();
	}
	
				
}