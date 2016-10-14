package by.tc.nb.bean.entity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.tc.nb.bean.Request;

public class NoteBook {
	
	List<Note> notes= new ArrayList<>();
	List<Note> foundNotes = new ArrayList<>();
	public void add(Note newNote) {
		notes.add(newNote);
		
	}

	public void show() {
		for(Note n:notes){
			System.out.print(n.getDate()+ " ");
			System.out.println(n.getNote());
		}
		if(notes.size()==0){
			System.out.println("There are no notes");
		}
		
		else{System.out.println("Notes count: " + notes.size());}
	}

	public List<Note> findByContent(String searchNote) {
		foundNotes.clear();
		for (Note note : notes) {
			if(note.getNote().contains(searchNote)) {
				foundNotes.add(note);
			}
		}
		return foundNotes;
	}
	public List<Note> findByDate(String searchDate) {
		foundNotes.clear();
		for (Note note : notes) {
			if(note.getDate().equals(searchDate)) {
				foundNotes.add(note);
			}
		}
		return foundNotes;
	}
	
	  public void writeNotebookInFile(String path) throws FileNotFoundException {

	        try (FileWriter writer = new FileWriter(path, true)) {
	            for (Note i : notes) {
	                writer.write('[' + i.getDate() + ']' + " " + i.getNote() + "\r\n");
	                writer.flush(); 
	            }
		        System.out.println("Completed");
	        } catch (IOException ex) {
	            System.out.println("Incorrect path");
	        }

	        
	    }

	public void loadNotebookFromFile(String path) throws IOException {
        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = null;
            String note;
            String date;
            int linesCounter = 0;

            while ((line = reader.readLine()) != null) {
                date = line.substring(line.indexOf('[') + 1, line.indexOf(']'));
                note = line.substring(line.indexOf(']') + 2, line.length());
                Note n = new Note(note, date);
                notes.add(n);
                linesCounter++;
            }

            System.out.println(" Notes count: " + linesCounter);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }

		
	}
	
	
	
	
	
	
	

}
