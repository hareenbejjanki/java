package com.bhirava.ovilearning.bean;

public class Otp_status {
    private Response response;

    private String status;

    public Response getResponse ()
    {
        return response;
    }

    public void setResponse (Response response)
    {
        this.response = response;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "Otp_status [response = "+response+", status = "+status+"]";
    }
}
