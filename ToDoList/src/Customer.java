import java.util.ArrayList;

public class Customer {
    private int cid;
    private String cName;
    private String userName;
    private String password;
    private ArrayList<Task> taskList= new ArrayList<>();

    public int getCid() {
        return cid;
    }
    public ArrayList<Task> getTaskList() {
        return taskList;
    }
    public void setCid(int cid) {
        this.cid = cid;
    }
    public String getcName() {
        return cName;
    }
    public void setcName(String cName) {
        this.cName = cName;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


}
