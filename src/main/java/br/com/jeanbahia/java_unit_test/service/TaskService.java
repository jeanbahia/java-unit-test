package br.com.jeanbahia.java_unit_test.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.jeanbahia.java_unit_test.model.Task;
import br.com.jeanbahia.java_unit_test.model.enums.TaskStatusEnum;

@Service
public class TaskService {

	public List<Task> addTask(List<Task> tasks) {
		tasks.add(Task.builder().title("Add new Task").description("New task added").dueDate(LocalDateTime.now().minusMinutes(5L)).status(TaskStatusEnum.PENDING).build());
		return tasks;
	}

	public List<Task> removeTask(List<Task> tasks) {
		tasks.removeIf(task -> task.getTitle().equals("Add new Task"));
		return tasks;
	}
	
	public List<Task> getPendingTasks(List<Task> tasks) {
		return tasks.stream().filter(task -> task.getStatus().is(TaskStatusEnum.PENDING)).collect(Collectors.toList());
	}
	
	public List<Task> getCompletedTasks(List<Task> tasks) {
		return tasks.stream().filter(task -> task.getStatus().is(TaskStatusEnum.COMPLETED)).collect(Collectors.toList());
	}
	
	public List<Task> getLateTasks(List<Task> tasks) {
		return tasks.stream().filter(task -> task.getStatus().is(TaskStatusEnum.LATE)).collect(Collectors.toList());
	}
}
