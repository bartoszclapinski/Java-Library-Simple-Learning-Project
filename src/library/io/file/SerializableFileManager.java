package library.io.file;

import library.exception.DataExportException;
import library.exception.DataImportException;
import library.model.Library;

import java.io.*;

public class SerializableFileManager implements FileManager {
    private static final String FILE_NAME = "Library.o";

    @Override
    public Library importData() {
        try (
            FileInputStream fos = new FileInputStream(FILE_NAME);
            ObjectInputStream oos = new ObjectInputStream(fos);
        ){
            return (Library) oos.readObject();
        } catch (FileNotFoundException e) {
            throw new DataImportException("File not found " + FILE_NAME);
        } catch (IOException e) {
            throw new DataImportException("Error reading data from file " + FILE_NAME);
        } catch (ClassNotFoundException e) {
            throw new DataImportException("Incompatible data type in file " + FILE_NAME);
        }
    }

    @Override
    public void exportData(Library library) {
        try (
            FileOutputStream fos = new FileOutputStream(FILE_NAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
        ){
            oos.writeObject(library);
        } catch (FileNotFoundException e) {
            throw new DataExportException("No file " + FILE_NAME);
        } catch (IOException e) {
            throw new DataExportException("Error writing data to file " + FILE_NAME);
        }
    }

}
