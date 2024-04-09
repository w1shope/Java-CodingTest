#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int k;
    cin >> k;
    for(int i = 0; i < k; i++) {
        int n;
        cin >> n;
        int students[n];

        for (int j = 0; j < n; j++)
            cin >> students[j];

        sort(students, students + n);

        int gap = 0;
        for(int j = 1; j < n; j++) {
            gap = max(gap, students[j] - students[j - 1]);
        }

        cout << "Class " << i + 1 << "\n";
        cout << "Max " << students[n - 1] << ", Min " << students[0] << ", Largest gap " << gap << "\n";
    }
}