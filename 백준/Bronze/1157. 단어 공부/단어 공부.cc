#include <iostream>
#include <string>

using namespace std;

void init(int *alphabet) {
    for (int i = 0; i < 26; i++) {
        alphabet[i] = 0;
    }
}

int main() {
    string str;
    getline(cin, str);

    int alphabet[26];
    init(alphabet);

    for (int i = 0; i < str.length(); i++) {
        char c = tolower(str.at(i));
        alphabet[c - 'a'] += 1;
    }

    bool exist = false;
    int idx = 0;
    int max = 0;
    for (int i = 0; i < 26; i++) {
        if (alphabet[i] == 0) {
            continue;
        }
        if (max == alphabet[i]) {
            exist = true;
        } else if (alphabet[i] > max) {
            exist = false;
            idx = i;
            max = alphabet[i];
        }
    }

    if (exist) {
        cout << '?';
    } else {
        cout << (char) toupper('a' + idx);
    }
}