package com.bhirava.ovilearning.bean;

public class LastLogin {
	
    private String timezone;

    private String timezone_type;

    private String date;

    public String getTimezone ()
    {
        return timezone;
    }

    public void setTimezone (String timezone)
    {
        this.timezone = timezone;
    }

    public String getTimezone_type ()
    {
        return timezone_type;
    }

    public void setTimezone_type (String timezone_type)
    {
        this.timezone_type = timezone_type;
    }

    public String getDate ()
    {
        return date;
    }

    public void setDate (String date)
    {
        this.date = date;
    }

    @Override
    public String toString()
    {
        return "LastLogin [timezone = "+timezone+", timezone_type = "+timezone_type+", date = "+date+"]";
    }
}