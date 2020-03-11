import javax.swing.JOptionPane;

public class GoodLuck {

	public static void main(String[] args) {

		int[] list = RandomBox.goodLuck();
		String gl = "";
		for (int i = 0; i < list.length; i++) {
			if (i < list.length - 1) {
				gl += list[i] + ",  ";
			} else {
				gl += ""+list[i] ;
			}

		}
		JOptionPane.showMessageDialog(null,gl,"이번주 행운의 번호는?", 1);
	}
}
