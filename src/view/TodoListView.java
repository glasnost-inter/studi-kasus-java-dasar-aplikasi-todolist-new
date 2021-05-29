package view;

import service.TodoListService;
import util.InputUtil;

public class TodoListView {

    TodoListService todoListService;

    public TodoListView(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    public void showTodoList() {
        while (true){
            todoListService.showTodoList();

            System.out.println("Menu Input");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("0. Keluar");

            var input = InputUtil.input("Pilih");

            if (input.equals("1")){
                addTodoList();
            }else if(input.equals("2")){
                removeTodoList();
            }else if(input.equals("0")){
                break;
            }else{
                System.out.println("Pilihan tidak tersedia");
            }
        }
    }

    public void addTodoList(){
        var input = InputUtil.input("Isikan (x) untuk batal/ isikan Todo List");

        if (input.equals("x")){
            System.out.println("Tidak jadi menambahkan Todo List");
        } else {
            todoListService.addTodoList(input);
        }
    }

    public void removeTodoList(){
        var input = InputUtil.input("Isikan (x) untuk batal/ isikan nomor Todo List");

        if (input.equals("x")){
            System.out.println("Tidak jadi menghapus Todo List");
        } else {
            Boolean success = todoListService.removeTodoList(Integer.valueOf(input));

            System.out.println("success "+ success);

            if(!success){
                System.out.println("gagal menghapus todo list "+ input);
            }
        }
    }
}
