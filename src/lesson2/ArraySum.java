package lesson2;

class ArraySum {
  static int sumArr(String[][] arr, int size) throws MyArraySizeException, MyArrayDataException{
    int sum = 0;
    int cell;

    if (arr.length != size){
      // для точности сообщения можно найти MIN(arr[i].length)
      throw new MyArraySizeException(arr.length, arr[0].length, size);
    }

    for (int i = 0; i < arr.length; i++){
      if (arr[i].length != size){
        throw new MyArraySizeException(arr.length, arr[i].length, size);
      }

      for (int j = 0; j < arr[i].length; j++){
        try {
          cell = Integer.parseInt(arr[i][j], 10);
          sum += cell;
        }
        catch (NumberFormatException e){
          String[] msg = e.getMessage().split("\"", 3);
          throw new MyArrayDataException(i, j, msg[1]); //msg[msg.length-2]
        }
      }
    }

    return sum;
  }
}
