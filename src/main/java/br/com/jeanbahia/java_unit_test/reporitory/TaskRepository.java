package br.com.jeanbahia.java_unit_test.reporitory;

import java.util.List;

import br.com.jeanbahia.java_unit_test.model.Task;

public interface TaskRepository {

	List<Task> findAll();
}
