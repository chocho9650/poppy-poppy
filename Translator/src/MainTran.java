import java.util.List;

import javax.swing.JOptionPane;

import study.java.dao.TranDao;
import study.java.dao.impl.TranDaoImpl;
import study.java.model.Tran;

public class MainTran {

	public static void main(String[] args) {
		
		String tranmessage = JOptionPane.showInputDialog("한글을 입력하면 영어로 번역 해줄께요!");
		TranDao dao = new TranDaoImpl();
		List<Tran> list = dao.getTranList(tranmessage);
		
		if (list == null) {
			System.out.println("데이터 수신 실패");
			return;
		}
		
		Tran item = list.get(0);
		
		String message = item.getEng();
		
		message = message.substring(message.indexOf("\"")+1, message.lastIndexOf("\""));
		
		JOptionPane.showMessageDialog(null, message);
		System.out.println(message);
	}
	

}
