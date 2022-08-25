public class AddTodoCommand extends Command {
    private String description;

    AddTodoCommand(String description) {
        this.description = description;
    }

    @Override
    void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        Todo todo = new Todo(description);
        tasks.add(todo);
        ui.printMessage("\tGot it. I've added this task:\n\t" +
                todo.toString() +
                "\n\tNow you have " + tasks.size() + " tasks in the list.");
        storage.save(tasks.getAllTasks());
    }
}
