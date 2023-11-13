package HW_011123;

public class TimeComplexity {
    /*
    * a)

for (int i = 0; i < n; ++i) {
  for (int j = 1; j < m; ++j) {
    a[i][j]++;
  }
}  ---------  O(n * m)

b)

for (int i = 0; i < n-1; ++i) {
  for (int j = 0; j < n-i; ++j) {
    a[i][j]++;
  }
} ---------  O(n^2)

c)

for (int i = 0; i < n; ++i) {
  for (int j = 1; j < n; j *= 3) {
    a[i][j]++;
  }
} ---------  O(n * log(n))

d)

for (int i = 0; i < 1000; ++i) {
  for (int j = 1; j < n; ++j) {
    ++count;
  }
} ---------  O(n)

e)

for (int i = 0; i < n; ++i) {
  for (int j = 0; j < n/3; ++j) {
    matrx[i][i]++;
  } ---------  O(n^2)
}
*/
}
