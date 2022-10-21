​
## Approach 2
```
public int[] plusOne(int[] digits) {
int pos = digits.length - 1;
​
digits[pos]++;
​
int sum, carry = 0;
while (pos >= 0) {
sum = digits[pos] + carry;
digits[pos] = sum % 10;
carry = sum / 10;
pos --;
}
​
if (carry != 1)
return digits;
​
int[] res = new int[digits.length + 1];
res[0] = carry;
System.arraycopy(digits, 0, res, 1, digits.length);
​
return res;
}
```
​
## Approach 3
```
​
```