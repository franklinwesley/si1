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
	private static String registrar;
	private boolean feito = false;
	@Required
	private static int prioridade;
	@Required
	private static String projeto;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Finder<Long,Task> find = new Finder(Long.class, Task.class);
  
	public Long getId() {
		return id;
	}
	
	public static void setRegistrar(String descricao) {
		registrar = descricao;
	}

	public static void setPrioridade(int newPrioridade) {
		prioridade = newPrioridade;
	}

	public static void setProjeto(String newProjeto) {
		projeto = newProjeto;
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
	
	@SuppressWarnings("static-access")
	public static void create(Task task) {
		setRegistrar(task.registrar);
		setProjeto(task.projeto);
		setPrioridade(task.prioridade);
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

	@SuppressWarnings("static-access")
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