#include <iostream>

using namespace std;

int main() {
    int nums[9][9];
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            cin >> nums[i][j];
        }
    }

    int highestRowIdx = 0, highestColumIdx, highestNum = -1;
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            if(nums[i][j] > highestNum) {
                highestRowIdx = i;
                highestColumIdx = j;
                highestNum = nums[i][j];
            }
        }
    }

    cout << highestNum << endl;
    cout << highestRowIdx + 1 << ' ' << highestColumIdx + 1;
}