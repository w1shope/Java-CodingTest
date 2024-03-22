#include <iostream>
#include <string>

using namespace std;

int main() {
    string str;
    getline(cin, str);

    int alphabet[26];
    for(int i = 0; i < 26; i++) {
        alphabet[i] = -1;
    }

    for(int i = 0; i < str.length(); i++) {
        char c = str.at(i) - 'a';
        alphabet[c] = alphabet[c] == -1 ? i : alphabet[c];
    }

    for(int i = 0; i < 26; i++) {
        cout << alphabet[i] << ' ';
    }
}