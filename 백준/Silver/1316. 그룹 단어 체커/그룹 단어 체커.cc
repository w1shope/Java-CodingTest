#include <iostream>
#include <string>

using namespace std;

void init(int *arr) {
    for (int i = 0; i < 26; i++) {
        arr[i] = -1;
    }
}

int main() {
    int n;
    (cin >> n).ignore();

    int groupCount = n;
    for (int i = 0; i < n; i++) {
        int alphabet[26] = {-1,};
        init(alphabet);
        string str;
        getline(cin, str);

        for (int j = 0; j < str.length(); j++) {
            int idx = str.at(j) - 'a';
            if (alphabet[idx] == -1) {
                alphabet[idx] = j;
            } else {
                if (alphabet[idx] != j - 1) {
                    groupCount--;
                    break;
                } else {
                    alphabet[idx] = j;
                }
            }
        }
    }

    cout << groupCount;
}