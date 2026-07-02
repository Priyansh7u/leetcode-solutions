var filterOccupiedIntervals = function(occupiedIntervals, freeStart, freeEnd) {
    occupiedIntervals.sort((a, b) => a[0] - b[0]);
    let merged = [];
    for (let interval of occupiedIntervals) {
        if (!merged.length || merged[merged.length - 1][1] < interval[0] - 1) {
            merged.push(interval);
        } else {
            merged[merged.length - 1][1] = Math.max(merged[merged.length - 1][1], interval[1]);
        }
    }
    let res = [];
    for (let [s, e] of merged) {
        if (s <= freeEnd && e >= freeStart) {
            if (s < freeStart) res.push([s, freeStart - 1]);
            if (e > freeEnd) res.push([freeEnd + 1, e]);
        } else {
            res.push([s, e]);
        }
    }
    return res;
};