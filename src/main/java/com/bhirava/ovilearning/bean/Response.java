package com.bhirava.ovilearning.bean;

public class Response {
    private String message;

    private String api_id;

    private String[] message_uuid;

    public String getMessage ()
    {
        return message;
    }

    public void setMessage (String message)
    {
        this.message = message;
    }

    public String getApi_id ()
    {
        return api_id;
    }

    public void setApi_id (String api_id)
    {
        this.api_id = api_id;
    }

    public String[] getMessage_uuid ()
    {
        return message_uuid;
    }

    public void setMessage_uuid (String[] message_uuid)
    {
        this.message_uuid = message_uuid;
    }

    @Override
    public String toString()
    {
        return "Response [message = "+message+", api_id = "+api_id+", message_uuid = "+message_uuid+"]";
    }
}
