package guessinggame;

import java.util.HashMap;
import java.util.Map;

public class ProvinceList {

	private static ProvinceList instance;
	private Map<Integer, String> provinceMap;

	private ProvinceList() {
		provinceMap = new HashMap<>();
		provinceMap.put(11, "Cao Bằng");
		provinceMap.put(12, "Lạng Sơn");
		provinceMap.put(14, "Quảng Ninh");
		provinceMap.put(15, "Hải Phòng");
		provinceMap.put(16, "Hải Phòng");
		provinceMap.put(17, "Thái Bình");
		provinceMap.put(18, "Nam Định");
		provinceMap.put(19, "Phú Thọ");
		provinceMap.put(20, "Thái Nguyên");
		provinceMap.put(21, "Yên Bái");
		provinceMap.put(22, "Tuyên Quang");
		provinceMap.put(23, "Hà Giang");
		provinceMap.put(24, "Lào Cai");
		provinceMap.put(25, "Lai Châu");
		provinceMap.put(26, "Sơn La");
		provinceMap.put(27, "Điện Biên");
		provinceMap.put(28, "Hoà Bình");
		provinceMap.put(29, "Hà Nội");
		provinceMap.put(30, "Hà Nội");
		provinceMap.put(31, "Hà Nội");
		provinceMap.put(32, "Hà Nội");
		provinceMap.put(33, "Hà Nội");
		provinceMap.put(40, "Hà Nội");
		provinceMap.put(34, "Hải Dương");
		provinceMap.put(35, "Ninh Bình");
		provinceMap.put(36, "Thanh Hoá");
		provinceMap.put(37, "Nghệ An");
		provinceMap.put(38, "Hà Tĩnh");
		provinceMap.put(43, "Đà Nẵng");
		provinceMap.put(47, "Đắk Lắk");
		provinceMap.put(48, "Đắk Nông");
		provinceMap.put(49, "Lâm Đồng");
		provinceMap.put(41, "TP HCM");
		provinceMap.put(50, "TP HCM");
		provinceMap.put(51, "TP HCM");
		provinceMap.put(52, "TP HCM");
		provinceMap.put(53, "TP HCM");
		provinceMap.put(54, "TP HCM");
		provinceMap.put(55, "TP HCM");
		provinceMap.put(56, "TP HCM");
		provinceMap.put(57, "TP HCM");
		provinceMap.put(58, "TP HCM");
		provinceMap.put(59, "TP HCM");
		provinceMap.put(39, "Đồng Nai");
		provinceMap.put(60, "Đồng Nai");
		provinceMap.put(61, "Bình Dương");
		provinceMap.put(62, "Long An");
		provinceMap.put(63, "Tiền Giang");
		provinceMap.put(64, "Vĩnh Long");
		provinceMap.put(65, "Cần Thơ");
		provinceMap.put(66, "Đồng Tháp");
		provinceMap.put(67, "An Giang");
		provinceMap.put(68, "Kiên Giang");
		provinceMap.put(69, "Cà Mau");
		provinceMap.put(70, "Tây Ninh");
		provinceMap.put(71, "Bến Tre");
		provinceMap.put(72, "Bà Rịa Vũng Tàu");
		provinceMap.put(73, "Quảng Bình");
		provinceMap.put(74, "Quảng Trị");
		provinceMap.put(75, "Thừa Thiên Huế");
		provinceMap.put(76, "Quảng Ngãi");
		provinceMap.put(77, "Bình Định");
		provinceMap.put(78, "Phú Yên");
		provinceMap.put(79, "Khánh Hoà");
		provinceMap.put(80, "NG");
		provinceMap.put(81, "Gia Lai");
		provinceMap.put(82, "Kon Tum");
		provinceMap.put(83, "Sóc Trăng");
		provinceMap.put(84, "Trà Vinh");
		provinceMap.put(85, "Ninh Thuận");
		provinceMap.put(86, "Bình Thuận");
		provinceMap.put(88, "Vĩnh Phúc");
		provinceMap.put(89, "Hưng Yên");
		provinceMap.put(90, "Hà Nam");
		provinceMap.put(92, "Quảng Nam");
		provinceMap.put(93, "Bình Phước");
		provinceMap.put(94, "Bạc Liêu");
		provinceMap.put(95, "Hậu Giang");
		provinceMap.put(97, "Bắc Kạn");
		provinceMap.put(98, "Bắc Giang");
		provinceMap.put(99, "Bắc Ninh");
	}

	public static ProvinceList getInstance() {
		if (instance == null) {
			instance = new ProvinceList();
		}
		return instance;
	}

	public Map<Integer, String> getProvinceMap() {
		return provinceMap;
	}
}
