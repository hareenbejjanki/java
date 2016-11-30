package com.bhirava.ovilearning.ui.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Provides methods to access workflowmanager 
 */
public class RestClient extends RestClientBase {
	private static String WFM_BASE_URL;
    private static String WORKFLOW_BASE_URL;
    private static String EXPORT_BASE_URL;
    private static String OOZIE_STATUS_BASE_URL;
    private static String OOZIE_STATUS_URL;
    private static String WF_ITEM_STATUS_URL;

    private static String CONFSEC_BASE_URL;
    private static String LOGIN_URL;
    private static String LOGOUT_URL;

    private static String APACHE_DRILL_BASE_URL;
    private static String APACHE_RANGER_BASE_URL;
    private static String APACHE_RANGER_USER;
    private static String APACHE_RANGER_PWD;
    
    private static String APACHE_ATLAS_BASE_URL;
    private static String APACHE_ATLAS_USER;
    private static String APACHE_ATLAS_PWD;
    
    private static String CDH_URL;
    private static String CDH_USER;
    private static String CDH_PWD;
    private static String SANDBOX_URL="http://sandbox.hadoop.com";

    public void setWorkflowManagerProperties() {
		
        if (APACHE_DRILL_BASE_URL == null || APACHE_DRILL_BASE_URL.trim().length()==0) APACHE_DRILL_BASE_URL = SANDBOX_URL+":8047";
        
        if (APACHE_RANGER_BASE_URL == null || APACHE_RANGER_BASE_URL.trim().length() ==0) APACHE_RANGER_BASE_URL = SANDBOX_URL+":6080";
        if (APACHE_RANGER_USER == null || APACHE_RANGER_USER.trim().length() ==0) APACHE_RANGER_USER = "admin";
        if (APACHE_RANGER_PWD == null || APACHE_RANGER_PWD.trim().length() ==0) APACHE_RANGER_PWD = "admin";
        
        
        if (APACHE_ATLAS_BASE_URL == null || APACHE_ATLAS_BASE_URL.trim().length()==0) APACHE_ATLAS_BASE_URL = SANDBOX_URL+":21000/api/atlas";
        if (APACHE_ATLAS_USER == null || APACHE_ATLAS_USER.trim().length() ==0) APACHE_ATLAS_USER = "admin";
        if (APACHE_ATLAS_PWD == null || APACHE_ATLAS_PWD.trim().length() ==0) APACHE_ATLAS_PWD = "admin";
        
        if (CDH_URL == null || CDH_URL.trim().length() ==0) CDH_URL = SANDBOX_URL+":7187";
        if (CDH_USER == null || CDH_USER.trim().length() ==0) CDH_USER = "admin";
        if (CDH_PWD == null || CDH_PWD.trim().length() ==0) CDH_PWD = "admin";
        
        LOGIN_URL = CONFSEC_BASE_URL.concat("/login");
        LOGOUT_URL = CONFSEC_BASE_URL.concat("/logout");

        WORKFLOW_BASE_URL = WFM_BASE_URL.concat("/workflows"); 
        
        EXPORT_BASE_URL = WORKFLOW_BASE_URL.concat("/{workflowId}/multitoolexport");
        
        OOZIE_STATUS_BASE_URL = WFM_BASE_URL.concat("/ooziejobstatus/status");
        OOZIE_STATUS_URL = OOZIE_STATUS_BASE_URL.concat("?jobId={jobId}").concat("&status={status}");
	}

	/**
     * Initializes invariables of IssueBrowser
     *
     * @param argUsername {@link String} username of the callee
     * @param argApiToken {@link String} api token that you need in order to call GitHub
     */
    public RestClient(String argUsername, String argApiToken) {
    }

    /**
     * Use this constructor in case you don't want to authorize.
     * Note: various methods need authorization.
     */
    public RestClient() {
    }

	public <T> ResponseEntity<Object> sendRestCall(HashMap<String, String> headers, String url, HttpMethod method, Object[] urlVariables) throws Exception {
		HttpHeaders requestHeaders = new HttpHeaders();
        if (headers != null) {
            for (String key : headers.keySet()) {
                requestHeaders.set(key, headers.get(key));
            }
        }

		HttpEntity<T> requestEntity = new HttpEntity<T>(null, requestHeaders);

		RestTemplate template = initTemplate();

		return template.exchange(url, method, requestEntity, Object.class, urlVariables);
	}

	public ResponseEntity<Object> authenticate(String login, String password) {
		RestTemplate template = initTemplate();
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.set("HEADER_USERNAME", login);
		requestHeaders.set("HEADER_PASSWORD", password);

		MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<String, String>();

		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(postParameters, requestHeaders);

		return template.exchange(LOGIN_URL, HttpMethod.POST, requestEntity, Object.class);
		//return new TokenInfo(jsonResponse.getHeaders().get("HEADER_TOKEN").get(0));
	}

	public void logout(String token) {
		RestTemplate template = initTemplate();
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.set("HEADER_TOKEN", token);

		MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<String, String>();

		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(postParameters, requestHeaders);

		template.exchange(LOGOUT_URL, HttpMethod.POST, requestEntity, Object.class);
	}
    
    public RestTemplate getTemplate() {
    	return initTemplate();
    }
}