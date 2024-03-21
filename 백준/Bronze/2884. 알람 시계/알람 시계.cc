#include <iostream>
#include <string>
#include <vector>
#include <sstream>

using namespace std;

vector<int> split(string str, char delimiter) {
    vector<int> result;
    istringstream ss(str);

    string buffer;
    while(getline(ss, buffer, delimiter)) {
        result.push_back(stoi(buffer));
    }

    return result;
}

int main() {
    string str;
    getline(cin, str);

    vector<int> times = split(str, ' ');
    int hour = times[0];
    int minute = times[1];

    if(minute - 45 >= 0) {
        minute -= 45;
    } else {
        if(hour == 0) {
            hour = 23;
        } else {
            hour -= 1;
        }
        minute = 60 - 45 + minute;
    }
    cout << hour << " " << minute;

}