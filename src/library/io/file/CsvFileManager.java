package library.io.file;

import library.exception.DataExportException;
import library.exception.DataImportException;
import library.model.Library;
import library.model.Publication;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileManager implements FileManager{
    private static final String FILE_NAME = "Library.csv";

    @Override
    public Library importData() {
        throw new DataImportException("Not implemented yet!");
    }

    @Override
    public void exportData(Library library) {
        Publication[] publications = library.getPublications();
        try (
                var fileWriter = new FileWriter(FILE_NAME);
                var bufferedWriter = new BufferedWriter(fileWriter)
        ) {
            for (Publication publication : publications) {
                bufferedWriter.write(publication.toCsv());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new DataExportException("Error while writing data to file: " + FILE_NAME);
        }


    }
}
