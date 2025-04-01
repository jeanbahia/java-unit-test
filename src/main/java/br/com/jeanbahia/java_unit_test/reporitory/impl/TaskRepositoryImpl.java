package br.com.jeanbahia.java_unit_test.reporitory.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.jeanbahia.java_unit_test.model.Task;
import br.com.jeanbahia.java_unit_test.reporitory.TaskRepository;

//We'll use this class to simulate Mockito usage.
@Repository
public class TaskRepositoryImpl implements TaskRepository{

	public List<Task> findAll(){
		return new ArrayList<Task>();
	}
}
