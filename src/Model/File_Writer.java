/*
    The main parent class for all models, this implements the Serializable class for files to be written securely.
    This class also allows files to be saved, deleted, modified and displayed to the user.
*/

package Model;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;


public class File_Writer implements Serializable {

    private Object file_to_write;
    private JPanel body;
    private JPanel header;
    private JPanel side;
    private HashMap<String, ArrayList<String>> fileList;


    private String objectName;
    private String name;

    private int fileNumber;
    public HashMap<String, String> file;
    private String[] split;

    public File_Writer(HashMap<String, String> file_to_write, JPanel body, JPanel header, JPanel side, String objectName, int fileNumber) {
        this.file_to_write = file_to_write;
        this.fileNumber = fileNumber;
        this.body = body;
        this.header = header;
        this.side = side;
        this.objectName = objectName;
    }

    public void writeFile() {
        try {


            OutputStream fileOut = new FileOutputStream("src/Model/data/" + this.objectName + "/" + fileCount(0, "") + ".ser", true);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(file_to_write);
            objectOut.close();
            System.out.println("The Object was successfully written to " + this.objectName + "/" + fileCount(0, "") + ".ser");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public HashMap<String, String> readFile(int num, String name) throws IOException, ClassNotFoundException {

        this.file = new HashMap<>();

        FileInputStream fis = new FileInputStream("src/Model/data/" + this.objectName + name + "/" + num + ".ser");
        System.out.println("src/Model/data/" + this.objectName + name + "/" + num + ".ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        this.file = (HashMap<String, String>) ois.readObject();
        System.out.println(this.file);
        ois.close();

        return this.file;
    }

    public void delFile() {
        File getFile = new File("src/Model/data/" + this.objectName + "/" + this.fileNumber + ".ser");

        getFile.delete();
        System.out.println("File Deleted");


        File folder = new File("src/Model/data/" + this.objectName + "/");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {

            if (listOfFiles[i].isFile()) {

                File f = new File("src/Model/data/" + this.objectName + "/" + listOfFiles[i].getName());
                System.out.println(f);
                f.renameTo(new File("src/Model/data/" + this.objectName + "/" + i + ".ser"));
                System.out.println(f);
            }
        }
    }

    public void editFile() {
        try {

            FileOutputStream fileOut = new FileOutputStream("src/Model/data/" + this.objectName + "/" + this.fileNumber + ".ser", false);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(file_to_write);
            objectOut.close();
            System.out.println("The Object was successfully edited to " + this.objectName + "/" + this.fileNumber + ".ser");

            this.split = this.objectName.split("/");

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    public int fileCount(int i, String name) {
        fileNumber = Objects.requireNonNull(new File("src/Model/data/" + this.objectName + name).list()).length;
        return fileNumber - i;
    }
}


