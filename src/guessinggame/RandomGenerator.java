package guessinggame;

import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class RandomGenerator {

	private static RandomGenerator instance;
	private Set<Integer> exclusions;

	public static RandomGenerator getInstance() {
		if (instance == null) {
			instance = new RandomGenerator();
		}
		return instance;
	}

	private int getRandomNumber() {
		Random random = new Random();
		int randomNumber;
		this.exclusions = new HashSet<>();
		exclusions.add(13);
		exclusions.add(42);
		exclusions.add(44);
		exclusions.add(45);
		exclusions.add(46);
		exclusions.add(87);
		exclusions.add(91);
		exclusions.add(96);
		do {
			randomNumber = random.nextInt((99 - 11) + 1) + 11;
		} while (exclusions.contains(randomNumber));
		return randomNumber;
	}

	public int generateRandomNumber() {
		return getRandomNumber();
	}

	private String[] getRandomOptions(int correctIndex) {

		String[] options = new String[4];
		Random random = new Random();

		RandomGenerator randomNumberGenerator = RandomGenerator.getInstance();

		ProvinceList provinceList = ProvinceList.getInstance();
		Map<Integer, String> provinceMap = provinceList.getProvinceMap();

		options[random.nextInt(4)] = provinceMap.get(correctIndex);

		for (int i = 0; i < 4; i++) {
			if (options[i] == null) {
				int randomIndex;
				do {
					randomIndex = randomNumberGenerator.generateRandomNumber();
				} while ((contains(options, provinceMap.get(randomIndex))));
				options[i] = provinceMap.get(randomIndex);
			}
		}
		return options;
	}

	public String[] generateRandomOptions(int correctIndex) {
		return getRandomOptions(correctIndex);
	}

	private boolean contains(String[] array, String number) {
		for (String num : array) {
			if (num == number) {
				return true;
			}
		}
		return false;
	}
}
