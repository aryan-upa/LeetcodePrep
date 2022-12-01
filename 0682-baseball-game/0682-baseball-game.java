/*
    Why are we using stack here?
    We are using stack here because:
        1. we are maintaining the sequence of the records and keeping the last one handy.
        2. we are always looking on the left the of the input and thus we never have to look for the 
            upcoming operations beforehand.
*/

class Solution {
    public int calPoints(String[] operations) {
		int[] stack = new int[operations.length];

		int i = -1;
		for (String op : operations) {
			switch (op) {
				case "D" -> {stack[i+1] = stack[i] * 2; i+=1;}
				case "C" -> i-=1;
				case "+" -> {stack[i+1] = stack[i] + stack[i - 1]; i += 1;}
				default -> stack[++i] = Integer.parseInt(op);
			}
		}

		int sum = 0;
		for (int j = i; j >= 0; j --)
			sum += stack[j];

		return sum;
	}
}