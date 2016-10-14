package by.tc.nb.command.impl;

import by.tc.nb.bean.AddNoteRequest;
import by.tc.nb.bean.FindNotesRequest;
import by.tc.nb.bean.FindNotesResponse;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.entity.Note;
import by.tc.nb.bean.entity.NoteBook;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.source.NoteBookProvider;

public class FindNotes implements Command {
	NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();

	@Override
	public Response execute(Request request) throws CommandException {
		FindNotesRequest req = null;
		if (request instanceof FindNotesRequest) {
			req = (FindNotesRequest) request;
		} else {
			throw new CommandException("Wrong request");
		}

		
		
		//Note newNote = new Note(note, date);
		FindNotesResponse response = new FindNotesResponse();
		
		if (req.getCommandName().equals("FIND_NOTES_BY_CONTENT")) {
			String note = req.getNote();
			response.setFindBook(noteBook.findByContent(note));
		}

		else {
			String date = req.getDate();
			noteBook.findByDate(date);
			
			response.setFindBook(noteBook.findByDate(date));
		}

		
		response.setErrorStatus(false);
		response.setResultMessage("All OK!");
		
		return response;

	}

}
