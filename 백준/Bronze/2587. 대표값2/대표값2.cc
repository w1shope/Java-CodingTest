#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    int nums[5];
    for (int i = 0; i < 5; i++) {
        cin >> nums[i];
    }

    sort(nums, nums + 5);

    int sum = 0;
    for (int i = 0; i < 5; i++)
        sum += nums[i];

    cout << sum / 5 << '\n' << nums[5 / 2] << endl;
}