#include <iostream>
#include <deque>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int n;
    cin >> n;

    deque<pair<int, int> > dq;
    for(int i = 0; i < n; i++ ){
        int num; cin >> num;
        dq.push_back(make_pair(i + 1, num));
    }

    while(!dq.empty()) {
        pair<int, int> p = dq.front();
        cout << p.first << ' ';
        int move_count = p.second;
        dq.pop_front();
        if(move_count > 0) {
            for(int i = 0; i < move_count - 1; i++) {
                dq.push_back(dq.front());
                dq.pop_front();
            }
        } else {
            move_count *= -1;
            for(int i = 0; i< move_count ; i++) {
                dq.push_front(dq.back());
                dq.pop_back();
            }
        }
    }
}