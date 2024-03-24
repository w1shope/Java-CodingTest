#include <iostream>
#include <sstream>
#include <vector>

using namespace std;

vector<int> split(string buffer) {
    vector<int> result;
    string line;
    istringstream iss(buffer);
    while (getline(iss, line, ' ')) {
        result.push_back(stoi(line));
    }
    return result;
}

int main() {
    string buffer;
    getline(cin, buffer);
    vector<int> vector = split(buffer);

    int x = vector[0];
    int y = vector[1];
    int w = vector[2];
    int h = vector[3];

    int originX = x - 0;
    int originY = y - 0;
    int boundaryX = w - x;
    int boundaryY = h - y;

    cout << min(min(originX, originY), min(boundaryX, boundaryY));
}