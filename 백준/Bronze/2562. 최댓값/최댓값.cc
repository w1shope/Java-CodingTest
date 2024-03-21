#include <iostream>

using namespace std;

int main() {
    int highestIdx = 0, max = 0;
    for(int i = 0; i < 9; i++) {
        int num;
        cin >> num;
        if(num > max) {
            highestIdx = i;
            max = num;
        }
    }

    cout << max << "\n" << highestIdx + 1;
}