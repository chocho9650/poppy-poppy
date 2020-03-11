import java.util.List;

import javax.swing.JOptionPane;

import study.java.dao.TranDao;
import study.java.dao.impl.TranDaoImpl;
import study.java.dao.impl.TranEdaoImpl;
import study.java.helper.RegexHelper;
import study.java.model.Tran;

public class Main2Tran {

	public static void main(String[] args) {
		
		String tranmessage = JOptionPane.showInputDialog("한글을 입력하면 영어로, 영어를 입력하면 한글로 번역할께요!");
		// 임플(구현체) 이 달라야 다른 번역기가 작동되므로.. 이 부분에서 한글과 영어의 판단이 요구됨
		// 한글 , 영어의 판단을 위해서 RegexHelper 가 요구된다. 헬퍼 패키지에 넣어준다.
		tranmessage = tranmessage.replace("?", "");  // ?를 제거해서 정규표현식을 유효하게 만든다.
		tranmessage = tranmessage.replace(".", "");  // .를 제거해서 정규표현식을 유효하게 만든다.
		tranmessage = tranmessage.replace(",", "");  // ,를 제거해서 정규표현식을 유효하게 만든다.
		TranDao dao = null;
		// 띄어쓰기가 되면 모두 한글로만 번역된다.. 한글>영어는 붙여서 써야한다..
		// 이건 정규표현식 검사의 튜닝이 필요한 문제.. " , . ? " 도 포함되면 한글이 아닌걸로 
		// 인식된다.
		if (RegexHelper.getInstance().isKorNum(tranmessage.replace(" ", ""))) {
			dao = new TranDaoImpl();
		} else {
			dao = new TranEdaoImpl();
			}
		List<Tran> list = dao.getTranList(tranmessage);
		
		if (list == null) {
			System.out.println("데이터 수신 실패");
			return;
		}
		
		Tran item = list.get(0);
		
		String message = item.getEng();
		
		// 빼내온 문자열은   " [ \" message \" ] " 이다. 메세지만 빼내고 싶으므로,
		// substring 을 이용하여 시작점의 " 와 마지막에서 찾아지는 " 까지 잘라주면 된다.
		// 시작점은 "부터 짜르므로 포함하기때문에 +1 을 해준다.
		
		message = message.substring(message.indexOf("\"")+1, message.lastIndexOf("\""));
		
		JOptionPane.showMessageDialog(null, message);
		System.out.println(message);
		
	}

}
