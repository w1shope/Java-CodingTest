#include <bits/stdc++.h>

using namespace std;

int main() {
    string line;
    string find;

    getline(cin, line); getline(cin, find);

    int s = 0;
    int cnt = 0;
    while(true) {
        if(line.find(find) != string::npos) {
            int idx = line.find(find);
            line = line.substr(idx+ find.length());
            cnt++;
        }else
            break;
    }

    cout <<cnt;

}