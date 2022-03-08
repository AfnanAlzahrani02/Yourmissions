/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yourmissions;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="worker")

public class worker implements java.io.Serializable{
    
     @Column(name="fullname")
    private String fullname;
     @Column(name="W_NID")
    private String W_NID;
     @Id
      @Column(name="username")
    private String username;
       @Column(name="email")
    private String email;
       @Column(name="password")
    private String password;
       @Column(name="sex")
    private String sex;
       @Column(name="jop")
    private String jop;
       @Column(name="DOB")
    private String DOB;
       @Column(name="U_NID")
    private String U_NID;
       
    
    public worker() {
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getW_NID() {
        return W_NID;
    }

    public void setW_NID(String W_NID) {
        this.W_NID = W_NID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getJop() {
        return jop;
    }

    public void setJop(String jop) {
        this.jop = jop;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getU_NID() {
        return U_NID;
    }

    public void setU_NID(String U_NID) {
        this.U_NID = U_NID;
    }
    
}