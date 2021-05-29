package repository;

import entity.Todolist;

public class TodoListRepositoryImpl implements TodoListRepository{

    public Todolist[] data = new Todolist[10];

    @Override
    public Todolist[] getAll() {
        return data;
    }


    public boolean isFull(){
        // 2. validasi apakah array penuh atau tidak
        var isFull = true;

        for(var i=0;i< data.length;i++){
            if(data[i]==null){
                isFull = false;
                break;
            }
        }

        return isFull;
    }

    public void resizeIfFull(){
        if(isFull()){
            var temp = data; // simpan sementara data sebelumnya
            data = new Todolist[data.length * 2]; // resize ukuran array dengan deklarasi baru

            /*
            // mengisikan data array sebelumnya ke array baru yg baru di resize
             */
            for (var i = 0; i < temp.length; i++){
                data[i] = temp[i];
            }

        }
    }

    @Override
    public void add(Todolist todolist) {

        resizeIfFull();

        // 1. tambahkan ke posisi yang array nya null
        for (var i = 0; i < data.length; i++){
            if(data[i]==null){
                data[i]=todolist;
                break;
            }
        }
    }

    @Override
    public boolean remove(Integer number) {
        var index = number - 1;

        if(index >= (data.length - 1)){
            return false;
        }

        if (index == data.length){
            data[index] = null;
        }else{
            for(var i = index; i < (data.length - 1); i++){
                data[i] = data[i+1];
            }
        }

        return true;
    }
}
