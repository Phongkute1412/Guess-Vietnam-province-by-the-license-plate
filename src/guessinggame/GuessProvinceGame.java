package guessinggame;

import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GuessProvinceGame {

	private static int score = 0;

	private static int getMaxTime() {

		int maxTime = 0;
		boolean validInput = false;

		while (!validInput) {
			String input = JOptionPane.showInputDialog(null, "Nhập thời gian tối đa cho mỗi lượt chơi (s):",
					"Thiết lập thời gian", JOptionPane.QUESTION_MESSAGE);
			try {
				maxTime = Integer.parseInt(input);
				if (maxTime > 0) {
					validInput = true;
				} else {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập số nguyên dương!", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập số nguyên dương!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			}
		}
		return maxTime;
	}

	public static void main(String[] args) {

		while (true) {
			String playerName = JOptionPane.showInputDialog(null, "Nhập tên người chơi: ", "Thông tin người chơi",
					JOptionPane.QUESTION_MESSAGE);

			if (playerName.equals("LMO")) {
				System.exit(0);
			}

			int maxTime = getMaxTime();

			String[] options = { "Easy", "Hard" };
			int mode = JOptionPane.showOptionDialog(null, "Chọn chế độ chơi:", "Chọn chế độ",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options);

			playGame(mode, maxTime);

			String[] options1 = { "Chơi lại", "Thoát" };
			int result1 = JOptionPane.showOptionDialog(null, "Điểm số của " + playerName + " là: " + score, "Kết quả",
					JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options1, options1[0]);

			if (result1 == JOptionPane.YES_OPTION) {
				score = 0;
			} else if (result1 == JOptionPane.NO_OPTION || result1 == JOptionPane.CLOSED_OPTION) {
				System.exit(0);
			}
		}
	}

	private static void playGame(int mode, int maxTime) {

		long startTime = System.currentTimeMillis();

		ProvinceList provinceList = ProvinceList.getInstance();
		Map<Integer, String> provinceMap = provinceList.getProvinceMap();
		RandomGenerator randomGenerator = RandomGenerator.getInstance();

		while (true) {
			long currentTime = System.currentTimeMillis();

			if (currentTime - startTime > maxTime * 1000) {
				break;
			}

			int randomNumber = randomGenerator.generateRandomNumber();
			String correctAnswer = provinceMap.get(randomNumber);

			if (mode == 0) {
				String[] options2 = randomGenerator.generateRandomOptions(randomNumber);

				JTextField textField = new JTextField();
				Object[] components = { "<html><body>" + "Biển số xe: " + randomNumber + "<p>" + " - " + options2[0]
						+ "<p>" + " - " + options2[1] + "<p>" + " - " + options2[2] + "<p>" + " - " + options2[3]
						+ "<p>*Lưu ý: - Viết hoa chữ cái đầu của tên tỉnh, thành phố Hồ Chí Minh có thể viết là TP HCM."
						+ "<p>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp - Trả lời đúng +1 điểm, trả lời sai -1 điểm, bỏ qua không mất điểm nào."
						+ "<p>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp - Nhập \"LMO\" (Let Me Out) để thoát Game.",
						textField };
				String[] options = { "Chốt", "Bỏ qua" };
				int result = JOptionPane.showOptionDialog(null, components, "Đoán tỉnh - Easy mode",
						JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

				String playerAnswer = textField.getText();

				if (result == JOptionPane.YES_OPTION) {
					if (playerAnswer.equals("LMO")) {
						System.exit(0);

					} else if (playerAnswer != null && playerAnswer.equalsIgnoreCase(correctAnswer)) {
						JOptionPane.showOptionDialog(null,
								"Chính xác, biển số " + randomNumber + " là của " + correctAnswer, "Đáp án",
								JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
						score++;

					} else {
						JOptionPane.showOptionDialog(null, "Sai, biển số " + randomNumber + " là của " + correctAnswer,
								"Đáp án", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null,
								null);
						score--;
					}

				} else if (result == JOptionPane.NO_OPTION || result == JOptionPane.CLOSED_OPTION) {
					JOptionPane.showOptionDialog(null, "Biển số " + randomNumber + " là của " + correctAnswer, "Đáp án",
							JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
				}

			} else if (mode == 1) {
				JTextField textField = new JTextField();
				Object[] components = { "<html><body>" + "Biển số xe: " + randomNumber
						+ "<p>*Lưu ý: viết hoa chữ cái đầu của tên tỉnh, thành phố Hồ Chí Minh có thể viết là TP HCM.<p>",
						textField };
				String[] options = { "Chốt", "Bỏ qua" };
				int result = JOptionPane.showOptionDialog(null, components, "Đoán tỉnh - Hard mode",
						JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

				String playerAnswer = textField.getText();

				if (result == JOptionPane.YES_OPTION) {
					if (playerAnswer.equals("LMO")) {
						System.exit(0);

					} else if (playerAnswer != null && playerAnswer.equalsIgnoreCase(correctAnswer)) {
						JOptionPane.showOptionDialog(null,
								"Chính xác, biển số " + randomNumber + " là của " + correctAnswer, "Đáp án",
								JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
						score++;

					} else {
						JOptionPane.showOptionDialog(null, "Sai, biển số " + randomNumber + " là của " + correctAnswer,
								"Đáp án", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null,
								null);
						score--;
					}

				} else if (result == JOptionPane.NO_OPTION || result == JOptionPane.CLOSED_OPTION) {
					JOptionPane.showOptionDialog(null, "Biển số " + randomNumber + " là của " + correctAnswer, "Đáp án",
							JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
				}
			}
		}
		if (score < 0) {
			score = 0;
		}
	}
}