
package yourmissions;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="tasks")
public class tasks implements java.io.Serializable{
     @Id
     @Column(name="tasks_no")
    private String tasks_no;
      @Column(name="description")
    private String description;
       @Column(name="Us_NID")
    private String Us_NID;
        @Column(name="worker_username")
    private String worker_username;
      

    public tasks() {
    }

    public String getTasks_no() {
        return tasks_no;
    }

    public void setTasks_no(String tasks_no) {
        this.tasks_no = tasks_no;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUs_NID() {
        return Us_NID;
    }

    public void setUs_NID(String Us_NID) {
        this.Us_NID = Us_NID;
    }

    public String getWorker_username() {
        return worker_username;
    }

    public void setWorker_username(String worker_username) {
        this.worker_username = worker_username;
    }

    

  
 
    
    
}
