package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class postRequestBody {

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String job;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }


    private List<String> languages;

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<cityRequest> getCityRequests() {
        return cityRequests;
    }

    public void setCityRequests(List<cityRequest> cityRequests) {
        this.cityRequests = cityRequests;
    }

    private List<cityRequest> cityRequests;


}
