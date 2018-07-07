package alarm;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.text.DateFormatter;

class Alarm {

    private String title;
    private Calendar calendar;
    private String alarmRing;

    /**
     * This constracter only set the <b>Calendar</b>
     * @param calendar
     */
    public Alarm(Calendar calendar) {
        this.calendar = calendar;
    }
    
    public String getAlarmRing() {
        return alarmRing;
    }

    public void setAlarmRing(String alarmRing) {
        this.alarmRing = alarmRing;
    }

    public String getTitle() {
        return title;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Calendar) && !(obj instanceof Alarm)) {
            return false;
        }
        Calendar x = (Calendar) obj;
        int compareTo = calendar.compareTo(x);
        if (compareTo != 0) {
            return false;
        }
        return true;
    }

    public boolean isNow() {
        Calendar instance = Calendar.getInstance();
        int compareTo = instance.compareTo(calendar);
        compareTo = Math.abs(compareTo);
        if (compareTo < 60_000) {
            return true;
        }
        return false;
    }
    
    public String[] getArray() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(title);
        arrayList.add(calendar.getTime().toGMTString());
        arrayList.add(alarmRing);
        String[] a = null;
        Object obj = arrayList.toArray(a);
        
        arrayList = null;
        return a;
    }
}
