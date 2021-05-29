package service;

public interface TodoListService {
    void showTodoList();

    void addTodoList(String todo);

    Boolean removeTodoList(Integer number);
}
