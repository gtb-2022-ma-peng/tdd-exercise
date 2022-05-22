package todo.java.tdd.exercise;

import java.util.Objects;

public class Task {
    private final int id;
    private final String name;
    private final boolean completed;
    private boolean deleted;


    public Task(int id, String name, boolean completed, boolean isDeleted) {
        this.id = id;
        this.name = name;
        this.completed = completed;
        this.deleted = isDeleted;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    String format() {
        return String.format("%d %s", getId(), getName());
    }

    public boolean isCompleted() {
        return this.completed;
    }

    public boolean isDeleted() {
        return this.deleted;
    }

    public void deleted() {
        this.deleted = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && completed == task.completed && deleted == task.deleted && Objects.equals(name, task.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, completed, deleted);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", completed=" + completed +
                ", deleted=" + deleted +
                '}';
    }
}
