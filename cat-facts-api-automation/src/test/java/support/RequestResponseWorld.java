package support;

import io.restassured.response.ExtractableResponse;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import lombok.Setter;
import java.net.http.HttpHeaders;

@Getter
@Setter
public class RequestResponseWorld {
    private ExtractableResponse response;
    private RequestSpecification request;
    private HttpHeaders httpHeaders;
    private String baseURL;
    private String path;

    public void setResponse(ExtractableResponse response) {
        this.response = response;
    }

    public ExtractableResponse getResponse() {
        return this.response;
    }

    public void setRequest(RequestSpecification request) {
        this.request = request;
    }

    public RequestSpecification getRequest() {
        return this.request;
    }

}
