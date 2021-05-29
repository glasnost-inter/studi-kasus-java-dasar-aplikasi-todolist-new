public class AplikasiTodolist {

    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        //testShowTodoList(); --> unit test hanya menampilkan todo list awal

        //testAddTodoList(); --> unit test untuk menambahkan data dan menampilkan todo list

        //testRemoveTodoLit(); --> unit test untuk menghapus data dan menampilkan todo list

        //testInput(); --> unit test input dari user

        //testViewTodoList(); --> unit test view todo list

        //testViewAddTodoList(); --> unit test view  tambahkan todo list

        testViewRemoveTodoList();
    }

    /*
    Bisnis logic Menampilkan todo list
    */
    public static void showTodoList(){
        System.out.println("TODO LIST");

        for(var i = 0; i < model.length; i++){
            var todo= model[i];
            var no = i + 1;

            if(todo != null){
                System.out.println(no + ". " + todo);
            }
        }
    }

    /*
    Unit test bisnis logic menampilkan todo list
     */
    public static void testShowTodoList(){
        model[0] = "Belajar Java Dasar";
        model[1] = "Studi kasus java dasar : aplikasi todo list";
        showTodoList();
    }

    /*
    Bisnis logic Menambahkan todo list dengan menginput nama todo list
    */
    public static void addTodoList(String todo){

        // 2. validasi apakah array penuh atau tidak
        var isFull = true;

        for(var i=0;i< model.length;i++){
            if(model[i]==null){
                isFull = false;
                break;
            }
        }

        if(isFull){
            var temp = model; // simpan sementara data sebelumnya
            model = new String[model.length * 2]; // resize ukuran array dengan deklarasi baru

            /*
            // mengisikan data array sebelumnya ke array baru yg baru di resize
             */
            for (var i = 0; i < temp.length; i++){
                model[i] = temp[i];
            }

        }

        // 1. tambahkan ke posisi yang array nya null
        for (var i = 0; i < model.length; i++){
            if(model[i]==null){
                model[i]=todo;
                break;
            }
        }

    }

    /*
    Unit Test bisnis logic menambahkan todo list dengan menginput nama todo list
     */

    public static void testAddTodoList(){
        for (var i = 0; i < 25; i++){
            addTodoList("Contoh todo list ke. "+ i);
        }

        showTodoList();
    }

    /*
    Bisnis logic Menghapus todo list dengan menginputkan urutan todo list
     */
    public static boolean removeTodoList(Integer number){

        var index = number - 1;

        if(index >= (model.length - 1)){
            return false;
        }

        if (index == model.length){
            model[index] = null;
        }else{
            for(var i = index; i < (model.length - 1); i++){
                model[i] = model[i+1];
            }
        }

        return true;
    }

    /*
    Unit test Menghapus todo list dengan menginputkan urutan todo list
     */

    public static void testRemoveTodoLit(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");

        var status = removeTodoList(3);

        System.out.println(status);

        showTodoList();
    }

    /*
    Bisnis logic untuk input nilai dari user
     */

    public static String input(String info){
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    /*
    unit testing untuk input nilai dari user
     */

    public static void testInput(){
        var name = input("Nama");
        System.out.println("Hallo "+ name);
    }


    /*
    View Menampilkan todo list
     */
    public static void viewShowTodoList(){
        while (true){
            showTodoList();

            System.out.println("Menu Input");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("0. Keluar");

            var input = input("Pilih");

            if (input.equals("1")){
                viewAddTodoList();
            }else if(input.equals("2")){
                viewRemoveTodoList();
            }else if(input.equals("0")){
                break;
            }else{
                System.out.println("Pilihan tidak tersedia");
            }
        }
    }

    /*
    unit testing View Menampilkan todo list
     */

    public static void testViewTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");

        viewShowTodoList();
    }

    /*
    View menambah todo list
     */
    public static void viewAddTodoList(){

        var input = input("Isikan (x) untuk batal/ isikan Todo List");

        if (input.equals("x")){
            System.out.println("Tidak jadi menambahkan Todo List");
        } else {
            addTodoList(input);
        }
    }

    /*
    unit testing View Menambahkan todo list
     */

    public static void testViewAddTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        viewAddTodoList();
        showTodoList();
    }

    /*
    View menghapus todo list
     */
    public static void viewRemoveTodoList(){
        var input = input("Isikan (x) untuk batal/ isikan nomor Todo List");

        if (input.equals("x")){
            System.out.println("Tidak jadi menghapus Todo List");
        } else {
            Boolean success = removeTodoList(Integer.valueOf(input));

            System.out.println("success "+ success);

            if(!success){
                System.out.println("gagal menghapus todo list "+ input);
            }
        }
    }

    public static void testViewRemoveTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        viewRemoveTodoList();
        showTodoList();
    }
}
