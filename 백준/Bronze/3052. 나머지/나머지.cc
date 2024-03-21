#include <iostream>
#include <set>

using namespace std;

int main() {

    set<int> sets;
    for(int i = 0; i < 10; i++) {
        int num;
        cin >> num;
        sets.insert(num % 42);
    }

    cout << sets.size();
}