## Naive Approach

The approach is to find gcd by traversing a string until there are not common string at the same index, then we do this in each traversal and in each traversal we check whether this string is a valid gcd or not.

### Valid GCD

For a string to be a valid GCD it must follow some properties
1. len(gcd) should divide both string's length completely.
2. and each string could be made by gcd.repeat (string's len / gcd length).

*If this follows for both the string, we can say that this is a **gcd**.*

```java
public String gcdOfStrings(String str1, String str2) {
  String gcd = "";
  String ans = "";

  int l1 = str1.length();
  int l2 = str2.length();

  int minLen = l1 < l2 ? l1 : l2;
  int i = 0;

  while (i < minLen && str1.charAt(i) == str2.charAt(i)) {
    gcd += str1.charAt(i);
    int gcdLen = i + 1;

    if (l1%gcdLen == 0 && l2%gcdLen == 0) {
        if (gcd.repeat(l1/gcdLen).equals(str1) && gcd.repeat(l2/gcdLen).equals(str2))
            ans = gcd;
    }

    i += 1;
  }

  return ans;
}
```

## Better Approach

A better approach to solve this question would be more mathematical. 
First we check whether the strings are in able to GCD or not, this we can check by adding both strings in Left-Right Manner and checking if they are equal.

```java
public boolean gcdAble (String s1, String s2) {
	return (s1 + s2).equals(s2 + s1);
}
```

Then we find the GCD of both lengths, using the Euclidean approach

```java
public int gcd (int a, int b) {
	if (b == 0)
		return a;
	return gcd(b, a % b);
}
```

Then we just return the substring of the length as of gcd, which is our result.

```java
public boolean isGCDAble (String s1, String s2) {
  return !(s1 + s2).equals(s2 + s1);
}

public int gcd (int a, int b) {
  return b == 0 ? a : gcd (b, a % b);
}

public String gcdOfStrings(String str1, String str2) {
  if (isGCDAble(str1, str2)) return "";
  int gcdLen = gcd (str1.length(), str2.length());
  return str1.substring(0, gcdLen);
}
```
