package do_uu_tien.model;

public class Job{
    private int id;
    private String idJob;
    private String nameJob;
    private String day;
    private String level;
    private String statusJob;


    public Job(int id, String idJob, String nameJob, String day, String level, String statusJob) {
        this.id = id;
        this.idJob = idJob;
        this.nameJob = nameJob;
        this.day = day;
        this.level = level;
        this.statusJob = statusJob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdJob() {
        return idJob;
    }

    public void setIdJob(String idJob) {
        this.idJob = idJob;
    }

    public String getNameJob() {
        return nameJob;
    }

    public void setNameJob(String nameJob) {
        this.nameJob = nameJob;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getStatusJob() {
        return statusJob;
    }

    public void setStatusJob(String statusJob) {
        this.statusJob = statusJob;
    }

    @Override
    public String toString() {
        return "["+ id + "]" + '-' + "["+ idJob + "]" + '-' + "["+ nameJob + "]" + '-' +"["+ day + "]" + '-' +"["+ level + "]" + '-' +"["+ statusJob + "]";

    }
    public String getLine(){
        return id + "," +idJob + "," + nameJob+ "," +day+ "," +level + "," + statusJob;
    }
    byte a = 120;
}
