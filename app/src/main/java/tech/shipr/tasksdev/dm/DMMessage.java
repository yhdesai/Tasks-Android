package tech.shipr.tasksdev.dm;

public class DMMessage {

    private String text;
    private String name;
    private String photoUrl;
    private int cryptVersion;

    public DMMessage() {
    }

    public DMMessage(String text, String name, String photoUrl, int cryptVersion) {
        this.text = text;
        this.name = name;
        this.photoUrl = photoUrl;
        this.cryptVersion = cryptVersion;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public int getCryptVersion() {
        return cryptVersion;
    }

    public void setCryptVersion(int cryptVersion) {
        this.cryptVersion = cryptVersion;
    }
}
