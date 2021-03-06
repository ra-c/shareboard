package model.section;

public class Section {

    private Integer id;
    private String name;
    private String description;
    private String picture;
    private String banner;
    private Integer nFollowersTotal;
    private Integer nFollowersWeekly;

    public Integer getnFollowersTotal() {
        return nFollowersTotal;
    }

    public void setnFollowersTotal(Integer nFollowersTotal) {
        this.nFollowersTotal = nFollowersTotal;
    }

    public Integer getnFollowersWeekly() {
        return nFollowersWeekly;
    }

    public void setnFollowersWeekly(Integer nFollowersWeekly) {
        this.nFollowersWeekly = nFollowersWeekly;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

}
