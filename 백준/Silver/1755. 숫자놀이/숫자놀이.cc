#include <bits/stdc++.h>

using namespace std;

string arr[10] = {
        "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
};

int main() {
    int n, m; cin >> n >> m;

    map<string, int> map;
    for(int num = n; num <= m; num++) {
        if(num / 10 == 0) { // 1 <= num <= 9
            map[arr[num % 10]] = num;
        } else {
            string s = arr[num / 10] + " " +  arr[num % 10];
            map[s] = num;
        }
    }


    int idx = 0;
    for(auto iter = map.begin(); iter != map.end(); iter++) {
        idx++;
        cout << iter->second << " ";
        if(idx == 10) {
            idx = 0;
            cout << "\n";
        }
    }
}