#include <iostream>
#include <set>

using namespace std;

int main() {
    int n, m;
    cin >> n >> m;

    set<int> s;

    for (int i = 0; i < n + m; i++) {
        int num;
        cin >> num;
        s.insert(num);
    }

    int totalSize = n + m;
    int unionSIze = s.size();
    int intersectionSize = totalSize - unionSIze;
    int symmetricDiffSize = unionSIze - intersectionSize;

    cout << symmetricDiffSize;
}