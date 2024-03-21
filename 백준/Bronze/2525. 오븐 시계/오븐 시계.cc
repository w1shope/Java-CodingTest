#include <iostream>
#include <string>
#include <sstream>
#include <vector>

using namespace std;

vector<int> split(string str, char delimiter) {
    vector<int> result;
    istringstream ss(str);

    string buffer;
    while(getline(ss, buffer, ' ')) {
        result.push_back(stoi(buffer));
    }

    return result;
}

int main() {
    string str;
    getline(cin, str);
    int requireTime;
    scanf("%d", &requireTime);

    vector<int> times = split(str, ' ');
    int hour = times[0];
    int minute = times[1];

    minute += requireTime;
    if(minute >= 60) {
        hour += minute / 60;
        minute %= 60;
        if(hour >= 24) {
            hour -= 24;
        }
    }

    cout << hour << " " << minute;
}