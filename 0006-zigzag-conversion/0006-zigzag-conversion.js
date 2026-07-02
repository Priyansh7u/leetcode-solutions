/**
 * @param {string} s
 * @param {number} numRows
 * @return {string}
 */
var convert = function(s, numRows) {
    if (numRows === 1 || numRows >= s.length) {
        return s;
    }

    const rows = new Array(numRows).fill("");

    let currentRow = 0;
    let goingDown = true;

    for (const char of s) {
        rows[currentRow] += char;

        if (currentRow === 0) {
            goingDown = true;
        } else if (currentRow === numRows - 1) {
            goingDown = false;
        }

        currentRow += goingDown ? 1 : -1;
    }

    return rows.join("");
};