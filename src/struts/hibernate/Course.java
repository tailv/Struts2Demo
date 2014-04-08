package struts.hibernate;

import java.util.Date;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="Courses")
public class Course {
	@Id
	@GeneratedValue
	int Id;
	String Name;
	double Schoolfee;
	int NoOfLearners;
	@Temporal (TemporalType.DATE)
	Date StartDate;
	boolean Finished;
	String Description;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public double getSchoolfee() {
		return Schoolfee;
	}
	public void setSchoolfee(double schoolfee) {
		Schoolfee = schoolfee;
	}
	public int getNoOfLearners() {
		return NoOfLearners;
	}
	public void setNoOfLearners(int noOfLearners) {
		NoOfLearners = noOfLearners;
	}
	public Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	public boolean isFinished() {
		return Finished;
	}
	public void setFinished(boolean finished) {
		Finished = finished;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
}
