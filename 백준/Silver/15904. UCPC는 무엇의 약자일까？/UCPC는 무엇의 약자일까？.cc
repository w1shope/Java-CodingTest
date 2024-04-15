#include <bits/stdc++.h>

using namespace std;

vector<char> split(string input) {
    stringstream ss(input);
    string buffer;
    vector<char> result;
    while(getline(ss, buffer, ' ')) {
        for(int i = 0; i < buffer.length(); i++) {
            if(buffer.at(i) >= 'A' && buffer.at(i) <= 'Z')
                result.push_back(buffer.at(i));
        }
    }
    return result;
}

int main() {
    string input;
    getline(cin, input);

    vector<char> words = split(input);
    queue<string> que;

    for(int i = 0; i < words.size(); i++) {
        char c = words[i];
        if(c == 'U') {
            if(que.empty())
                que.push("U");
        } else if(c == 'C') {
            if(que.empty())
                continue;
            if(que.back() == "U" || que.back() == "P")  {
                que.push("C");
            }
        } else if(c == 'P') {
            if(que.empty())
                continue;
            if(que.back() == "C")
                que.push("P");
        }
    }

    if(que.size() >= 4)
        cout << "I love UCPC";
    else
        cout << "I hate UCPC";

    return 0;
}