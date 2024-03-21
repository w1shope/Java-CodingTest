#include <iostream>
#include <string>
#include <cmath>

using namespace std;

void calculate(string num1, string num2, int nums[]) {
    for(int i = 2; i >= 0; i--) {
        int sum = 0;
        for(int j = 0; j < 3; j++) {
            int calculate = ((int)num1[j] - '0') * ((int)num2[i] - '0') * pow(10, 2 - j);
            sum += calculate;
        }
        nums[i] = sum;
    }
}


int main() {
    string num1;
    getline(cin, num1);
    string num2;
    getline(cin, num2);

    int nums[3];
    calculate(num1, num2, nums);
    int sum = 0;
    for(int i = 2; i >= 0; i--) {
        sum += nums[i] * pow(10, 2-i);
        cout << nums[i] << endl;
    }
    cout << sum;
}