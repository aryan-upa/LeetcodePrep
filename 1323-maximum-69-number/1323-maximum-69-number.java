class Solution {
    public int maximum69Number (int num) {
		return switch (num) {
			case 9, 6 -> 9;
			case 99, 96, 69 -> 99;
			case 66 -> 96;
			case 999, 996, 969, 699 -> 999;
			case 966, 696 -> 996;
			case 669 -> 969;
			case 666 -> 966;
			case 9999, 9996, 9969, 9699, 6999 -> 9999;
			case 9966, 9696, 6996 -> 9996;
			case 9669, 6969 -> 9969;
			case 9666, 6966 -> 9966;
			case 6699 -> 9699;
			case 6696 -> 9696;
			case 6669 -> 9669;
			case 6666 -> 9666;
			default -> 0;
		};
    }
}