public class Main {
    public static void main(String[] args) {
        int[] zeroOneArr = {0,1,0,1,0,0,1,0,1,1};
        int[] thousandArr = new int[100];
        int[] lessSix = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[][] sqrArr = new int[10][10];
        int[] minMaxArr= {3,5,0,-1,3,10};
        int[] checkArr = {2,2,2,4,2};
        int[] turnArr = {1,2,3,4};

        System.out.println("Задание Один");
        revertArr(zeroOneArr);

        System.out.println("Задание Два");
        arrayFiller(thousandArr);

        System.out.println("");
        System.out.println("Задание Три");
        lessSix(lessSix);
        System.out.println("\n Задание Четыре");
        diagonalArr(sqrArr);
        System.out.println("\n Задача Пять");
        lenInit(5,2);
        System.out.println("\n Задача Шесть");
        minMaxArr(minMaxArr);
        System.out.println("\n Задача Семь");
        checkArr(checkArr);
        System.out.println("\n Задача Восемь");
        turnArrElem(1, turnArr);
    }

    public static void revertArr(int arr[]){
        for(int i = 0; i< arr.length; i++){
            if (arr[i] == 0 || arr[i]==1) {
                if (arr[i] == 0) arr[i] = 1;
                else arr[i] = 0;
                System.out.println("Перевертыш массива: элемент "+(i+1)+" равен "+ arr[i]);
            }
            else{
                System.out.println("Неккоректное число");
                break;
            }
        }
    }
    public static void arrayFiller(int arr[]){
        for (int i = 0; i<100; i++){
            arr[i]=i;
            System.out.print((arr[i]+1)+" ");
        }
    }
    public static void lessSix(int arr[]){
        for (int i=0; i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println("\nМеньшие числа умножены на 2");
        for (int i=0; i<arr.length;i++) {
            if(arr[i]<6) arr[i]*=2;
            System.out.print(arr[i]+" ");
        }
    }
    public static void diagonalArr(int sqrArr[][]){
        for(int i = 0; i < sqrArr.length;i++){ ///создание квадрата
            for (int j=0; j<sqrArr[i].length;j++){
                if(i==j) sqrArr[i][j]=1;
                else sqrArr[i][j] = 0;
            }
        }
        for(int i = 0; i<sqrArr.length;i++){
            for (int j=0; j<sqrArr[i].length;j++){
                System.out.print(sqrArr[i][j]+" ");
            }
            System.out.println("");
        }


    }
    public static int[] lenInit(int len, int initialValue){
        int[] arr = new int[len];
        for (int i: arr) {
            arr[i] = initialValue;
            System.out.print(arr[i]+" ");
        }
        return  arr;
    }


    ///задачки со зведочкой
    public static void minMaxArr(int arr[]){
        int min = arr[0];
        int max = arr[0];
        for (int i=0; i<arr.length; i++) {
            if(min>arr[i]){
                min = arr[i];
            }
            else if(max<arr[i]){
                max = arr[i];
            }
        }
        System.out.printf("Самое маленькое число - это %s. Самое большое число - это %s", min,max);
    }
    public static boolean checkArr(int arr[]) {
        int sum = 0;
        int halfSum = 0;
        int halfArr = 0;
        int arrSum1 = 0;
        int arrSum2 = 0;
        for (int i : arr) { //вычитываем всю сумму и его половину
            sum += arr[i];
            halfSum = sum / 2;
        }
        for (int i = 0; i < arr.length; i++) { //ищем половину суммы из массива
            arrSum1 += arr[i];
            if (arrSum1 == halfSum) {
                halfArr = i; //останавливаеся на половине;
                break;
            }
        }
        for (int i = halfArr; i < arr.length; i++) { //передаем, где мы остановились
            arrSum2 += arr[i];
        }
        if (arrSum1 == arrSum2) {
            System.out.println("Левая и правая стороны равны ");
            return true;
        } else {
            System.out.println("Левая и правая стороны не равны");
            return false;
        }
    }

    //Вы сказали не брать с интернета - я нашел свой древний проект из Delphi и взял оттуда, свою, готовую процедуру
    public static void turnArrElem(int n, int[] arr){
        int turnLeft;
        int turnRight;

        if(n==0) System.out.println("Нуль - нет движения чисел");

        else if(n>0){
            for(int i=0;i<n;i++){//отчет каждого шага вправо
                turnRight = arr[arr.length-1];//сохраняет последнию позицию
                for (int j= arr.length-1;j>0;j--){ //отчет сконца массива; длина массива отнимают 1, ведь отчет с 0
                    arr[j]=arr[j-1]; //нынешнее число присваивает значение предыдущей
                }
                arr[0]=turnRight;//переносит последнюю позицию в начало
                // без этого первое число не меняется, ведь нет предыдущего элемента, от которого надо присвоить значение

            }
        }
        else { //ровно противоположные действия
            for(int i= 0; i<n*-1; i++){
                turnLeft = arr[0];
                for (int j = 0;j<arr.length-1 ;j++){
                    arr[j]=arr[j+1];
                }
                arr[arr.length-1]=turnLeft;
            }
        }

        for(int i=0;i< arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

}

