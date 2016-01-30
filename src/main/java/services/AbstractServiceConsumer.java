package services;

/**
 * Created by davidkanaa on 16-01-29.
 */
public class AbstractServiceConsumer {

    protected String providerName;
    protected String baseURL;

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }
}
