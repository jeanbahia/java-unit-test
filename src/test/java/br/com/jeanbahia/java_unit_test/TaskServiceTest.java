package br.com.jeanbahia.java_unit_test;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import br.com.jeanbahia.java_unit_test.model.Task;
import br.com.jeanbahia.java_unit_test.model.enums.TaskStatusEnum;
import br.com.jeanbahia.java_unit_test.reporitory.TaskRepository;
import br.com.jeanbahia.java_unit_test.service.TaskService;
import br.com.jeanbahia.java_unit_test.util.TaskFactory;

@SpringBootTest
public class TaskServiceTest {
	
	@MockitoBean
	private TaskRepository taskRepository;
	
	@Autowired
	private TaskService taskService;

	@Test
	void mustAddANewTask() {
		Mockito.when(taskRepository.findAll()).thenReturn(TaskFactory.create());
		var newTask = Task.builder().title("Add new Task").description("New task added").dueDate(LocalDateTime.now().minusMinutes(5L)).status(TaskStatusEnum.PENDING).build();
		var newTaskList = taskService.addTask(newTask);
		Assertions.assertTrue(newTaskList.contains(newTask));
	}
	
	@Test
	void mustRemoveThePassedTask() {
		var newTask = Task.builder().title("Add new Task").description("New task added").dueDate(LocalDateTime.now().minusMinutes(5L)).status(TaskStatusEnum.PENDING).build();
		var taskList = TaskFactory.create();
		taskList.add(newTask);
		
		Mockito.when(taskRepository.findAll()).thenReturn(taskList);
		
		var newTaskList = taskService.removeTask(newTask);
				
		Assertions.assertFalse(newTaskList.contains(newTask));
	}
	
	@Test
	void mustReturnOnlyPendingTasks() {
		Mockito.when(taskRepository.findAll()).thenReturn(TaskFactory.create());
		var pendingTasks = taskService.getPendingTasks();		
		Assertions.assertTrue(pendingTasks.stream().allMatch(task -> task.getStatus().is(TaskStatusEnum.PENDING)));
	}
	
	@Test
	void mustReturnOnlyCompletedTasks() {
		Mockito.when(taskRepository.findAll()).thenReturn(TaskFactory.create());
		var pendingTasks = taskService.getCompletedTasks();		
		Assertions.assertTrue(pendingTasks.stream().allMatch(task -> task.getStatus().is(TaskStatusEnum.COMPLETED)));
	}
	
	@Test
	void mustReturnOnlyLateTasks() {
		Mockito.when(taskRepository.findAll()).thenReturn(TaskFactory.create());
		var pendingTasks = taskService.getLateTasks();		
		Assertions.assertTrue(pendingTasks.stream().allMatch(task -> task.getStatus().is(TaskStatusEnum.LATE)));
	}
}
