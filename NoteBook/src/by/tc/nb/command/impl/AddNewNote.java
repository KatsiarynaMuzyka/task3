package by.tc.nb.command.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import by.tc.nb.bean.AddNoteRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.entity.Note;
import by.tc.nb.bean.entity.NoteBook;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.source.NoteBookProvider;

public class AddNewNote implements Command {
		private Date date = new Date();
	    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
	    private String dateStr = dateFormat.format(date);
	@Override
	public Response execute(Request request) throws CommandException {
		AddNoteRequest req = null;
		if(request instanceof AddNoteRequest){
			req = (AddNoteRequest)request;
		}else{
			throw new CommandException("Wrong request");
		}
		
		String note = req.getNote();
		Note newNote = new Note(note, dateStr);
		
		NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
		noteBook.add(newNote);
		
		
		Response response = new Response();
		response.setErrorStatus(false);
		response.setResultMessage("All OK!");
		
		
		return response;
	}

}
