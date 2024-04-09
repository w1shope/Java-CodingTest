#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int w, h;
    cin >> h >> w;

    int c;
    cin >> c;

    vector<int> wv;
    vector<int> hv;
    wv.push_back(0); wv.push_back(w);
    hv.push_back(0); hv.push_back(h);

    for (int i = 0; i < c; i++) {
        int a, b;
        cin >> a>> b;
        if (a == 0)
            wv.push_back(b);
        else
            hv.push_back(b);
    }

    sort(wv.begin(), wv.end());
    sort(hv.begin(), hv.end());

    int result = 0;
    for (int i = 1; i < hv.size(); i++) {
        for (int j = 1; j < wv.size(); j++) {
            int x = hv[i] - hv[i - 1];
            int y = wv[j] - wv[j - 1];
            result = max(result, x * y);
        }
    }

    cout << result;
}