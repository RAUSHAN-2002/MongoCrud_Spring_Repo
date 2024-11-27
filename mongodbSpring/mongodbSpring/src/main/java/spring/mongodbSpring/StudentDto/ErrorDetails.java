package spring.mongodbSpring.StudentDto;



import org.springframework.web.context.request.WebRequest;

import java.util.Date;


public class ErrorDetails {
    private String message;
    private Date date;
    private String request;

    public ErrorDetails(Date date,String message,String request) {
        this.date = date;
        this.message =message;
        this.request=request;
    }



    public Date getDate() {
        return date;
    }
    public String getMessage() {
        return message;
    }
    public String getRequest() {
        return request;
    }


}
