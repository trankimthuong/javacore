import java.io.Serializable;
import java.util.List;

public class Freelancer implements Serializable {
    private String id;
    private String name;
    private float hourlyRate;
    private int totalHoursWorked;
    private List<String> skills;
    public static int a = 10;

    public Freelancer() {
    }

    public Freelancer(String id, String name, float hourlyRate, int totalHoursWorked, List<String> skills) {
        this.id = id;
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.totalHoursWorked = totalHoursWorked;
        this.skills = skills;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(float hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(int totalHoursWorked) {
        this.totalHoursWorked = totalHoursWorked;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public boolean validateName() {
        return this.name.length() >= 3;
    }

    public boolean validateHourlyRate() {
        return this.hourlyRate > 15;
    }

    public boolean validateTotalHoursWorked() {
        return this.totalHoursWorked > 0;
    }

    @Override
    public String toString() {
        return "Freelancer: id=" + this.id + ", name=" + this.name + ", hourlyRate=" + this.hourlyRate +
                ", totalHoursWorked=" + this.totalHoursWorked + ", skills=" + this.skills;
    }

    public String display() {
        return "okiela";
    }

    public String display(String a) {
        return a;
    }
}
