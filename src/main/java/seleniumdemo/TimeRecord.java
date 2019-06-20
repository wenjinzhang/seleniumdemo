package seleniumdemo;

public class TimeRecord {
    String name = "s1260807@monmouth.edu";
    String password ="Zhangwen2";

    int hours = 2;
    int minutes=55;

    public TimeRecord(String name, String password, int hours, int minutes) {
        this.name = name;
        this.password = password;
        this.hours = hours;
        this.minutes = minutes;
    }

    public TimeRecord(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

}
