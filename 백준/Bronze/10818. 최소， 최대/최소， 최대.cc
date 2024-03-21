#include <iostream>
#include <string>
#include <sstream>

using namespace std;

int main() {

    int n;
    cin >> n;
    cin.ignore();

    string str;
    getline(cin, str);

    istringstream ss(str);
    string buffer;
    int min = 1000000, max = -1000000;
    while(getline(ss, buffer, ' ')) {
        int num = stoi(buffer);
        if(min > num)
            min = num;
        if(num > max)
            max = num;
    }

    cout << min << ' ' << max;
}