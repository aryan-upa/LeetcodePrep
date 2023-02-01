int i = 0;
​
while (i < minLen && str1.charAt(i) == str2.charAt(i)) {
gcd += str1.charAt(i);
int gcdLen = i + 1;
​
if (l1%gcdLen == 0 && l2%gcdLen == 0) {
if (gcd.repeat(l1/gcdLen).equals(str1) && gcd.repeat(l2/gcdLen).equals(str2))
ans = gcd;
}
​
i += 1;
}
​
return ans;
}
```
​
## Better Approach
​
A better approach to solve this question would be more mathematical.
First we check whether the strings are in able to GCD or not, this we can check by adding both strings in Left-Right Manner and checking if they are equal.
​
```
public boolean gcdAble (String s1, String s2) {
return (s1 + s2).equals(s2 + s1);
}
```
​
Then we find the GCD of both lengths, using the Euclidean approach
​
```
public int gcd (int a, int b) {
if (b == 0)
return a;
return gcd(b, a % b);
}
```
​
Then we just return the substring of the length as of gcd, which is our result.
​
```
​
```