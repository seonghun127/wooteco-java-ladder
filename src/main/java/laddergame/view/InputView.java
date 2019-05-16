package laddergame.view;

import java.util.Scanner;

public class InputView {
	public static final Scanner SCANNER = new Scanner(System.in);

	private InputView() {

	}

	public static String inputPlayers() {
		System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
		return SCANNER.nextLine();
	}

	public static String inputLadderHeight() {
		System.out.println("최대 사다리 높이는 몇 개인가요?");
		return SCANNER.nextLine();
	}

	public static String inputResults() {
		System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요");
		return SCANNER.nextLine();
	}
}
