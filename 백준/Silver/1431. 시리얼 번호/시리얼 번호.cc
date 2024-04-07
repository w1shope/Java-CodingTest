#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

bool compare(string s1, string s2) {
    if (s1.length() != s2.length())
        return s1.length() < s2.length();

    int sum1 = 0, sum2 = 0;
    for (int i = 0; i < s1.length(); i++) {
        char c1 = s1.at(i);
        if (c1 >= '0' && c1 <= '9')
            sum1 += c1 - '0';

        char c2 = s2.at(i);
        if (c2 >= '0' && c2 <= '9')
            sum2 += c2 - '0';
    }

    if (sum1 != sum2)
        return sum1 < sum2;

    return s1 < s2;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int n;
    (cin >> n).ignore();

    string sArr[n];
    for (int i = 0; i < n; i++)
        cin >> sArr[i];

    sort(sArr, sArr + n, compare);

    for (int i = 0; i < n; i++)
        cout << sArr[i] << "\n";
}