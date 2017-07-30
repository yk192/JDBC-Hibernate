package entity;

public class Project {
    private int id;
    private String title;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    @Override
    public String toString() {
	return "Project [id=" + id + ", title=" + title + "]";
    }

}
