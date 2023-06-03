import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FolderLocker {
    public static void main(String[] args) {
        String folderPath = "C:\\Users\\Kunal Khandale\\OneDrive\\Desktop\\java";
        lockFolder(folderPath);
        unlockFolder(folderPath);
    }

    public static void lockFolder(String folderPath) {
        try {

            File folder = new File(folderPath);
            File lockerFile = new File(folderPath + ".locked");
            if (folder.exists()) {

                folder.renameTo(lockerFile);
                System.out.println("Folder locked successfully.");
            } else {
                System.out.println("Folder does not exist.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void unlockFolder(String folderPath) {
        try {
            File lockerFile = new File(folderPath + ".locked");
            File folder = new File(folderPath);
            if (lockerFile.exists()) {

                lockerFile.renameTo(folder);
                System.out.println("Folder unlocked successfully.");
            } else {
                System.out.println("Folder is not locked.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
