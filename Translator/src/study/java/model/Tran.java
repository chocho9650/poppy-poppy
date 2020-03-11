package study.java.model;

public class Tran {
	
	private String eng = null;

	public Tran(String eng) {
		super();
		this.eng = eng;
	}

	public String getEng() {
		return eng;
	}

	public void setEng(String eng) {
		this.eng = eng;
	}

	@Override
	public String toString() {
		return "Tran [eng=" + eng + "]";
	}

}
