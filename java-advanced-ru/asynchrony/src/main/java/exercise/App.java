package exercise;

import java.util.concurrent.CompletableFuture;
import java.util.Arrays;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.StandardOpenOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.FileWriter;
import java.io.IOException;

class App {

        // BEGIN
        public static CompletableFuture<String>  unionFiles(String file1, 
                                                            String file2, 
                                                            String file3){
            CompletableFuture<String> file1Str = CompletableFuture.supplyAsync(() -> {
                try {
                    String result = Files.readString(Path.of(file1));
                    return result;
                } catch (IOException e) {
                    System.out.println("NoSuchFileException");
                    return null;
                }    
            }).exceptionally(ex -> {
                    System.out.println("NoSuchFileException");
                    return null;
                });
                
            CompletableFuture<String> file2Str = CompletableFuture.supplyAsync(() -> {
                try {
                    String result = Files.readString(Path.of(file2));
                    return result;
                } catch (IOException e) {
                       return "NoSuchFileException";
                } 
            }).exceptionally(ex -> {
                    System.out.println("Oops! We have an exception - " + ex.getMessage());
                    return null;
                });
            CompletableFuture<String> file3Str = file1Str.thenCombine(file2Str, (str1, str2) -> {
                    var result = str1 + "\n" + str2;
                    try {
                       FileWriter writer = new FileWriter(file3, true);
                       writer.write(result);
                       writer.close();
                    } catch (IOException e) {
                       System.out.println("Возникла ошибка во время записи, проверьте данные.");
                    }
                    return result;
                // Обработка исключений
                // Если при работе задач возникли исключения
                // их можно обработать в методе exceptionally
                }).exceptionally(ex -> {
                    System.out.println("Oops! We have an exception - " + ex.getMessage());
                    return null;
                });
            return file3Str;
        }
    // END

    public static void main(String[] args) throws Exception {
       // BEGIN
        CompletableFuture<String> result = unionFiles("src/main/resources/file1.txt",
            "src/main/resources/file2.txt", "src/main/resources/file3.txt");
        // END
    }
}

