package task_app.task.Dto;

import java.time.LocalDateTime;

public class TaskRequest {
  public String name;
  public Boolean completed;
  public String description;
  public LocalDateTime deadline;
  public Boolean priority;
}
