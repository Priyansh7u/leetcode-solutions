var minTimeMaxPower = function(n, edges, power, cost, source, target) {
    if (source === target) return [0, power];

    const g = Array.from({ length: n }, () => []);
    for (const [u, v, w] of edges) g[u].push([v, w]);

    class Heap {
        constructor() {
            this.a = [];
        }
        cmp(x, y) {
            if (x[0] !== y[0]) return x[0] < y[0];
            return x[2] > y[2];
        }
        push(x) {
            let a = this.a;
            a.push(x);
            let i = a.length - 1;
            while (i) {
                let p = (i - 1) >> 1;
                if (this.cmp(a[p], a[i])) break;
                [a[p], a[i]] = [a[i], a[p]];
                i = p;
            }
        }
        pop() {
            let a = this.a;
            let r = a[0];
            let x = a.pop();
            if (a.length) {
                a[0] = x;
                let i = 0;
                while (true) {
                    let l = i * 2 + 1;
                    let rr = l + 1;
                    let s = i;
                    if (l < a.length && this.cmp(a[l], a[s])) s = l;
                    if (rr < a.length && this.cmp(a[rr], a[s])) s = rr;
                    if (s === i) break;
                    [a[i], a[s]] = [a[s], a[i]];
                    i = s;
                }
            }
            return r;
        }
        size() {
            return this.a.length;
        }
    }

    const best = Array.from({ length: n }, () => []);
    const pq = new Heap();

    pq.push([0, source, power]);

    while (pq.size()) {
        const [t, u, p] = pq.pop();

        let dominated = false;
        for (const [tt, pp] of best[u]) {
            if (tt <= t && pp >= p) {
                dominated = true;
                break;
            }
        }
        if (dominated) continue;

        let arr = [];
        for (const [tt, pp] of best[u]) {
            if (!(tt >= t && pp <= p)) arr.push([tt, pp]);
        }
        arr.push([t, p]);
        best[u] = arr;

        if (u === target) return [t, p];

        if (p < cost[u]) continue;

        const np = p - cost[u];

        for (const [v, w] of g[u]) {
            pq.push([t + w, v, np]);
        }
    }

    return [-1, -1];
};