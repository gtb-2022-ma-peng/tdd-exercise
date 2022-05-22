package todo.java.tdd.exercise;

import java.util.Objects;

public class Task {
    private final int id;
    private final String name;
    private final boolean isCompleted;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && isCompleted == task.isCompleted && isDeleted == task.isDeleted && Objects.equals(name, task.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, isCompleted, isDeleted);
    }

    private boolean isDeleted;

    public Task(int id, String name, boolean isCompleted, boolean isDeleted) {
        this.id = id;
        this.name = name;
        this.isCompleted = isCompleted;
        this.isDeleted = isDeleted;
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
        return this.isCompleted;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isCompleted=" + isCompleted +
                '}';
    }


    public boolean isDeleted() {
        return this.isDeleted;
    }

    public void deleted() {
        this.isDeleted = true;
    }
}
