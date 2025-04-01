package br.com.jeanbahia.java_unit_test.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jeanbahia.java_unit_test.model.Task;
import br.com.jeanbahia.java_unit_test.model.enums.TaskStatusEnum;
import br.com.jeanbahia.java_unit_test.reporitory.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;

	public List<Task> addTask(Task task) {
		var tasks = taskRepository.findAll();
		tasks.add(task);
		return tasks;
	}

	public List<Task> removeTask(Task task) {
		var tasks = taskRepository.findAll();
		tasks.removeIf(taskDb -> taskDb.getTitle().equals(task.getTitle()));
		return tasks;
	}
	
	public List<Task> getPendingTasks() {
		var tasks = taskRepository.findAll();
		return tasks.stream().filter(task -> task.getStatus().is(TaskStatusEnum.PENDING)).collect(Collectors.toList());
	}
	
	public List<Task> getCompletedTasks() {
		var tasks = taskRepository.findAll();
		return tasks.stream().filter(task -> task.getStatus().is(TaskStatusEnum.COMPLETED)).collect(Collectors.toList());
	}
	
	public List<Task> getLateTasks() {
		var tasks = taskRepository.findAll();
		return tasks.stream().filter(task -> task.getStatus().is(TaskStatusEnum.LATE)).collect(Collectors.toList());
	}
}
