package struts.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.Array;

import util.HibernateUtil;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Results(value = {
		@Result(name = "input", location = "/Course.jsp") 
		})
public class CourseAction extends ActionSupport implements ModelDriven<Course> {

	Course model = new Course();

	public Course getModel() {
		return model;
	}

	@Action(value = "/resetCourse")
	public String reset() throws Exception {
		addActionMessage("Vui long nhap thong tin cua khoa hoc");
		return "input";
	}

	@Action(value = "/insertCourse")
	public String insert() throws Exception {
		Configuration config = new AnnotationConfiguration().configure();
		SessionFactory factory = config.buildSessionFactory();
//		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session hsession = factory.openSession();

		Transaction transaction = hsession.beginTransaction();
		try {
			hsession.save(model);
			transaction.commit();
			addActionMessage("Them khoa hoc thanh cong!");

		} catch (Exception e) {
			transaction.rollback();
			addActionMessage("Loi: " + e.getMessage());
			e.printStackTrace();
		}
		hsession.close();
		return "input";
	}

	@Action(value = "/updateCourse")
	public String update() throws Exception {
		Configuration config = new AnnotationConfiguration().configure();
		SessionFactory factory = config.buildSessionFactory();
//		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session hsession = factory.openSession();		

		Transaction transaction = hsession.beginTransaction();
		try {

			hsession.update(model);
			transaction.commit();
			addActionMessage("Cap nhat khoa hoc thanh cong!");

		} catch (Exception e) {
			transaction.rollback();
			addActionMessage("Loi: " + e.getMessage());
		}
		hsession.close();
		return "input";
	}

	@Action(value = "/deleteCourse")
	public String delete() throws Exception {
		Configuration config = new AnnotationConfiguration().configure();
		SessionFactory factory = config.buildSessionFactory();
//		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session hsession = factory.openSession();

		Transaction transaction = hsession.beginTransaction();
		try {
			hsession.refresh(model);
			hsession.delete(model);
			model = new Course(); // Xoa form
			transaction.commit();
			addActionMessage("Xoa khoa hoc thanh cong!");
		} catch (Exception e) {
			transaction.rollback();
			addActionMessage("Loi: " + e.getMessage());
		}
		hsession.close();
		return "input";
	}

	@Action(value = "/editCourse")
	public String edit() throws Exception {
		Configuration config = new AnnotationConfiguration().configure();
		SessionFactory factory = config.buildSessionFactory();
//		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session hsession = factory.openSession();
		Transaction transaction = hsession.beginTransaction();

		try {

			hsession.refresh(model);
			transaction.commit();
			addActionMessage("Thong tin chi tiet ve khoa hoc");

		} catch (Exception e) {
			transaction.rollback();
			addActionMessage("Loi: " + e.getMessage());
		}
		hsession.close();
		return "input";

	}

	public List<?> getCourses() {
		Configuration config = new AnnotationConfiguration().configure();
		SessionFactory factory = config.buildSessionFactory();
//		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session hsession = factory.openSession();

		String hql = "From Course";
		Query query = hsession.createQuery(hql);
		List<Course> items = query.list();
		hsession.close();
		return items;

	}

}
