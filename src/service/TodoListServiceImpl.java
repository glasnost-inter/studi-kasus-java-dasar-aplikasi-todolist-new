package service;

import entity.Todolist;
import repository.TodoListRepository;

public class TodoListServiceImpl implements TodoListService{

    TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public void showTodoList() {

        Todolist[] model = todoListRepository.getAll();
        System.out.println("TODO LIST");

        for(var i = 0; i < model.length; i++){
            var todolist= model[i];
            var no = i + 1;

            if(todolist != null){
                System.out.println(no + ". " + todolist.getTodo());
            }
        }

    }

    @Override
    public void addTodoList(String todo) {
        Todolist todolist = new Todolist(todo);
        todoListRepository.add(todolist);
        System.out.println("Sukses menambahkan todo : "+todo);
    }

    @Override
    public Boolean removeTodoList(Integer number) {
        Boolean success = todoListRepository.remove(number);
        if (success){
            System.out.println("Sukses menghapus todo ke : "+number);
        }else {
            System.out.println("Gagal menghapus todo ke : "+number);
        }
        return success;
    }
}
