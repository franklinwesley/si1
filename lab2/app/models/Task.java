package models;

import java.util.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
public class Task extends Model implements Comparable<Object> {

	@Id
	private Long id;
	@Required
	public String registrar;
	private boolean feito = false;
	@Required
	public int prioridade;
	@Required
	public String projeto;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Finder<Long,Task> find = new Finder(Long.class, Task.class);
  
	public Long getId() {
		return id;
	}
	
	public boolean isFeito() {
		return feito;
	}

	public void setFeito(boolean feito) {
		this.feito = feito;
	}

	public String getRegistrar() {
		return registrar;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public String getProjeto() {
		return projeto;
	}
	
	public static List<Task> all() {
		  return find.all();
	}
	
	public static void create(Task task) {
		task.save();
	}

	public static void delete(Long id) {
		find.ref(id).delete();
	}
	
	public static void update(Long id) {
		Task task = find.ref(id);
        if (task.isFeito() == true) {
        	task.setFeito(false);
        } else{
        	task.setFeito(true);
        }
        task.update();
	}

	@Override
	public int compareTo(Object arg0) {
		int result;
		if (prioridade == ((Task)arg0).prioridade) {
			result = 0;
		} else if (prioridade >= ((Task)arg0).prioridade) {
			result = 1;
		} else {
			result = -1;
		}
		return result;
	}
    	
}