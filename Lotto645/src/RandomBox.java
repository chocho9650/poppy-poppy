import java.util.Arrays;

import study.java.helper.Util;

public class RandomBox {

	public static int[] goodLuck() {
		
		int lotto[] = new int[6];

		for (int i=0;i<lotto.length;i++) {
			lotto[i] = Util.getInstance().random(1, 45);	
			for (int j=0;j<i;j++) {
				if (lotto[i]==lotto[j]) {
					i--;
					break;
				}
			}
			
		}
		Arrays.sort(lotto);
		
		return lotto;
	}
}
