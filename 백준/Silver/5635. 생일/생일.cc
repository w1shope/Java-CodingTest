#include <iostream>
#include <sstream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> split(string s) {
    stringstream ss(s);
    string buffer;
    vector<int> v;
    getline(ss, buffer, ' ');
    while (getline(ss, buffer, ' ')) {
        v.push_back(stoi(buffer));
    }
    return v;
}

string getName(string s) {
    stringstream ss(s);
    string buffer;
    getline(ss, buffer, ' ');
    return buffer;
}

bool compare(string s1, string s2) {
    vector<int> v1 = split(s1);
    vector<int> v2 = split(s2);

    int year1 = v1[2];
    int year2 = v2[2];
    int month1 = v1[1];
    int month2 = v2[1];
    int day1 = v1[0];
    int day2 = v2[0];

    if (year1 != year2)
        return year1 < year2;

    if (month1 != month2)
        return month1 < month2;

    return day1 < day2;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int n;
    (cin >> n).ignore();

    vector<string> sArr(n);
    for (int i = 0; i < n; i++)
        getline(cin, sArr[i]);

    sort(sArr.begin(), sArr.end(), compare);

    cout << getName(sArr[n - 1]) << "\n" << getName(sArr[0]);
}
