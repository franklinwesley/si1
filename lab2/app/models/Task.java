package models;

import java.util.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
public class Task extends Model implements Comparable<Object> {
    // TODO declarar atributos privados
	@Id
	private Long id;
	  
	@Required
	public String registrar;
	public boolean feita = false;
	@Required
	public int prioridade;
	@Required
	public String projeto;
	
	public static Finder<Long,Task> find = new Finder(Long.class, Task.class);
  
	public Long getId() {
		return id;
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
        if (task.feita == true) {
        	task.feita = false;
        } else{
        	task.feita = true;
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