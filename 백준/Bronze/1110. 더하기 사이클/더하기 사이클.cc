#include <iostream>
#include <string>

using namespace std;

int main() {
    int n;
    cin >> n;
    int ori = n;

    int cnt = 0;
    while(true) {
        string s = to_string(n);
        if(s.length() < 2) {
            s = "0" + s;
        }
        int first = stoi(s) / 10;
        int second = stoi(s) % 10;
        int result = (second * 10) + ((first + second) % 10);
        cnt++;
        if(result == ori)
            break;
        n = result;
    }

    cout << cnt;
}