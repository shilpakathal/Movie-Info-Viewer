
package com.shilpa.codecheck.repository.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieInfo implements Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("director")
    @Expose
    private String director;
    @SerializedName("producer")
    @Expose
    private String producer;
    @SerializedName("release_date")
    @Expose
    private String releaseDate;
    @SerializedName("rt_score")
    @Expose
    private String rtScore;
    @SerializedName("people")
    @Expose
    private List<String> people = null;
    @SerializedName("species")
    @Expose
    private List<String> species = null;
    @SerializedName("locations")
    @Expose
    private List<String> locations = null;
    @SerializedName("vehicles")
    @Expose
    private List<String> vehicles = null;
    @SerializedName("url")
    @Expose
    private String url;
    public final static Parcelable.Creator<MovieInfo> CREATOR = new Creator<MovieInfo>() {


        @SuppressWarnings({
            "unchecked"
        })
        public MovieInfo createFromParcel(Parcel in) {
            return new MovieInfo(in);
        }

        public MovieInfo[] newArray(int size) {
            return (new MovieInfo[size]);
        }

    }
    ;

    protected MovieInfo(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.director = ((String) in.readValue((String.class.getClassLoader())));
        this.producer = ((String) in.readValue((String.class.getClassLoader())));
        this.releaseDate = ((String) in.readValue((String.class.getClassLoader())));
        this.rtScore = ((String) in.readValue((String.class.getClassLoader())));
//        in.readList(this.people, (java.lang.String.class.getClassLoader()));
//        in.readList(this.species, (java.lang.String.class.getClassLoader()));
//        in.readList(this.locations, (java.lang.String.class.getClassLoader()));
//        in.readList(this.vehicles, (java.lang.String.class.getClassLoader()));
       // this.url = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public MovieInfo() {
    }

    /**
     * 
     * @param id
     * @param title
     * @param releaseDate
     * @param species
     * @param locations
     * @param rtScore
     * @param description
     * @param producer
     * @param vehicles
     * @param director
     * @param people
     * @param url
     */
    public MovieInfo(String id, String title, String description, String director, String producer, String releaseDate, String rtScore, List<String> people, List<String> species, List<String> locations, List<String> vehicles, String url) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
        this.director = director;
        this.producer = producer;
        this.releaseDate = releaseDate;
        this.rtScore = rtScore;
        this.people = people;
        this.species = species;
        this.locations = locations;
        this.vehicles = vehicles;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRtScore() {
        return rtScore;
    }

    public void setRtScore(String rtScore) {
        this.rtScore = rtScore;
    }

    public List<String> getPeople() {
        return people;
    }

    public void setPeople(List<String> people) {
        this.people = people;
    }

    public List<String> getSpecies() {
        return species;
    }

    public void setSpecies(List<String> species) {
        this.species = species;
    }

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    public List<String> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<String> vehicles) {
        this.vehicles = vehicles;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(title);
        dest.writeValue(description);
        dest.writeValue(director);
        dest.writeValue(producer);
        dest.writeValue(releaseDate);
        dest.writeValue(rtScore);
        dest.writeList(people);
        dest.writeList(species);
        dest.writeList(locations);
        dest.writeList(vehicles);
        dest.writeValue(url);
    }

    public int describeContents() {
        return  0;
    }

}
