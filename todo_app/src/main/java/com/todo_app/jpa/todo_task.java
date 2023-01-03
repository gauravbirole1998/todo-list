package com.todo_app.jpa;

import javax.persistence.*;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name="todo_tasks")
public class todo_task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ColumnDefault("1")
	private int task_id;
	private String task;
	
	public todo_task(int task_id , String task) {
		super();
		this.task_id = task_id;
		this.task = task;
	}
	
	public todo_task() {
		super();
	}
	
	public int getId() {
		return task_id;
	}
	
	public void setId(int task_id) {
		this.task_id = task_id; 
	}
	
	public String getTask() {
		return task;
	}
	
	public void setTask(String task) {
		this.task = task;
	}
	
	@Override
	public String toString() {
		return this.task_id+" : "+this.task+" : ";
	}
	

}
