#include <iostream>
#include <string>
#include <sstream>
#include <vector>
#include <map>

using namespace std;

vector<string> split(string s) {
    istringstream ss(s);
    string buffer;
    vector<string> result;
    while (getline(ss, buffer, ' ')) {
        result.push_back(buffer);
    }
    return result;
}

double calculate(vector<string> vector, map<string, double> map) {
    string grade = vector[2];
    if (grade == "P")
        return 0;
    double point = stof(vector[1]);
    return map[grade] * point;
}

double calculateMyPoint(vector<string> vector) {
    if(vector[2] == "P")
        return 0;
    return stof(vector[1]);
}

int main() {
    map<string, double> map;
    map["A+"] = 4.5;
    map["A0"] = 4.0;
    map["B+"] = 3.5;
    map["B0"] = 3.0;
    map["C+"] = 2.5;
    map["C0"] = 2.0;
    map["D+"] = 1.5;
    map["D0"] = 1.0;
    map["F"] = 0.0;

    double calculateSum = 0;
    double myPointSum = 0;
    for (int i = 0; i < 20; i++) {
        string s;
        getline(cin, s);
        calculateSum += calculate(split(s), map);
        myPointSum += calculateMyPoint(split(s));
    }

    printf("%.6f", calculateSum / myPointSum);
}