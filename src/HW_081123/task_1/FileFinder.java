package HW_081123.task_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileFinder {
    public static void main(String[] args) {
        String path = "/Users/taras/Downloads";
        getAllTextFile(path);

    }
    public static void getAllTextFile(String path){
        File folder = new File(path);
        //Проверяем указанный путь, если это директория то продолжаем.
        if (folder.isDirectory()){
            File[] files = folder.listFiles();
            //Если содержтмое папки не пустое.
            if (files != null){
                //Проходим циклом по всему содержимому.
                for (File file : files){
                    //Если находим папку то ркурсивно вызываем метод передав в аргументы путь к этой папке.
                    if (file.isDirectory()){
                        getAllTextFile(file.getAbsolutePath());
                        //Иначе проверяем имя файла на наличие ".txt" и выводим содержимое на экран.
                    } else {
                        String fileName = file.getName();
                        if (fileName.endsWith(".txt")){
                            System.out.println("txt file "  + fileName + " contains: ");
                            readAndPrintFileContents(file);
                            System.out.println("++++++++++++++++++++++++++");
                        }
                    }
                }
            }
        }else System.out.println("Provided path is not a directory.");
    }
    private static void readAndPrintFileContents(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла " + file.getName() + ": " + e.getMessage());
        }
    }
}
