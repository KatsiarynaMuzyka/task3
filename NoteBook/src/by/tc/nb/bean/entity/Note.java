package by.tc.nb.bean.entity;

public class Note {
	private String note;
	private String date;
	
	public Note(String note, String date) {
		this.note = note;
		this.date = date;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


}
