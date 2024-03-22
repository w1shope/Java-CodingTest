#include <iostream>
#include <string>

using namespace std;

int main() {
    string words[8] = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    string lines;
    getline(cin, lines);

    int count = 0;
    while (!lines.empty()) {
        bool flag = false;
        for (int i = 0; i < sizeof(words) / sizeof(string); i++) {
            if (lines.substr(0, words[i].length()).find(words[i]) != string::npos) {
                lines = lines.substr(words[i].length());
                count++;
                flag = true;
                break;
            }
        }
        if (!flag) {
            lines = lines.substr(1);
            count++;
        }
    }

    cout << count;
}