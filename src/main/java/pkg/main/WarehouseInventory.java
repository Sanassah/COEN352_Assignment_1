package pkg.main;

import org.apache.log4j.BasicConfigurator;
import org.apache.poi.xssf.usermodel.*;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.ArrayList;

public class WarehouseInventory {
    static DLLDictionary <String, Inventory> invRecord;

    public static void main(String[] args) throws IOException {

        BasicConfigurator.configure();

        String sheetName = "Inventory List";
        String path = new File("src/main/resources/Inventory.xlsx").getAbsolutePath();
        System.out.println(path);
        FileInputStream inputStream = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(3).getLastCellNum();

        //Testing

        //1. Insert the records
        invRecord = new DLLDictionary <> ();

        for(int r=3; r<=(rows);r++){
            XSSFRow row = sheet.getRow(r);
            XSSFCell[] datas = new XSSFCell[10];
            for(int c=2;c<=(cols-1);c++){
                XSSFCell cell = row.getCell(c);
                datas[c-2] = cell;
            }

            invRecord.insert(datas[0].getStringCellValue(),
                    new Inventory(datas[0].getStringCellValue(),datas[1].getStringCellValue(),
                            datas[2].getStringCellValue(),datas[3].getNumericCellValue(),datas[4].getNumericCellValue(),
                            datas[3].getNumericCellValue()*datas[4].getNumericCellValue(),datas[6].getNumericCellValue(),
                            datas[7].getNumericCellValue(),datas[8].getNumericCellValue(),datas[9].getBooleanCellValue()));

        }

        //1.2 Test nlogn sorting index
        int[] tab = createIndex("reorderLevel");
        for(int i = 0; i < tab.length; i++){
            System.out.println(tab[i]);
        }
    }
    //create index with nlogn quick sorting
    public static int[] createIndex(String attribute){

        switch(attribute)
        {
            case "inventoryID": {
                DLList list = invRecord.getList();
                list.moveToStart();
                list.next();
                ArrayList<String> result = new ArrayList<>();


                int count = 0;
                while (count < list.length()) {
                    count++;
                    result.add(((Inventory) (((KVpair) (list.curr.element())).getValue())).getInventoryID());
                    list.next();
                }

                ArrayList<String> result2 = (ArrayList<String>) result.clone();

                int[] result3 = new int[count];
                quickSort1(result, 0, count - 1);
                for (int i = 0; i < result2.size(); i++) {
                    result3[i] = result.indexOf(result2.get(i));
                }
                return result3;
            }
			case "name": {
                DLList list = invRecord.getList();
                list.moveToStart();
                list.next();
                ArrayList<String> result = new ArrayList<>();


                int count = 0;
                while (count < list.length()) {
                    count++;
                    result.add(((Inventory) (((KVpair) (list.curr.element())).getValue())).getName());
                    list.next();
                }

                ArrayList<String> result2 = (ArrayList<String>) result.clone();

                int[] result3 = new int[count];
                quickSort1(result, 0, count - 1);
                for (int i = 0; i < result2.size(); i++) {
                    result3[i] = result.indexOf(result2.get(i));
                }
                return result3;
            }
			case "description": {
                DLList list = invRecord.getList();
                list.moveToStart();
                list.next();
                ArrayList<String> result = new ArrayList<>();

                int count = 0;
                while (count < list.length()) {
                    count++;
                    result.add(((Inventory) (((KVpair) (list.curr.element())).getValue())).getDescription());
                    list.next();
                }

                ArrayList<String> result2 = (ArrayList<String>) result.clone();

                int[] result3 = new int[count];
                quickSort1(result, 0, count - 1);
                for (int i = 0; i < result2.size(); i++) {
                    result3[i] = result.indexOf(result2.get(i));
                }
                return result3;
            }
			case "unitPrice": {
                DLList list = invRecord.getList();
                list.moveToStart();
                list.next();
                ArrayList<Double> result = new ArrayList<>();

                int count = 0;
                while (count < list.length()) {
                    count++;
                    result.add(((Inventory) (((KVpair) (list.curr.element())).getValue())).getUnitPrice());
                    list.next();
                }

                ArrayList<Double> result2 = (ArrayList<Double>) result.clone();

                int[] result3 = new int[count];
                quickSort(result, 0, count - 1);
                for (int i = 0; i < result2.size(); i++) {
                    result3[i] = result.indexOf(result2.get(i));
                }
                return result3;
            }
			case "quantityInStock": {
                DLList list = invRecord.getList();
                list.moveToStart();
                list.next();
                ArrayList<Double> result = new ArrayList<>();

                int count = 0;
                while (count < list.length()) {
                    count++;
                    result.add(((Inventory) (((KVpair) (list.curr.element())).getValue())).getQuantityInStock());
                    list.next();
                }

                ArrayList<Double> result2 = (ArrayList<Double>) result.clone();

                int[] result3 = new int[count];
                quickSort(result, 0, count - 1);
                for (int i = 0; i < result2.size(); i++) {
                    result3[i] = result.indexOf(result2.get(i));
                }
                return result3;
            }
			case "inventoryValue":{
                DLList list = invRecord.getList();
                list.moveToStart();
                list.next();
                ArrayList<Double> result = new ArrayList<>();

                int count = 0;
                while (count < list.length()) {
                    count++;
                    result.add(((Inventory) (((KVpair) (list.curr.element())).getValue())).getInventoryValue());
                    list.next();
                }

                ArrayList<Double> result2 = (ArrayList<Double>) result.clone();

                int[] result3 = new int[count];
                quickSort(result, 0, count - 1);
                for (int i = 0; i < result2.size(); i++) {
                    result3[i] = result.indexOf(result2.get(i));
                }
                return result3;
            }
			case "reorderLevel":{
                DLList list = invRecord.getList();
                list.moveToStart();
                list.next();
                ArrayList<Double> result = new ArrayList<>();

                int count = 0;
                while (count < list.length()) {
                    count++;
                    result.add(((Inventory) (((KVpair) (list.curr.element())).getValue())).getReorderLevel());
                    list.next();
                }

                ArrayList<Double> result2 = (ArrayList<Double>) result.clone();

                int[] result3 = new int[count];
                quickSort(result, 0, count - 1);
                for (int i = 0; i < result2.size(); i++) {
                    result3[i] = result.indexOf(result2.get(i));
                }
                return result3;
            }

            case "reorderTime": {
                DLList list = invRecord.getList();
                list.moveToStart();
                list.next();
                ArrayList<Double> result = new ArrayList<>();

                int count = 0;
                while (count < list.length()) {
                    count++;
                    result.add(((Inventory) (((KVpair) (list.curr.element())).getValue())).getReorderTime());
                    list.next();
                }

                ArrayList<Double> result2 = (ArrayList<Double>) result.clone();

                int[] result3 = new int[count];
                quickSort(result, 0, count - 1);
                for (int i = 0; i < result2.size(); i++) {
                    result3[i] = result.indexOf(result2.get(i));
                }
                return result3;
            }
			case "quantityInReorder":{
                DLList list = invRecord.getList();
                list.moveToStart();
                list.next();
                ArrayList<Double> result = new ArrayList<>();

                int count = 0;
                while (count < list.length()) {
                    count++;
                    result.add(((Inventory) (((KVpair) (list.curr.element())).getValue())).getQuantityInReorder());
                    list.next();
                }

                ArrayList<Double> result2 = (ArrayList<Double>) result.clone();

                int[] result3 = new int[count];
                quickSort(result, 0, count - 1);
                for (int i = 0; i < result2.size(); i++) {
                    result3[i] = result.indexOf(result2.get(i));
                }
                return result3;
            }
			default:
				System.out.println("Invalid attribute!");
                return null;
        }
    }

    public static void quickSort1(ArrayList<String> arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition1(arr, begin, end);

            quickSort1(arr, begin, partitionIndex-1);
            quickSort1(arr, partitionIndex+1, end);
        }
    }
    private static int partition1(ArrayList<String> arr, int begin, int end) {
        String pivot = arr.get(end);
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            int value = arr.get(j).compareTo(pivot);
            if (value<=0) {
                i++;
                String swapTemp = arr.get(i);
                arr.set(i,arr.get(j));
                arr.set(j,swapTemp);
            }
        }

        String swapTemp = arr.get(i+1);
        arr.set(i+1,arr.get(end));
        arr.set(end,swapTemp);

        return i+1;
    }

    public static void quickSort(ArrayList<Double> arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }
    private static int partition(ArrayList<Double> arr, int begin, int end) {
        double pivot = arr.get(end);
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr.get(j)<=pivot) {
                i++;
                double swapTemp = arr.get(i);
                arr.set(i,arr.get(j));
                arr.set(j,swapTemp);
            }
        }

        double swapTemp = arr.get(i+1);
        arr.set(i+1,arr.get(end));
        arr.set(end,swapTemp);

        return i+1;
    }


}


