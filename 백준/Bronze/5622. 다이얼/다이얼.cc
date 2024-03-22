#include <iostream>
#include <string>

using namespace std;

int getTime(string sArr[], int size, char find) {
    for (int i = 0; i < size; i++) {
        if (sArr[i].find(find) != string::npos) {
            return i += 2;
        }
    }
    return 11;
}

int main() {
    string sArr[8] = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
    int size = sizeof(sArr) / sizeof(string);

    string line;
    cin >> line;

    int sum = 0;
    for (int i = 0; i < line.length(); i++) {
        char c = line.at(i);
        sum += getTime(sArr, size, c);
    }

    cout << sum + line.size();
}