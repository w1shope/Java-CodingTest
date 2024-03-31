#include <iostream>
#include <set>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    string s;
    getline(cin, s);

    set<string> set;

    for (int i = 0; i < s.size(); i++) {
        string str = "";
        for (int j = i; j < s.size(); j++) {
            str += s.at(j);
            set.insert(str);
        }
    }

    cout << set.size();
}