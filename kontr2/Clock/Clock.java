package Clock;

public class Clock {
	public int sec;
	public int min;
	public int hour;

	public Clock(int sec, int min, int hour) {
		this.sec = sec;
		this.min = min;
		this.hour = hour;

	}

	public int getSec() {
		return sec;
	}

	public void setSec(int sec) {
		this.sec = sec;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;

	}

	

	public void increaseSec() {
		sec++;
			if (sec == 60) {
				sec = 0;
				min++;
				sec=0;
			}
			if (min == 60) {
				min = 0;
				hour++;
			}
			if (hour == 24) {
				hour = 0;
			}
		}
	
		public void increaseMin() {
            min += 1;
            if(min >= 60){
                hour += 1;
                min=0;
            }
            if (hour == 24){
                hour = 0;
            }

        }
        public void increaseHour() {
            hour += 1;
            if (hour == 24){
                hour = 0;
            }

        }
        public void getTime() {
    		System.out.println("The Time " + hour + ":" + min + ":" + sec);
    	}
	}
	
	
	
	

