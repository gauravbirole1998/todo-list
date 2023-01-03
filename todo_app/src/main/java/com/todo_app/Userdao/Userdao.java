package com.todo_app.Userdao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.todo_app.jpa.*;
import com.todo_app.hbnprop.*;

public class Userdao {

	public void saveTask(todo_task task) {
		Transaction transaction = null;
		Session session = Hbnprop.getSessionFactory().openSession();
		try{
			transaction = session.beginTransaction();
			session.save(task);
			transaction.commit();
		}
		catch(Exception ex) {
			if (transaction != null) {
                session.close();
            }
            ex.printStackTrace();
		}
		
	}
	
	

	public todo_task getTask(int id) {

        Transaction transaction = null;
        todo_task user = null;
        try (Session session = Hbnprop.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            user = session.get(todo_task.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return user;
    }

	@SuppressWarnings("unchecked")
    public List < todo_task > getAllUser() {

        Transaction transaction = null;
        List < todo_task > listOfUser = null;
        try (Session session = Hbnprop.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object

            listOfUser = session.createQuery("from todo_task").getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfUser;
    }
	
	
}
