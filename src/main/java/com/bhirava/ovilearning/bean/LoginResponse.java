package com.bhirava.ovilearning.bean;

public class LoginResponse {
    private String checkOtp;

    private String subscription;

    private String token;

    private User user1;

    private String[] role;

    private Otp_status otp_status;

    private String otp;

    public String getCheckOtp ()
    {
        return checkOtp;
    }

    public void setCheckOtp (String checkOtp)
    {
        this.checkOtp = checkOtp;
    }

    public String getSubscription ()
    {
        return subscription;
    }

    public void setSubscription (String subscription)
    {
        this.subscription = subscription;
    }

    public String getToken ()
    {
        return token;
    }

    public void setToken (String token)
    {
        this.token = token;
    }

    public User getUser1 ()
    {
        return user1;
    }

    public void setUser1 (User user1)
    {
        this.user1 = user1;
    }

    public String[] getRole ()
    {
        return role;
    }

    public void setRole (String[] role)
    {
        this.role = role;
    }

    public Otp_status getOtp_status ()
    {
        return otp_status;
    }

    public void setOtp_status (Otp_status otp_status)
    {
        this.otp_status = otp_status;
    }

    public String getOtp ()
    {
        return otp;
    }

    public void setOtp (String otp)
    {
        this.otp = otp;
    }

    @Override
    public String toString()
    {
        return "LoginResponse [checkOtp = "+checkOtp+", subscription = "+subscription+", token = "+token+", user1 = "+user1+", role = "+role+", otp_status = "+otp_status+", otp = "+otp+"]";
    }
}
